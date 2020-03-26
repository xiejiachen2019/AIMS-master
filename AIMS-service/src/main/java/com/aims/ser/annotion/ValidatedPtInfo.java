package com.aims.ser.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 患者入科验证注解
 * @Author Cao
 * @Date 2019/10/19
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatedPtInfo {
    /**
     * ptId内传注解下面方法的获取患者id参数名
     * 备注：仅支持一层属性，不支持多层传递过来的属性值
     * @return
     */
    String ptId();
}
