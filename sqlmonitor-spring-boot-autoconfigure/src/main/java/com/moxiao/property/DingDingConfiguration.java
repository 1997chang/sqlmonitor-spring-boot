package com.moxiao.property;

import com.moxiao.sqlmonitor.notice.dingding.DingDingType;

import java.util.Properties;

class DingDingConfiguration {

    private static final String PREFIX = "dingdingConfig.";

    Properties properties = new Properties();

    /**
     * 钉钉机器人的秘钥
     */
    private String secret;

    /**
     * 钉钉机器人的token
     */
    private String accessToken;

    /**
     * 钉钉@的人的手机号，多个用逗号隔开
     */
    private String atMobiles;

    /**
     * 钉钉通知是否进行收集。默认为FALSE。FALSE：一个慢SQL通知一次，TRUE：多个慢SQL合并通知一次，钉钉通知有限制。
     */
    private boolean collectionAble;

    /**
     * 钉钉通知的类型，默认MARKDOWN
     */
    private DingDingType type;


    public void setSecret(String secret) {
        properties.setProperty(PREFIX + "secret", secret);
    }
    
    public void setAccessToken(String accessToken) {
        properties.setProperty(PREFIX + "accessToken", accessToken);
    }
    
    public void setAtMobiles(String atMobiles) {
        properties.setProperty(PREFIX + "atMobiles", atMobiles);
    }
    
    public void setType(DingDingType type) {
        properties.setProperty(PREFIX + "type", type.name());
    }
    
    public void setCollectionAble(boolean collectionAble) {
        properties.setProperty(PREFIX + "collectionAble", Boolean.toString(collectionAble));
    }

    public String getSecret() {
        return secret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAtMobiles() {
        return atMobiles;
    }

    public boolean isCollectionAble() {
        return collectionAble;
    }

    public DingDingType getType() {
        return type;
    }
}
