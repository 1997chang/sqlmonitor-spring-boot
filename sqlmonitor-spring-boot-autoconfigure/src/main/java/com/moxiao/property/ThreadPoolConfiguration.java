package com.moxiao.property;

import java.util.Properties;

public class ThreadPoolConfiguration {

    private static final String PREFIX = "threadPoolConfig";
    
    /**
     * 核心线程池数量，默认为10
     */
    private Integer corePoolSize;

    /**
     * 额外的线程保持的时间，单位ms，默认为60_000
     */
    private Long keepAliveTime;

    /**
     * 阻塞队列的最大长度，默认为：Integer.MAX_VALUE
     */
    private Integer queueCapacity;
    
    /**
     * 拒绝执行的策略，ABORT,LOGGER,DISCARD,DISCARD_OLDEST,CALLER_RUNNER，默认为LOGGER
     */
    private String rejectedExecutionPolicy;

    /**
     * 是否守护线程，默认为TRUE
     */
    private boolean daemon;

    /**
     * 是否等待任务完成之后关闭线程，默认FALSE
     */
    private boolean waitTasksToCompleteOnShutdown;

    /**
     * 如果等待任务完成，则最大等待时间，默认为0
     */
    private Integer awaitTerminationSeconds;

    Properties properties = new Properties();

    public Integer getAwaitTerminationSeconds() {
        return awaitTerminationSeconds;
    }

    public void setAwaitTerminationSeconds(Integer awaitTerminationSeconds) {
        properties.setProperty(PREFIX + "awaitTerminationSeconds", awaitTerminationSeconds.toString());
    }

    public Integer getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(Integer corePoolSize) {
        properties.setProperty(PREFIX + "corePoolSize", corePoolSize.toString());
    }

    public Long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(Long keepAliveTime) {
        properties.setProperty(PREFIX + "keepAliveTime", keepAliveTime.toString());
    }

    public String getRejectedExecutionPolicy() {
        return rejectedExecutionPolicy;
    }

    public void setRejectedExecutionPolicy(String rejectedExecutionPolicy) {
        properties.setProperty(PREFIX + "rejectedExecutionPolicy", rejectedExecutionPolicy);
    }

    public Integer getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(Integer queueCapacity) {
        properties.setProperty(PREFIX + "queueCapacity", queueCapacity.toString());
    }

    public boolean isDaemon() {
        return daemon;
    }

    public void setDaemon(boolean daemon) {
        properties.setProperty(PREFIX + "daemon", Boolean.toString(daemon));
    }

    public boolean isWaitTasksToCompleteOnShutdown() {
        return waitTasksToCompleteOnShutdown;
    }

    public void setWaitTasksToCompleteOnShutdown(boolean waitTasksToCompleteOnShutdown) {
        properties.setProperty(PREFIX + "waitTasksToCompleteOnShutdown", Boolean.toString(waitTasksToCompleteOnShutdown));
    }

    
}
