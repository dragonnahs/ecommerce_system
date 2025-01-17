package com.baozi.common.result;

import lombok.Data;

@Data
public class R<T> {
    private Integer code;
    private String message;
    private T data;

    private R() {}

    public static <T> R<T> ok() {
        R<T> r = new R<>();
        r.setCode(0);
        r.setMessage("success");
        return r;
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setCode(0);
        r.setMessage("success");
        r.setData(data);
        return r;
    }

    public static <T> R<T> error(String message) {
        R<T> r = new R<>();
        r.setCode(-1);
        r.setMessage(message);
        return r;
    }
} 