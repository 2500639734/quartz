package com.quartz.base;

import com.quartz.enumeration.QuartzResultEnum;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public abstract class BaseQuartz implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        job();
    }

    public abstract QuartzResultEnum job ();

}
