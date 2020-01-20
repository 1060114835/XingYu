package com.meet.xingyu.model.my;

import android.graphics.drawable.Drawable;

public class MyBean {
    //用于表示此bean所处的item的位置
    public int position;

    //黄色提醒
    private Drawable yellowRemind;
    //灰色提醒
    private Drawable grayRemind;

    //普通用户标识
    private String openId;
    //普通用户名称
    private String nickName;
    //性别
    private int sex;
    //个人资料省份
    private String province;
    //个人资料城市
    private String city;
    //个人资料国家
    private String country;
    //用户头像
    private Drawable headImg;
    //用户统一标识
    private String unionId;
    //聊天消息条数
    private String messageCount;
    //位置消息条数
    private String locationCount;
    //起始站点
    private String startStation;
    //目标站点
    private String endStation;
    //发布时间
    private String publishTime;
    //消息发布距离
    private String longTime;

    public MyBean(Drawable headImg,String nickName,String messageCount,String startStation,String endStation,String locationCount){
        this.headImg = headImg;
        this.nickName = nickName;
        this.messageCount = messageCount;
        this.startStation = startStation;
        this.endStation = endStation;
        this.locationCount = locationCount;
    }

    public MyBean(Drawable headImg,String nickName,String startStation,String endStation,String publishTime,String longTime,int flag){
        this.headImg = headImg;
        this.nickName = nickName;
        this.startStation = startStation;
        this.endStation = endStation;
        this.publishTime = publishTime;
        this.longTime = longTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Drawable getHeadImg() {
        return headImg;
    }

    public void setHeadImg(Drawable headImgUrl) {
        this.headImg = headImgUrl;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(String messageCount) {
        this.messageCount = messageCount;
    }

    public String getLocationCount() {
        return locationCount;
    }

    public void setLocationCount(String locationCount) {
        this.locationCount = locationCount;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Drawable getYellowRemind() {
        return yellowRemind;
    }

    public void setYellowRemind(Drawable yellowRemind) {
        this.yellowRemind = yellowRemind;
    }

    public Drawable getGrayRemind() {
        return grayRemind;
    }

    public void setGrayRemind(Drawable grayRemind) {
        this.grayRemind = grayRemind;
    }

    public String getLongTime() {
        return longTime;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime;
    }
}
