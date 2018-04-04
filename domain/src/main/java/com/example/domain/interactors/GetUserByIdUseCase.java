package com.example.domain.interactors;

import android.util.Log;

import com.example.domain.entity.DataEntity;
import com.example.domain.entity.UserEntity;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;


public class GetUserByIdUseCase extends BaseUseCase{
    private UserRepository userRepository;

    //Inject пишем перед конструктором, пометка для дагера
    @Inject
    public GetUserByIdUseCase(PostExecutionThread postExecutionThread, @Named("rep2") UserRepository userRepository) {
        super(postExecutionThread);
        Log.e("GetUserByIdUseCase","between postExecutionThread and UserRepository");
        this.userRepository = userRepository;
        Log.e("GetUserByIdUseCase","finish creating");
    }

    public GetUserByIdUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecution) {
        super(postExecutionThread, threadExecution);
    }

    public io.reactivex.Observable<UserEntity> get(String id){
                return userRepository.get(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

    public Observable<List<UserEntity>> get(){
        return userRepository.get()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

    public Observable<List<DataEntity>> loadtrends(){
        Log.e("TrendsUseCase","loadTrends");
        return userRepository.loadTrends()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

}
