package com.aims.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.List;
import java.util.Map;

public class FastJsonUtil {

    private FastJsonUtil(){throw new AssertionError();}

    private static final SerializeConfig config;

    static {
        config = new SerializeConfig();
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer());
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
    }
    private static final SerializerFeature[] features = {
            SerializerFeature.WriteMapNullValue,    //输出空置字段
            SerializerFeature.WriteNullListAsEmpty, //list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero,//数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse,// Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty  // 字符类型字段如果为null，输出为""，而不是null
    };

    /**
     * 按照特性和序列化配置将对象转换为字符串
     * @param obj
     * @return string
     */
    public static String toJSONString(Object obj) {
        return JSON.toJSONString(obj, config, features);
    }

    /**
     * 按照序列化配置将对象装换为字符串
     * @param obj
     * @return str
     */
    public static String toJSONNoFeatures(Object obj) {
        return JSON.toJSONString(obj, config);
    }


    /**
     * 按照默认特性进行转为对象
     * @param str
     * @return object
     */
    public static Object toBean(String str) {
        return JSON.parse(str);
    }

    /**
     * 按照指定clazz转化为对象
     * @param str
     * @param clazz
     * @param <T>
     * @return t
     */
    public static <T> T toBean(String str, Class<T> clazz) {
        return JSON.parseObject(str, clazz);
    }
    /**
     * 字符串转换为数组
     * @param str
     * @param <T>
     * @return object[]
     */
    public static <T> Object[] toArray(String str) {
        return toArray(str, null);
    }

    /**
     * 字符串转换为对象数组
     * @param str
     * @param clazz
     * @param <T>
     * @return object[]
     */
    public static <T> Object[] toArray(String str, Class<T> clazz) {
        return JSON.parseArray(str, clazz).toArray();
    }

    /**
     * 字符串转化List
     * @param str
     * @param clazz
     * @param <T>
     * @return List
     */
    public static <T> List<T> toList(String str, Class<T> clazz) {
        return JSON.parseArray(str, clazz);
    }

    /**
     * 将javabean转化为序列化的json字符串
     * @param keyvalue
     * @return object
     */
    public static Object beanToJson(KeyValue keyvalue) {
        String textJson = JSON.toJSONString(keyvalue);
        Object objectJson  = JSON.parse(textJson);
        return objectJson;
    }

    /**
     * 将string转化为序列化的json字符串
     * @param str
     * @return object
     */
    public static Object strToJson(String str) {
        Object objectJson  = JSON.parse(str);
        return objectJson;
    }

    /**
     * json字符串转化为map
     * @param str
     * @return map
     */
    public static Map stringToCollect(String str) {
        Map m = JSONObject.parseObject(str);
        return m;
    }

    /**
     * 将map转化为string
     * @param map
     * @return string
     */
    public static String collectToString(Map map) {
        String str = JSONObject.toJSONString(map);
        return str;
    }
}
