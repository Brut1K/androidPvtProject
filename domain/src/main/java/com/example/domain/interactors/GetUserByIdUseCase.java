package com.example.domain.interactors;

import com.example.domain.entity.UserEntity;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;


public class GetUserByIdUseCase extends BaseUseCase{
    private UserRepository userRepository;

    //Inject пишем перед конструктором, пометка для дагера
    @Inject
    public GetUserByIdUseCase(PostExecutionThread postExecutionThread, @Named("rep2") UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public GetUserByIdUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecution) {
        super(postExecutionThread, threadExecution);
    }

    public io.reactivex.Observable<UserEntity> get(String id){
                return userRepository.get(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

}
