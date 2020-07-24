package com.example.swagger.user.exception;

/**
 * @类描述:邮箱为空异常
 * @创建人:xiejs
 * @创建时间:2020-7-24 13:36:44
 */
public class MailIsNullException extends RuntimeException {
    public MailIsNullException(String message) {
        super(message);
    }
}
