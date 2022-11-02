package com.zz.test.utils;

import lombok.Data;

@Data
public class JsonResult {
    private String code;
    private String msg;
    private Object data;

    public JsonResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

