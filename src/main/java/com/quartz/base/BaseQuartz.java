package com.quartz.base;

import com.quartz.enumeration.QuartzResultEnum;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public abstract class BaseQuartz implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        job();
    }

    public abstract QuartzResultEnum job ();

}
