package com.csdndownload.utils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionUtils {


    /**
     * 是否为空
     *
     * @param collection collection
     * @return boolean
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 是否为空
     *
     * @param map map
     * @return boolean
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 是否为空
     *
     * @param array 数组
     * @param <T>   泛型
     * @return 是否为空
     */
    public static <T> boolean isEmpty(T[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * 是否不为空
     *
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return (collection != null && !collection.isEmpty());
    }

    /**
     * 是否不为空
     *
     * @param map map
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return (map != null && !map.isEmpty());
    }

    /**
     * 是否不为空
     *
     * @param array 数组
     * @param <T>   泛型
     * @return 是否不为空
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return (array != null && array.length > 0);
    }

    /**
     * 对列表进行过滤
     *
     * @param list      列表
     * @param predicate 如果返回true,那么将被返回
     * @param <T>       数据类型
     * @return 新的列表
     */
    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        Assert.notNull(predicate, "predicate is null");
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * 快速检查数据中是否有存在重复记录
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> boolean isUniqueList(List<T> list, BiPredicate<T, T> predicate) {
        if (isNotEmpty(list)) {
            List<T> result = new ArrayList<>();
            int valueIndex = 0;
            for (T value : list) {

                int innerIndex = 0;
                for (T inner : list) {

                    if (innerIndex <= valueIndex) {
                        innerIndex++;
                        continue;
                    }
                    // 避免自己和自己比
                    if (predicate.test(value, inner)) {
                        return false;
                    }
                    innerIndex++;
                }
                valueIndex++;
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * 列表去重
     * <p>
     * 更具对象的equal方法进行判定是否重复
     *
     * @param list
     * @return
     */
    public static <T> List<T> uniqueList(List<T> list) {
        if (isNotEmpty(list)) {
            return list.stream().distinct().collect(Collectors.toList());
        } else {
            return list;
        }
    }

    /**
     * 对列表进行去重
     *
     * @param list
     * @param predicate 如果两个数据相同，返回true
     * @param <T>
     * @return
     */
    public static <T> List<T> uniqueList(List<T> list, BiPredicate<T, T> predicate) {
        if (isNotEmpty(list)) {
            List<T> result = new ArrayList<>();
            for (T value : list) {
                boolean existed = false;

                for (T inner : result) {
                    // 避免自己和自己比
                    if (value != inner && predicate.test(value, inner)) {
                        existed = true;
                        break;
                    }
                }
                if (!existed) {
                    result.add(value);
                }
            }
            return result;
        } else {
            return list;
        }
    }

    /**
     * 找出list1 和list2中公共的元素
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T> List<T> commonList(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        if (isEmpty(list1) || isEmpty(list2)) {
            return result;
        }
        list1.forEach((value) -> {
            if (list2.contains(value)) {
                result.add(value);
            }
        });

        return result;
    }
    /**
     * 找出list1 和list2中公共的元素
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T> Set<T> commonList(Set<T> list1, List<T> list2){

        Set<T> result = new HashSet<>();
        if (isEmpty(list1) || isEmpty(list2)) {
            return result;
        }
        list1.forEach((value) -> {
            if (list2.contains(value)) {
                result.add(value);
            }
        });

        return result;
    }


    /**
     * 将相同的字段对象，映射为同一对象列表,
     * [{"aa":"a","bb":"b"},{"aa":"a","bb":"bb"}]
     * ||
     * V
     * {"a":[{"aa":"a","bb":"b"},{"aa":"a","bb":"bb"}]}
     *
     * @param list     目标数据
     * @param function 计算字段的函数,
     * @param <S>      泛型，归纳字段
     * @param <T>      目标对象
     * @return 同一字段相同的，map映射
     * @warning 目标字段为null，数据将被抛弃
     */
    public static <S, T> Map<S, List<T>> mapSameFieldToListMap(List<T> list, Function<T, S> function) {
        Map<S, List<T>> result = new HashMap<>();
        if (isEmpty(list)) {
            return result;
        }

        list.forEach((value) -> {
            S key = function.apply(value);
            if (key == null) {
                return;
            }

            List<T> tList = result.get(key);
            if (tList == null) {
                tList = new ArrayList<>();
                tList.add(value);
                result.put(key, tList);
            } else {
                tList.add(value);
            }
        });

        return result;
    }

    /**
     * 将相同的字段对象，映射为同一对象列表, (并行版本，会打乱顺序)
     * [{"aa":"a","bb":"b"},{"aa":"a","bb":"bb"}]
     * ||
     * V
     * {"a":[{"aa":"a","bb":"b"},{"aa":"a","bb":"bb"}]}
     *
     * @param list     目标数据
     * @param function 计算字段的函数,
     * @param <S>      泛型，归纳字段
     * @param <T>      目标对象
     * @return 同一字段相同的，map映射
     * @warning 目标字段为null，数据将被抛弃
     */
    public static <S, T> Map<S, List<T>> mapSameFieldToListMapParallel(final List<T> list, Function<T, S> function) {
        Map<S, List<T>> result = new ConcurrentHashMap<>();
        if (isEmpty(list)) {
            return result;
        }

        list.parallelStream().forEach((value) -> {
            S key = function.apply(value);
            if (key == null) {
                return;
            }

            List<T> tList = result.get(key);
            if (tList == null) {
                synchronized (list){
                    tList = result.get(key);
                    if(tList == null){
                        tList = Collections.synchronizedList(new ArrayList<>());
                    }
                    tList.add(value);
                    result.put(key, tList);
                }
            } else {
                tList.add(value);
            }
        });
        return result;
    }


    /**
     * 对象列表映射为另外一个类型的列表，重复数据将被去掉
     *
     * @param list     数据列表
     * @param function 映射函数
     * @param <S>      原
     * @param <T>      目标
     * @return 映射后数据列表
     */
    public static <S, T> List<T> mapToList(List<S> list, Function<S, T> function) {
        if (isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.stream().map(function).distinct().collect(Collectors.toList());
    }


    /**
     * 对象列表映射为另外一个类型的列表，重复数据将被去掉  (并行版本，会打乱顺序)
     *
     * @param list     数据列表
     * @param function 映射函数
     * @param <S>      原
     * @param <T>      目标
     * @return 映射后数据列表
     */
    public static <S, T> List<T> mapToListParallel(List<S> list, Function<S, T> function) {
        if (isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.parallelStream().map(function).distinct().collect(Collectors.toList());
    }


    /**
     * 对象列表映射为另外一个类型的集合
     *
     * @param list     数据列表
     * @param function 映射函数
     * @param <S>      原
     * @param <T>      目标
     * @return 映射后数据集合
     */
    public static <S, T> Set<T> mapToSet(List<S> list, Function<S, T> function) {
        if (isEmpty(list)) {
            return new HashSet<>();
        }
        return list.stream().map(function).collect(Collectors.toSet());
    }

    /**
     * 对象列表映射为另外一个类型的集合 (并行版本，会打乱顺序)
     *
     * @param list     数据列表
     * @param function 映射函数
     * @param <S>      原
     * @param <T>      目标
     * @return 映射后数据集合
     */
    public static <S, T> Set<T> mapToSetParallel(List<S> list, Function<S, T> function) {
        if (isEmpty(list)) {
            return new HashSet<>();
        }
        return list.parallelStream().map(function).collect(Collectors.toSet());
    }


    /**
     * 对象列表映射为一个map
     *
     * @param list      数据列表
     * @param kFunction 获取map key的函数
     * @param vFunction 获取map value的函数
     * @param <S>       原数据
     * @param <K>       key
     * @param <V>       value
     * @return 映射后数据map
     */
    public static <S, K, V> Map<K, V> mapToMap(List<S> list, Function<S, K> kFunction, Function<S, V> vFunction) {
        if (isEmpty(list)) {
            return new HashMap<>();
        }
        Map<K, V> result = new HashMap<>();
        list.forEach((value) -> {
            K key = kFunction.apply(value);

            V v = result.get(key);
            if (v == null) {
                result.put(key, vFunction.apply(value));
            }
        });
        return result;
    }

    /**
     * 对象列表映射为一个map  (并行版本，会打乱顺序)
     *
     * @param list      数据列表
     * @param kFunction 获取map key的函数
     * @param vFunction 获取map value的函数
     * @param <S>       原数据
     * @param <K>       key
     * @param <V>       value
     * @return 映射后数据map
     */
    public static <S, K, V> Map<K, V> mapToMapParallel(final List<S> list, Function<S, K> kFunction, Function<S, V> vFunction) {
        Map<K, V> result = new ConcurrentHashMap<>();

        if (isEmpty(list)) {
            return result;
        }

        list.parallelStream().forEach((value) -> {
            K key = kFunction.apply(value);

            V v = result.get(key);
            if (v == null) {
                synchronized (list){
                    v = result.get(key);
                    if(v == null){
                        result.put(key, vFunction.apply(value));
                    }
                }
            }
        });
        return result;
    }

    /**
     * 从一个列表中对象中，抽出一个字段列表，并去重
     *
     * @param list     列表数据
     * @param function 取字段函数
     * @param <S>      字段类型
     * @param <T>      数据类型
     * @return 字段列表
     */
    public static <S, T> List<S> mapGetSameFieldUniqueList(List<T> list, Function<T, S> function) {
        List<S> result = new ArrayList<>();
        if (isEmpty(list)) {
            return result;
        }
        result.addAll(list.stream().map(function).filter(Objects::nonNull).distinct().collect(Collectors.toList()));

        return result;
    }


    /**
     * 从一个列表中对象中，抽出一个字段列表，并去重 (并行版本，会打乱顺序)
     *
     * @param list     列表数据
     * @param function 取字段函数
     * @param <S>      字段类型
     * @param <T>      数据类型
     * @return 字段列表
     */
    public static <S, T> List<S> mapGetSameFieldUniqueListParallel(List<T> list, Function<T, S> function) {
        List<S> result = new ArrayList<>();
        if (isEmpty(list)) {
            return result;
        }
        result.addAll(list.parallelStream().map(function).filter(Objects::nonNull).distinct().collect(Collectors.toList()));

        return result;
    }


    /**
     * 从一个列表中对象中，抽出一个字段列表，并去重
     *
     * @param list            列表数据
     * @param function        取字段函数
     * @param uniquePredicate 判断唯一函数
     * @param <S>             字段类型
     * @param <T>             数据类型
     * @return 字段列表
     */
    public static <S, T> List<S> mapGetSameFieldUniqueList(List<T> list, Function<T, S> function, BiPredicate<S, S> uniquePredicate) {
        List<S> result = new ArrayList<>();
        if (isEmpty(list)) {
            return result;
        }
        result.addAll(list.stream().map(function).filter(Objects::nonNull).collect(Collectors.toList()));

        return uniqueList(result, uniquePredicate);
    }


    /**
     * 从一个列表中对象中，抽出一个字段列表，并去重 (并行版本，会打乱顺序)
     *
     * @param list            列表数据
     * @param function        取字段函数
     * @param uniquePredicate 判断唯一函数
     * @param <S>             字段类型
     * @param <T>             数据类型
     * @return 字段列表
     */
    public static <S, T> List<S> mapGetSameFieldUniqueListParallel(List<T> list, Function<T, S> function, BiPredicate<S, S> uniquePredicate) {
        List<S> result = new ArrayList<>();
        if (isEmpty(list)) {
            return result;
        }
        result.addAll(list.parallelStream().map(function).filter(Objects::nonNull).collect(Collectors.toList()));

        return uniqueList(result, uniquePredicate);
    }

    /**
     * 将list1 减去list2中的元素，得到的列表，可能为空
     *
     * @param list1 被减数 将不会改变
     * @param list2 减数 将不会改变
     * @param <T>
     * @return list1 - list2 之后的剩余
     */
    public static <T> List<T> subtractList(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();

        if (isEmpty(list1)) {
            return result;
        }
        if (isEmpty(list2)) {
            return list1;
        }
        result.addAll(list1);
        result.removeAll(list2);
        return result;
    }

    /**
     * 将list1 减去list2中的元素，得到的列表，可能为空
     *
     * @param list1 被减数 将不会改变
     * @param list2 减数 将不会改变
     * @param <T>
     * @return list1 - list2 之后的剩余
     */
    public static <T> Set<T> subtractList(Set<T> list1, Set<T> list2) {
        Set<T> result = new HashSet<>();

        if (isEmpty(list1)) {
            return result;
        }
        if (isEmpty(list2)) {
            return list1;
        }
        result.addAll(list1);
        result.removeAll(list2);
        return result;
    }


    /**
     * 合并列表，如果有重复的，最终的结果将会去重
     *
     * @param list
     * @param list2
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> List<T> mergeList(List<T> list, List<T>... list2) {
        Assert.notNull(list, "list is null");
        Assert.notNull(list2, "list2 is null");

        List<T> result = new ArrayList<>(list);
        if (list2.length > 0) {
            for (List<T> ts : list2) {
                result.addAll(ts);
            }
            return uniqueList(result);
        } else {
            return list;
        }
    }

    /**
     * 合并列表，如果有重复的，最终的结果将会去重
     * @param list
     * @param list2
     * @return
     * @param <T>
     */
    @SafeVarargs
    public static <T> List<T> mergeList(T[] list,T[]... list2){

        List<T> result = new ArrayList<>();

        if(list != null && list.length != 0){
            result.addAll(CollectionUtils.ofList(list));
        }

        if(list2.length > 0){
            for (T[] tmpList : list2) {

                if(tmpList != null && tmpList.length != 0){
                    result.addAll(CollectionUtils.ofList(tmpList));
                }
            }
        }
        return uniqueList(result);
    }



    /**
     * 取列表中的第一个
     *
     * @param list 列表数据
     * @param <T>  泛型
     * @return 值
     */
    public static <T> T first(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 取列表中的第一个
     *
     * @param list 列表数据
     * @param <T>  泛型
     * @return 值
     */
    public static <T> T first(T[] list) {
        if (isEmpty(list)) {
            return null;
        }
        return list[0];
    }

    /**
     * 快速列表列表
     *
     * @param data 数据数组
     * @param <T>  数据类型
     * @return 列表
     */
    public static <T> List<T> ofList(T... data) {
        List<T> result = new ArrayList<>();
        if (data.length > 0) {
            for (int i = 0; i < data.length; i++) {
                result.add(data[i]);
            }
        }
        return result;
    }

    /**
     * 快速列表列表
     *
     * @param data 数据数组
     * @param <T>  数据类型
     * @return 列表
     */
    public static <T> List<T> ofList(Collection<T> data) {
        List<T> result = new ArrayList<>();
        if (data != null && data.size() > 0) {
            result.addAll(data);
        }
        return result;
    }

    /**
     * 快速set
     *
     * @param data 数据
     * @param <T>  泛型
     * @return 集合
     */
    public static <T> Set<T> ofSet(T... data) {
        Set<T> result = new HashSet<>();
        if (data.length > 0) {
            for (int i = 0; i < data.length; i++) {
                result.add(data[i]);
            }
        }
        return result;
    }

    /**
     * 快速set
     *
     * @param data 数据
     * @param <T>  泛型
     * @return 集合
     */
    public static <T> Set<T> ofSet(Collection<T> data) {
        Set<T> result = new HashSet<>();
        if (data != null && data.size() > 0) {
            result.addAll(data);
        }
        return result;
    }

    /**
     * 反向list 最后的成员放在最前面
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> revert(List<T> list) {
        List<T> result = new ArrayList<>();

        if (isNotEmpty(list)) {
            for (int i = list.size() - 1; i > -1; i--) {
                result.add(list.get(i));
            }
        }
        return result;
    }


}
