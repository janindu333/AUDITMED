package com.iot.panel.utill;

import io.reactivex.Scheduler;

public interface IScheduler {
    Scheduler mainThread();
    Scheduler backgroundThread();
}
