package com.example.yinshengnan.suting_a.sn.bean.Request;


import com.ttlock.bl.sdk.entity.LockData;

public class LockFormRequest {


    /**
     * data : {"lockDataJson":"string"}
     * lockAlias : string
     */

    private LockData data;
    private String name;

    public LockData getData() {
        return data;
    }

    public void setData(LockData data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
