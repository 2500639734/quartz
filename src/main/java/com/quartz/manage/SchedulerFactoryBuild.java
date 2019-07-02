package com.quartz.manage;

import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerFactoryBuild {

    private SchedulerFactoryBuild () {

    }

    private static class SchedulerFactoryHolder {
        private final static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    }

    public static SchedulerFactory getSchedulerFactory() {
        return SchedulerFactoryHolder.schedulerFactory;
    }

}
