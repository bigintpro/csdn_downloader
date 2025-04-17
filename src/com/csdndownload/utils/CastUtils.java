package com.csdndownload.utils;

import com.sunday.commons.utils.string.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 类转换工具
 *
 * @author zhudesheng
 * @version 1.0
 * @date 2022/8/31 2:42 PM
 */
public class CastUtils {

    /**
     * 安全的ob转为List
     *
     * @param obj 待转换对象
     * @param <T> 目录类型
     * @return list<T>
     */
    public static <T> List<T> objToList(Object obj, Class<T> tClass) {
        if (obj == null || tClass == null) {
            return null;
        }
        if (obj instanceof List) {
            List<?> list = (List<?>) obj;
            if (CollectionUtils.isEmpty(list)) {
                return new ArrayList<>();
            }
            List<T> result = new ArrayList<>();
            for (Object item : list) {
                if (tClass.isInstance(item)) {
                    T cast = tClass.cast(item);
                    result.add(cast);
                }
            }
            return result;
        } else {
            return null;
        }
    }

    /**
     * 安全的对象转目标类对象
     * @param obj  待转换对象
     * @param tClass  目录类型
     * @return T
     * @param <T>
     */
    public static <T> T objToObj(Object obj,Class<T> tClass){
        if (obj == null || tClass == null) {
            return null;
        }
        if(tClass.isInstance(obj)){
            return tClass.cast(obj);
        }
        if(obj instanceof String){
            return JsonUtils.parseObject((String) obj,tClass);
        }
        return null;
    }

}
