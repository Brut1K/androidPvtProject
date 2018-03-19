package com.example.domain.interactors;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public abstract class BaseUseCase {

// поток в котором будем получать результаты в presentation слое
    protected Scheduler postExecutionThread;

// поток в котором будем выполнять все сложные запросы, другой поток не UI
    protected Scheduler threadExecution;

    public BaseUseCase(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.io();
    }

    public BaseUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecution) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.from(threadExecution);
    }
}
