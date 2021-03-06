package cn.zjc.util;

import cn.zjc.entity.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2016/1/19-14:48
 */
public class JsonUtil {

    /**
     * 特性: (1)格式化日期:yyyy-MM-dd HH:mm:ss
     * (2)把map里面的空值输出为null
     * (3)把为null的数字输出为0
     * (4)把为null的List输出为""
     * (5)把为null的字符串输出为""
     */
    private static final SerializerFeature[] WriteNullValueFeatures = {
            SerializerFeature.WriteDateUseDateFormat
            , SerializerFeature.WriteMapNullValue
            , SerializerFeature.WriteNullNumberAsZero
            , SerializerFeature.WriteNullListAsEmpty
            , SerializerFeature.WriteNullStringAsEmpty};

    /**
     * 特性: 格式化日期:yyyy-MM-dd HH:mm:ss
     */
    private static final SerializerFeature[] Features = {
            SerializerFeature.WriteDateUseDateFormat};


    /**
     * object转化为Json字符串,不保留空值，修正日期表示
     *
     * @param object
     * @return
     */
    public static String toJson(final Object object) {
        if (null != object) {
            return JSON.toJSONString(object, Features);
        } else
            return null;
    }


    /**
     * object转化为Json字符串,保留空值，修正日期表示
     *
     * @param object
     * @return
     */
    public static String toJsonWithNull(final Object object) {
        if (null != object) {
            return JSON.toJSONString(object, WriteNullValueFeatures);
        } else
            return null;
    }


    /**
     * 用fastjson 将json字符串解析为一个 JavaBean
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> T getBean(final String jsonString, Class<T> cls) {
        if ("".equals(jsonString) || jsonString == null) {
            return null;
        } else {
            T t = null;
            try {
                t = JSON.parseObject(jsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t;
        }
    }

    /**
     * 用fastjson 将json字符串 解析成为一个 List<JavaBean> 及 List<String>
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> List<T> getBeans(final String jsonString, Class<T> cls) {
        if ("".equals(jsonString) || jsonString == null) {
            return null;
        } else {
            List<T> list = new ArrayList<>();
            try {
                list = JSON.parseArray(jsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
    }


    /**
     * 用fastjson 将jsonString 解析成 List<Map<String,Object>>
     *
     * @param jsonString
     * @return
     */
    public static List<Map<String, Object>> getListMap(final String jsonString) {
        if ("".equals(jsonString) || jsonString == null) {
            return null;
        } else {
            List<Map<String, Object>> list = new ArrayList<>();
            try {
                // 两种写法
                // list = JSON.parseObject(jsonString, new
                // TypeReference<List<Map<String, Object>>>(){}.getType());
                list = JSON.parseObject(jsonString,
                        new TypeReference<List<Map<String, Object>>>() {
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

    }


    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName(null);
        user.setBirth(new Date());
        System.out.println(toJsonWithNull(user));
    }

}
