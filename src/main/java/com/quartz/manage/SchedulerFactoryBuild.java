package com.quartz.manage;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

@Slf4j
public class SchedulerFactoryBuild {

    private SchedulerFactoryBuild () {

    }

    private static class SchedulerFactoryHolder {
        private final static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    }

    public static SchedulerFactory getSchedulerFactory() {
        return SchedulerFactoryHolder.schedulerFactory;
    }

    public static Scheduler getScheduler () {
        try {
            return getSchedulerFactory().getScheduler();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

}
