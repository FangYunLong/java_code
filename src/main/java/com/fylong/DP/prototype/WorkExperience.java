package com.fylong.DP.prototype;

import java.io.Serializable;

/**
 * Created by Fang on 2019/8/12.
 */
public class WorkExperience implements Serializable{
    private String workDate;
    private String company;

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorkDate() {
        return workDate;
    }

    public String getCompany() {
        return company;
    }

}
