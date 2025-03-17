package com.gangan.demofordeviceatlas.framework;

import java.util.HashMap;
import java.util.Objects;

public class AjaxResult extends HashMap<String, Object> {

    public AjaxResult(int code, String msg, Object data) {
        super.put("code", code);
        super.put("msg", msg);
        super.put("data", data);
    }

    public static AjaxResult success() {
        return AjaxResult.success("success");
    }

    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg, null);
    }

    public static AjaxResult success(Object data) {
        return AjaxResult.success("success", data);
    }

    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(200, msg, data);
    }


    public static AjaxResult warn(String msg) {
        return AjaxResult.warn(msg, null);
    }

    public static AjaxResult warn(String msg, Object data) {
        return new AjaxResult(601, msg, data);
    }


    public static AjaxResult error() {
        return AjaxResult.error("operation request faild");
    }

    public static AjaxResult error(String msg) {
        return AjaxResult.error(msg, null);
    }

    public static AjaxResult error(String msg, Object data) {
        return new AjaxResult(500, msg, data);
    }

    public static AjaxResult error(int code, String msg) {
        return new AjaxResult(code, msg, null);
    }


    public boolean isSuccess() {
        return Objects.equals(this.get("code"), 200);
    }

    public boolean isError() {
        return !isSuccess();
    }

    @Override
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
