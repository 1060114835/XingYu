package com.meet.xingyu.model.route;

import android.graphics.drawable.Drawable;

public class MyAndApplyBean {
    public String data;
    public String time;
    public String week;
    public String start;
    public String end;
    //性别：男：0，女：1
    public int captainSex;
    public String captain;
    public int teammateSex;
    public String teammate;
    public Drawable applyHead;
    public int applySex;
    public String applyId;
    public Boolean selected;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getCaptainSex() {
        return captainSex;
    }

    public void setCaptainSex(int captainSex) {
        this.captainSex = captainSex;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public int getTeammateSex() {
        return teammateSex;
    }

    public void setTeammateSex(int teammateSex) {
        this.teammateSex = teammateSex;
    }

    public String getTeammate() {
        return teammate;
    }

    public void setTeammate(String teammate) {
        this.teammate = teammate;
    }

    public Drawable getApplyHead() {
        return applyHead;
    }

    public void setApplyHead(Drawable applyHead) {
        this.applyHead = applyHead;
    }

    public int getApplySex() {
        return applySex;
    }

    public void setApplySex(int applySex) {
        this.applySex = applySex;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
