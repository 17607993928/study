package com.example.swagger.common.utils;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("返回对象")
public class AjaxMessage<T> {
    @ApiModelProperty(
            value = "状态值",
            example = "true"
    )
    private boolean status;
    @ApiModelProperty("数据")
    private T data;
    @ApiModelProperty(
            value = "提示信息",
            example = "操作成功"
    )
    private String message;
    @ApiModelProperty(
            value = "状态码",
            example = "01"
    )
    private String code;

    public AjaxMessage() {
    }

    public AjaxMessage(boolean status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public AjaxMessage(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public static AjaxMessage success() {
        return success("操作成功");
    }

    public static AjaxMessage success(String message) {
        AjaxMessage cr = new AjaxMessage(true, message, "200");
        return cr;
    }

    public static AjaxMessage error() {
        AjaxMessage cr = new AjaxMessage(false, "操作失败", "500");
        return cr;
    }

    public AjaxMessage data(T data) {
        this.data = data;
        return this;
    }

    public static AjaxMessage error(String message, String code) {
        return error(false, code, message);
    }

    public static AjaxMessage error(boolean status, String code, String message) {
        AjaxMessage cr = new AjaxMessage(status, message, code);
        return cr;
    }

    public static AjaxMessage error(String message) {
        return error(false, "0501", message);
    }

    public boolean isStatus() {
        return this.status;
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }
}
