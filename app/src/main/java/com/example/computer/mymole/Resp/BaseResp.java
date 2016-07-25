package com.example.computer.mymole.Resp;

/**
 * Created by computer on 2016/7/22.
 */
public class BaseResp {
    /** ok*/private String msg;

    /** 1*/private int status;

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
