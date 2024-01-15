package com.csdndownload.utils;

import com.sunday.commons.factory.MF;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Log4j2
public class Assert {

    /**
     * 必须是true
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustTrue(boolean object, String message) {
        if (!object) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * 必须是true
     *
     * @param object  对象
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static void mustTrue(boolean object, String message, Object clue1) {
        if (!object) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 必须是true
     *
     * @param object  对象
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static void mustTrue(boolean object, String message, Object clue1, Object clue2) {
        if (!object) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 必须是true
     *
     * @param object  对象
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static void mustTrue(boolean object, String message, Object clue1, Object clue2, Object clue3) {
        if (!object) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 必须是false
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustFalse(boolean object, String message) {
        if (object) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * 必须是false
     *
     * @param object  对象
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static void mustFalse(boolean object, String message, Object clue1) {
        if (object) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 必须是false
     *
     * @param object  对象
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static void mustFalse(boolean object, String message, Object clue1, Object clue2) {
        if (object) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 必须是false
     *
     * @param object  对象
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static void mustFalse(boolean object, String message, Object clue1, Object clue2, Object clue3) {
        if (object) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 必须是null
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustNull(Object object, String message) {
        if (object != null) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * 必须是null
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustNull(Object object, String message, Object clue1) {
        if (object != null) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 必须是null
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustNull(Object object, String message, Object clue1, Object clue2) {
        if (object != null) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 必须是null
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustNull(Object object, String message, Object clue1, Object clue2, Object clue3) {
        if (object != null) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 不能为空字符串
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustNotBlank(String object, String message) {
        if (object == null || "".equals(object)) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * 不能为空字符串
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustNotBlank(String object, String message, Object clue1) {
        if (object == null || "".equals(object)) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 不能为空字符串
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustNotBlank(String object, String message, Object clue1, Object clue2) {
        if (object == null || "".equals(object)) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 不能为空字符串
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static void mustNotBlank(String object, String message, Object clue1, Object clue2, Object clue3) {
        if (object == null || "".equals(object)) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 必须为long类型，或者可以转换成long类型
     *
     * @param value value
     * @param message 错误消息
     */
    public static void mustLongType(String value, String message) {
        if (value == null || "".equals(value)) {
            throw new IllegalStateException(message);
        }
        try {
            Long.parseLong(value);
        } catch (Exception e) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * 必须为long类型，或者可以转换成long类型
     *
     * @param value value
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static void mustLongType(String value, String message, Object clue1) {
        if (value == null || "".equals(value)) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
        try {
            Long.parseLong(value);
        } catch (Exception e) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 必须为long类型，或者可以转换成long类型
     *
     * @param value value
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static void mustLongType(String value, String message, Object clue1, Object clue2) {
        if (value == null || "".equals(value)) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
        try {
            Long.parseLong(value);
        } catch (Exception e) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 必须为long类型，或者可以转换成long类型
     *
     * @param value value
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static void mustLongType(String value, String message, Object clue1, Object clue2, Object clue3) {
        if (value == null || "".equals(value)) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
        try {
            Long.parseLong(value);
        } catch (Exception e) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 不能为空
     *
     * @param object  对象
     * @param message 错误消息
     */
    public static <T> void notNull(T object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不能为空
     *
     * @param object  对象
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static <T> void notNull(T object, String message, Object clue1) {
        if (object == null) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 不能为空
     *
     * @param object  对象
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static <T> void notNull(T object, String message, Object clue1, Object clue2) {
        if (object == null) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 不能为空
     *
     * @param object  对象
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static <T> void notNull(T object, String message, Object clue1, Object clue2, Object clue3) {
        if (object == null) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 不能为空
     *
     * @param list
     * @param message 错误消息
     */
    public static <T> void notEmpty(List<T> list, String message) {

        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(byte[] array, String message) {

        if (array == null || array.length <= 0) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不能为空
     *
     * @param list
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static <T> void notEmpty(List<T> list, String message, Object clue1) {

        if (list == null || list.isEmpty()) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 不能为空
     *
     * @param list
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static <T> void notEmpty(List<T> list, String message, Object clue1, Object clue2) {

        if (list == null || list.isEmpty()) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 不能为空
     *
     * @param list
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static <T> void notEmpty(List<T> list, String message, Object clue1, Object clue2, Object clue3) {

        if (list == null || list.isEmpty()) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 不能为空
     *
     * @param map     map
     * @param message 错误消息
     */
    public static <K, V> void notEmpty(Map<K, V> map, String message) {

        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不能为空
     *
     * @param map     map
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static <K, V> void notEmpty(Map<K, V> map, String message, Object clue1) {

        if (map == null || map.isEmpty()) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 不能为空
     *
     * @param map     map
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static <K, V> void notEmpty(Map<K, V> map, String message, Object clue1, Object clue2) {

        if (map == null || map.isEmpty()) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 不能为空
     *
     * @param map     map
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static <K, V> void notEmpty(Map<K, V> map, String message, Object clue1, Object clue2, Object clue3) {

        if (map == null || map.isEmpty()) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 不能为空
     *
     * @param set     set
     * @param message 错误消息
     */
    public static <T> void notEmpty(Set<T> set, String message) {
        if (set == null || set.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不能为空
     *
     * @param set     set
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static <T> void notEmpty(Set<T> set, String message, Object clue1) {
        if (set == null || set.isEmpty()) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 不能为空
     *
     * @param set     set
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static <T> void notEmpty(Set<T> set, String message, Object clue1, Object clue2) {
        if (set == null || set.isEmpty()) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 不能为空
     *
     * @param set     set
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static <T> void notEmpty(Set<T> set, String message, Object clue1, Object clue2, Object clue3) {
        if (set == null || set.isEmpty()) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 不能为空
     *
     * @param array     array
     * @param message 错误消息
     */
    public static <T> void notEmpty(T[] array, String message) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不能为空
     *
     * @param array     array
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static <T> void notEmpty(T[] array, String message, Object clue1) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 不能为空
     *
     * @param array     array
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static <T> void notEmpty(T[] array, String message, Object clue1, Object clue2) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 不能为空
     *
     * @param array     array
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static <T> void notEmpty(T[] array, String message, Object clue1, Object clue2, Object clue3) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 是否相等
     *
     * @param value1  value1
     * @param value2  value2
     * @param message 错误消息
     */
    public static <T> void equal(T value1, T value2, String message) {
        if (value1 == value2) {
            return;
        }
        if (value1 != null) {
            if (!value1.equals(value2)) {
                throw new IllegalArgumentException(message);
            }
        } else {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 是否相等
     *
     * @param value1  value1
     * @param value2  value2
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static <T> void equal(T value1, T value2, String message, Object clue1) {
        if (value1 == value2) {
            return;
        }
        if (value1 != null) {
            if (!value1.equals(value2)) {
                throw new IllegalStateException(MF.m(message, clue1));
            }
        } else {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 是否相等
     *
     * @param value1  value1
     * @param value2  value2
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static <T> void equal(T value1, T value2, String message, Object clue1, Object clue2) {
        if (value1 == value2) {
            return;
        }
        if (value1 != null) {
            if (!value1.equals(value2)) {
                throw new IllegalStateException(MF.m(message, clue1, clue2));
            }
        } else {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * @param value1  value1
     * @param value2  value2
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static <T> void equal(T value1, T value2, String message, Object clue1, Object clue2, Object clue3) {
        if (value1 == value2) {
            return;
        }
        if (value1 != null) {
            if (!value1.equals(value2)) {
                throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
            }
        } else {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 指定有N项数据
     *
     * @param list    list
     * @param n       n
     * @param message 错误消息
     */
    public static <T> void hasN(List<T> list, long n, String message) {

        if (list == null) {
            throw new IllegalArgumentException(message);
        }

        if (list.size() != n) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 指定有N项数据
     *
     * @param list    list
     * @param n       n
     * @param message 错误消息
     * @param clue1   线索1
     */
    public static <T> void hasN(List<T> list, long n, String message, Object clue1) {

        if (list == null) {
            throw new IllegalStateException(MF.m(message, clue1));
        }

        if (list.size() != n) {
            throw new IllegalStateException(MF.m(message, clue1));
        }
    }

    /**
     * 指定有N项数据
     *
     * @param list    list
     * @param n       n
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     */
    public static <T> void hasN(List<T> list, long n, String message, Object clue1, Object clue2) {

        if (list == null) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }

        if (list.size() != n) {
            throw new IllegalStateException(MF.m(message, clue1, clue2));
        }
    }

    /**
     * 指定有N项数据
     *
     * @param list    list
     * @param n       n
     * @param message 错误消息
     * @param clue1   线索1
     * @param clue2   线索2
     * @param clue3   线索3
     */
    public static <T> void hasN(List<T> list, long n, String message, Object clue1, Object clue2, Object clue3) {

        if (list == null) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }

        if (list.size() != n) {
            throw new IllegalStateException(MF.m(message, clue1, clue2, clue3));
        }
    }

    /**
     * 必须用end结尾
     *
     * @param value
     * @param end
     * @return
     */
    public static void mustEndWith(String value, String end) {
        Assert.mustNotBlank(value, "value is blank");
        Assert.mustNotBlank(end, "end is blank");

        if(!value.endsWith(end)){
            throw new IllegalStateException(MF.m("{} must end with end{}", value, end));
        }
    }

    /**
     * 必须用start 开始
     *
     * @param value
     * @param start
     * @return
     */
    public static void mustStartWith(String value, String start) {
        Assert.mustNotBlank(value, "value is blank");
        Assert.mustNotBlank(start, "end is blank");

        if(!value.startsWith(start)){
            throw new IllegalStateException(MF.m("{} must end with start{}", value, start));
        }
    }

}
