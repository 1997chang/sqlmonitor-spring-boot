package com.moxiao.property;

import java.util.Properties;

class ElasticsearchConfiguration {

    private static final String PREFIX = "esConfig.";

    Properties properties = new Properties();

    /**
     * ES的通信地址，带https或者http，多个中间用逗号隔开，
     */
    private String uri;

    /**
     * ES的用户名
     */
    private String username;

    /**
     * ES的密码
     */
    private String password;

    /**
     * ES证书的地址,ES8之后开始使用证书
     */
    private String certFile;

    /**
     * ES的指纹
     */
    private String fingerPrint;

    /**
     * ES版本是否低于7.11，不包含7.11。默认为FALSE
     */
    private boolean versionLessEleven;

    /**
     * 分片的数量，默认为：3
     */
    private Integer numberOfShards;

    /**
     * ES索引的备份数量，默认为：1
     */
    private Integer numberOfReplicas;

    /**
     * ES存储的索引名称，默认为：slow-sql-monitor
     */
    private String indexName;

    public void setUri(String uri) {
        properties.setProperty(PREFIX + "uri", uri);
    }

    public void setUsername(String username) {
        properties.setProperty(PREFIX + "username", username);
    }

    public void setPassword(String password) {
        properties.setProperty(PREFIX + "password", password);
    }

    public void setCertFile(String certFile) {
        properties.setProperty(PREFIX + "certFile", certFile);
    }

    public void setFingerPrint(String fingerPrint) {
        properties.setProperty(PREFIX + "fingerPrint", fingerPrint);
    }

    public void setVersionLessEleven(boolean versionLessEleven) {
        properties.setProperty(PREFIX + "versionLessEleven", Boolean.toString(versionLessEleven));
    }

    public void setNumberOfShards(Integer numberOfShards) {
        properties.setProperty(PREFIX + "numberOfShards", numberOfShards.toString());
    }

    public void setNumberOfReplicas(Integer numberOfReplicas) {
        properties.setProperty(PREFIX + "numberOfReplicas", numberOfReplicas.toString());
    }

    public void setIndexName(String indexName) {
        properties.setProperty(PREFIX + "indexName", indexName);
    }

    public String getUri() {
        return uri;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCertFile() {
        return certFile;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public boolean isVersionLessEleven() {
        return versionLessEleven;
    }

    public Integer getNumberOfShards() {
        return numberOfShards;
    }

    public Integer getNumberOfReplicas() {
        return numberOfReplicas;
    }

    public String getIndexName() {
        return indexName;
    }
}
