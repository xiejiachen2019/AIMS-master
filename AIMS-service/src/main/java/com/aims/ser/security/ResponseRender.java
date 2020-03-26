package com.aims.ser.security;

import com.aims.common.utils.FastJsonUtil;
import com.aims.core.exception.ResultPO;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author Jerry
 * @Date 2019/9/18 14:58
 **/
public class ResponseRender {

    /**
     * 渲染返回 token 页面,因为前端页面接收的都是Result对象，故使用application/json返回
     *
     * @param response
     * @throws IOException
     */
    public static void renderResponse(HttpServletResponse response, ResultPO resultPO) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        String str = FastJsonUtil.toJSONString(resultPO);
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}
