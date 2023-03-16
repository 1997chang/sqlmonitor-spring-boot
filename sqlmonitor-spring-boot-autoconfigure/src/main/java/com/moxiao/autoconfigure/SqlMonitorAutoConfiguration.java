package com.moxiao.autoconfigure;

import com.moxiao.property.SqlMonitorAutoProperties;
import com.moxiao.sqlmonitor.interceptor.SqlMonitorInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@EnableConfigurationProperties(SqlMonitorAutoProperties.class)
@ConditionalOnBean(SqlSessionFactory.class)
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class SqlMonitorAutoConfiguration {
    
    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;
    
    @Autowired
    private SqlMonitorAutoProperties sqlMonitorAutoProperties;

    @PostConstruct
    public void addSqlMonitor() {
        SqlMonitorInterceptor sqlMonitorInterceptor = new SqlMonitorInterceptor();
        sqlMonitorInterceptor.setProperties(sqlMonitorAutoProperties.properties);
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
            if (!containInterceptor(configuration, sqlMonitorInterceptor)) {
                configuration.addInterceptor(sqlMonitorInterceptor);
            }
        }
    }

    private boolean containInterceptor(org.apache.ibatis.session.Configuration configuration, Interceptor interceptor) {
        try {
            return configuration.getInterceptors().contains(interceptor);
        } catch (Exception e) {
            return false;
        }
    }
    
}
