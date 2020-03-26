package com.aims.ser.filter;


import com.aims.common.utils.StringUtil;
import com.aims.core.exception.CommonErrorCode;
import com.aims.core.exception.ResultPO;
import com.aims.ser.annotion.ValidatedPtInfo;
import com.aims.ser.security.ResponseRender;

import com.aims.ser.service.PatientHisInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ValidatePtInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(ValidatePtInterceptor.class);

    @Autowired
    private PatientHisInfoService patientHisInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        logger.info("=========进入拦截器=========");
        intercept(handler, request, response);
        return true;
    }

    /**
     * 拦截器处理注解业务逻辑
     * @param handler
     * @return
     */
    private void intercept(Object handler, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //拦截方法注解
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的@ValidatedPtInfo注解
            ValidatedPtInfo validatedPtInfo = handlerMethod.getMethod().getAnnotation(ValidatedPtInfo.class);
            //所有传参数的key
            Map<String, String[]> parameterMap = request.getParameterMap();
            // 如果标记了@ValidatedPtInfo注解
            if (validatedPtInfo != null ) {
                //患者未入科验证
                String validatedPtId = validatedPtInfo.ptId();
                if (parameterMap.containsKey(validatedPtId)){
                    if (!StringUtil.isEmpty(request.getParameter(validatedPtId)) && !patientHisInfoService.isPatientIn(request.getParameter(validatedPtInfo.ptId()))){
                        ResponseRender.renderResponse(response, new ResultPO(CommonErrorCode.E300013));
                    }
                }
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO
    }

}
