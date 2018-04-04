package com.example.data.repository;

import android.content.Context;
import android.util.Log;

import com.example.data.db.AppDatabase;
import com.example.data.db.UserDao;
import com.example.data.entity.Data;
import com.example.data.entity.Root;
import com.example.data.entity.User;
import com.example.data.net.RestService;
import com.example.domain.entity.DataEntity;
import com.example.domain.entity.UserEntity;
import com.example.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

@Singleton
public class UserRepositoryImpl implements UserRepository {
    private static String LOG = "UserRepositoryImpl";


    private Context context;
    private RestService restService;
    private UserDao userDao;
    private long lastTimeUpdate;

    public UserRepositoryImpl(Context context, RestService restService,AppDatabase appDatabase) {
        this.context = context;
        this.restService = restService;
        this.userDao = appDatabase.getUserDao();
    }

    @Override
    public Observable<UserEntity> get(String id) {


        return restService.loadUserById(id)
                .map(new Function<User, UserEntity>() {
                    @Override
                    public UserEntity apply(User user) throws Exception {
                        return new UserEntity(user.getUsername(), user.getAge(), user.getProfileUrl());
                    }
                });
//              return Observable.create(new ObservableOnSubscribe<UserEntity>() {
//            @Override
//            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
//                Thread.sleep(5000);
//                UserEntity entity = new UserEntity("super userName",20,"https://pp.userapi.com/c10611/u14788377/-6/y_7fdf5e4c.jpg");
//                emitter.onNext(entity);
//                emitter.onComplete();
//            }
//        });


    }

    @Override
    public Observable<List<UserEntity>> get() {
        return  restService.loadUsers()
                .doOnNext(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> userList) throws Exception {
                        Log.e(LOG,"doOnNext");
                        userDao.deleteAll();
                        userDao.insert(userList);
                    }
                })
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends List<User>>>() {
                    @Override
                    public ObservableSource<? extends List<User>> apply(Throwable throwable) throws Exception {
                        Log.e(LOG,"onErrorResumeNext");
                        return userDao.getAll().toObservable().take(1);
                    }
                })
                .map(new Function<List<User>, List<UserEntity>>() {
                    @Override
                    public List<UserEntity> apply(List<User> users) throws Exception {
                        Log.e(LOG,"map");

                        List<UserEntity> list = new ArrayList<>();
                        for (User user : users) {
                            list.add(new UserEntity(user.getUsername(),
                                    user.getAge(),
                                    user.getProfileUrl()));

                        }
                        return list;
                    }
                })




                ;

    }


    @Override
    public Observable<List<DataEntity>> loadTrends() {
        Log.e("DataRepositoryImpl","loadTrends");
        return restService.loadTrends()
                .map(new Function<Root, List<DataEntity>>() {
                    @Override
                    public List<DataEntity> apply(Root root) throws Exception {
                        List<Data> data = root.getDataList();
                        List<DataEntity> dataEntities = new ArrayList<>();
                        for(Data d: data){
                            Log.e(LOG,d.getId());
                            Log.e(LOG,d.getImages().getOriginal().getUrl());
                            dataEntities.add(new DataEntity(d.getId(),d.getImages().getOriginal().getUrl()));
                        }
                        return dataEntities;
                    }
                });




    }


    @Override
    public Completable save() {
        return null;
    }

    @Override
    public Completable remove() {
        return null;
    }
}
