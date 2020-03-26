package com.aims.ser.annotion;

import com.aims.common.utils.FastJsonUtil;
import com.aims.core.exception.AIMSException;
import com.aims.core.exception.ResultPO;
import com.aims.ser.filter.ResponseResultInterceptor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author Jerry
 * @Date 2019/11/1 9:41
 **/
//@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = sra.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
        return responseResultAnn == null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ServletRequestAttributes sra = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
        ResponseResult responseResultAnn = (ResponseResult) sra.getRequest().getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);

        Class<? extends ResultPO> resultClazz = responseResultAnn.value();

        if (resultClazz.isAssignableFrom(ResultPO.class)) {
            if (body instanceof AIMSException) {
                AIMSException defaultErrorResult = (AIMSException) body;
                return new ResultPO(defaultErrorResult.getCode(), defaultErrorResult.getMessage(), null);
            } else if (body instanceof String) {
                return FastJsonUtil.toJSONString(ResultPO.success(body));
            }

            return ResultPO.success(body);
        }

        return body;
    }
}
