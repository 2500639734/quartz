package com.quartz.manage;

import com.quartz.enumeration.QuartzClassifyEnum;
import com.quartz.pojo.QuartzInfo;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

import java.util.List;

/**
 * Quartz任务管理类
 */
@Slf4j
public class QuartzManage {

    // 任务调度器
    private static Scheduler scheduler = SchedulerFactoryBuild.getScheduler();

    /**
     * 添加任务调度
     * @param jobName 任务名称,建议不要使用中文命名
     * @param jobClass 任务实现类
     * @param cycle 定时任务执行周期表达式
     */
    public static void add (String jobName, Class jobClass, String cycle) {
        JobKey jobKey = JobKey.jobKey(jobName, QuartzClassifyEnum.JOB_GROUP_NAME.getName());
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).storeDurably().build();

        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, QuartzClassifyEnum.TRIGGER_GROUP_NAME.getName());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobDetail)
                .withSchedule(CronScheduleBuilder.cronSchedule(cycle).withMisfireHandlingInstructionDoNothing())
                .build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }

    }

    /**
     * 启动调度器,注意只有当调度器启动后任务才会执行
     * 并且所有加入到调度器的任务会全部启动
     */
    public static void start () {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 调度器中移除指定的任务
     * @param jobName 任务名称,建议不要使用中文命名
     */
    public static void delete (String jobName) {
        JobKey jobKey = JobKey.jobKey(jobName, QuartzClassifyEnum.JOB_GROUP_NAME.getName());
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, QuartzClassifyEnum.TRIGGER_GROUP_NAME.getName());

        try {
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 重新设置定时任务的执行周期,前提是该任务已经加入到调度器
     * 注意重新设置后下个周期才会执行
     * @param jobName 任务名称,建议不要使用中文命名
     * @param cycle 定时任务执行周期表达式
     */
    public static void setCycle (String jobName, String cycle) {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, QuartzClassifyEnum.TRIGGER_GROUP_NAME.getName());
        try {
            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            cronTrigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cycle).withMisfireHandlingInstructionDoNothing())
                    .build();
            scheduler.rescheduleJob(triggerKey, cronTrigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 暂停指定的任务,使用默认的misfire策略
     * @param jobName 任务名称,建议不要使用中文命名
     */
    public static void pauseJob (String jobName) {
        JobKey jobKey = JobKey.jobKey(jobName, QuartzClassifyEnum.JOB_GROUP_NAME.getName());
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 恢复被暂停的任务,使用默认的misfire策略
     * @param jobName 任务名称,建议不要使用中文命名
     */
    public static void resumeJob (String jobName) {
        JobKey jobKey = JobKey.jobKey(jobName, QuartzClassifyEnum.JOB_GROUP_NAME.getName());
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 调度器是否是备用模式
     * @return true 是 || false 否
     */
    public static boolean isInStandbyMode () {
        try {
            return scheduler.isInStandbyMode();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 调度器是否已启动
     * @return true 是 || false 否
     */
    public static boolean isStarted () {
        try {
            return scheduler.isStarted();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 调度器是否已关闭
     * @return true 是 || false 否
     */
    public static boolean isShutdown () {
        try {
            return scheduler.isShutdown();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 初始化定时任务, 加入任务后立即启动调度器
     * @param quartzInfoList 定时任务列表
     */
    public static void init (List<QuartzInfo> quartzInfoList) {
        init(quartzInfoList, true);
    }

    /**
     * 初始化定时任务
     * @param quartzInfoList 定时任务列表
     * @param isStart 加入任务后是否立即启动调度器
     */
    public static void init (List<QuartzInfo> quartzInfoList, boolean isStart) {
        try {
            for (QuartzInfo quartzInfo : quartzInfoList) {
                String classPath = quartzInfo.getClassPath();
                Class clazz = Class.forName(classPath);
                add(quartzInfo.getCode(), clazz, quartzInfo.getCycle());

                if (!isStarted()) {
                    start();
                }
            }
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

}
