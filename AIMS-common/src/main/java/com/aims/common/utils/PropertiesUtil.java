package com.aims.common.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {

    /** 配置文件的路径 */
    public String configPath;

    /** 配置文件对象  */
    public Properties props;

    /** 构造函数  */
    public PropertiesUtil(String fileName) {
        init(fileName, "UTF-8");
    }

    /** 构造函数  */
    public PropertiesUtil(String fileName, String encoding) {
        init(fileName, encoding);
    }

    /** 初始化  */
    public PropertiesUtil init(String fileName, String encoding) {

        this.configPath		=	fileName;

        InputStream inputStream = null;
        try {
            inputStream 	= 	Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (inputStream == null){
                throw new IllegalArgumentException("Properties file not found in classpath: " + fileName);
            }

            props	= 	new Properties();
            props.load(new InputStreamReader(inputStream, encoding));

            return this;
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file.", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据key值读取配置的值
     * @param key
     * @return
     * @throws IOException
     */
    public String readValue(String key) throws IOException {
        return  props.getProperty(key);
    }

    /**
     * 读取properties的全部信息
     * @throws FileNotFoundException 配置文件没有找到
     * @throws IOException 关闭资源文件，或者加载配置文件错误
     *
     */
    public Map<String,String> readAllProperties() throws FileNotFoundException,IOException  {

        //保存所有的键值
        Map<String,String> map	=	new HashMap<String,String>();
        Enumeration<?> en 		= 	props.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            String Property = props.getProperty(key);
            map.put(key, Property);
        }

        return map;
    }

    /**
     * 设置某个key的值,并保存至文件
     * @param key key值
     * @return key 键对应的值
     * @throws IOException
     */
    public void setValue(String key,String value) {

        InputStream fis 	= 	null;
        OutputStream fos 	= 	null;
        try{
            Properties prop 	= 	new Properties();
            fis 	= 	new FileInputStream(this.configPath);

            // 从输入流中读取属性列表（键和元素对）
            prop.load(fis);

            // 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            fos 	= 	new FileOutputStream(this.configPath);
            prop.setProperty(key, value);

            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            prop.store(fos,"last update");

        } catch (Exception e){
            e.printStackTrace();
        } finally{
            //关闭文件
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

