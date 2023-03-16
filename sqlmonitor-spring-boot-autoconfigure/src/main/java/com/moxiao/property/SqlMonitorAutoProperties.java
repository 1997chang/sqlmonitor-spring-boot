package com.moxiao.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.Properties;

import static com.moxiao.property.SqlMonitorAutoProperties.SQL_MONITOR_PREFIX;

@ConfigurationProperties(prefix = SQL_MONITOR_PREFIX)
public class SqlMonitorAutoProperties {
    
    public static final String SQL_MONITOR_PREFIX = "sqlmonitor";

    public final Properties properties = new Properties();

    /**
     * 慢SQL语句阈值，默认5000ms，大于该值成为慢SQL
     */
    private Integer executeTimeLimit;

    /**
     * 慢SQL监控时间间隔，默认5000ms
     */
    private Integer slowSqlMonitor;

    /**
     * 执行栈匹配的前缀
     */
    private String monitorStackPrefix;

    /**
     * 执行栈匹配的类包名
     */
    private Class<?> monitorStackClass;

    /**
     * 执行栈的最大长度，默认30
     */
    private Integer maxStackLength;
    
    /**
     * 执行SQL语句的存储策略，默认LOGGER。可选参数有ES，LOGGER。也可以是自提供的类名，继承StorePolicy类。多个中间逗号隔开
     */
    private String storePolicy;

    /**
     * 慢SQL的通知策略，默认为DINGDING，可选参数为DINGDING。也可以是自提供的类名，继承NoticePolicy，多个中间逗号隔开
     */
    private String noticePolicy;

    /**
     * 钉钉机器人
     */
    @NestedConfigurationProperty
    private DingDingConfiguration dingdingConfig;

    /**
     * ES配置
     */
    @NestedConfigurationProperty
    private ElasticsearchConfiguration esConfig;

    /**
     * 线程池配置
     */
    @NestedConfigurationProperty
    private ThreadPoolConfiguration threadPoolConfig;
    
    public Integer getExecuteTimeLimit() {
        return executeTimeLimit;
    }

    public void setExecuteTimeLimit(Integer executeTimeLimit) {
        this.executeTimeLimit = executeTimeLimit;
        properties.setProperty("executeTimeLimit", executeTimeLimit.toString());
    }

    public Integer getSlowSqlMonitor() {
        return slowSqlMonitor;
    }

    public void setSlowSqlMonitor(Integer slowSqlMonitor) {
        properties.setProperty("slowSqlMonitor", slowSqlMonitor.toString());
    }

    public String getMonitorStackPrefix() {
        return monitorStackPrefix;
    }

    public void setMonitorStackPrefix(String monitorStackPrefix) {
        properties.setProperty("monitorStackPrefix", monitorStackPrefix);
    }

    public Class<?> getMonitorStackClass() {
        return monitorStackClass;
    }

    public void setMonitorStackClass(Class<?> monitorStackClass) {
        properties.setProperty("monitorStackClass", monitorStackClass.getName());
    }

    public Integer getMaxStackLength() {
        return maxStackLength;
    }

    public void setMaxStackLength(Integer maxStackLength) {
        properties.setProperty("maxStackLength", maxStackLength.toString());
    }

    public String getStorePolicy() {
        return storePolicy;
    }

    public void setStorePolicy(String storePolicy) {
        properties.setProperty("storePolicy", storePolicy);
    }

    public String getNoticePolicy() {
        return noticePolicy;
    }

    public void setNoticePolicy(String noticePolicy) {
        properties.setProperty("noticePolicy", noticePolicy);
    }

    public void setDingdingConfig(DingDingConfiguration dingdingConfig) {
        properties.putAll(dingdingConfig.properties);
    }

    public void setEsConfig(ElasticsearchConfiguration esConfig) {
        properties.putAll(esConfig.properties);
    }

    public void setThreadPoolConfig(ThreadPoolConfiguration threadPoolConfig) {
        this.threadPoolConfig = threadPoolConfig;
    }

    public DingDingConfiguration getDingdingConfig() {
        return dingdingConfig;
    }

    public ElasticsearchConfiguration getEsConfig() {
        return esConfig;
    }

    public ThreadPoolConfiguration getThreadPoolConfig() {
        return threadPoolConfig;
    }
}
