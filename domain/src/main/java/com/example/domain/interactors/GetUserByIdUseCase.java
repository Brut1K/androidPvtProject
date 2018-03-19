package com.example.domain.interactors;

import com.example.domain.entity.UserEntity;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.UserRepository;





public class GetUserByIdUseCase extends BaseUseCase{
    private UserRepository userRepository;


    public GetUserByIdUseCase(PostExecutionThread postExecutionThread, UserRepository userRepository) {
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
