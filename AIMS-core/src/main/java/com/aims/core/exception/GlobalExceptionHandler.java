package com.aims.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(AIMSException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultPO aimsException(HttpServletRequest request, AIMSException e) {
        log.error("系统业务异常:", e);
        return new ResultPO(e.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultPO methodArgumentException(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("请求参数验证异常:", e);
        return new ResultPO(CommonErrorCode.E100001.getCode(), e.getBindingResult().getFieldError().getDefaultMessage(), null);
    }

    /**
     * 参数绑定异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultPO bindingException(HttpServletRequest request, BindException e) {
        log.error("请求参数验证异常:", e);
        return new ResultPO(CommonErrorCode.E100001.getCode(), e.getBindingResult().getFieldError().getDefaultMessage(), null);
    }

    /**
     * 上传文件大小超过限制异常
     */
    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultPO fileExceedsSize(HttpServletRequest request, RuntimeException e) {
        log.error("运行时异常:", e);
        return new ResultPO(CommonErrorCode.E100000.getCode(), "上传的文件大小超过限制", null);
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultPO notFount(HttpServletRequest request, RuntimeException e) {
        log.error("运行时异常:", e);
        return new ResultPO(CommonErrorCode.E100000.getCode(), CommonErrorCode.E100000.getMsg(), null);
    }
}
