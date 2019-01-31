package com.demo.basic.serialize;

import java.io.Serializable;

public class Family implements Serializable {
    private String daddy;
    private String mammy;
    private String son;

    public String getDaddy() {
        return daddy;
    }

    public void setDaddy(String daddy) {
        this.daddy = daddy;
    }

    public String getMammy() {
        return mammy;
    }

    public void setMammy(String mammy) {
        this.mammy = mammy;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }
}
