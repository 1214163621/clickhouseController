package com.example.demo.util;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Listutil {

//    交集
    public static List<String> intersectList2(List<String> list1, List<String> list2){
        Map<String, String> tempMap = list2.parallelStream().collect(Collectors.toMap(Function.identity(), Function.identity(), (oldData, newData) -> newData));
        return list1.parallelStream().filter(str->{
            return tempMap.containsKey(str);
        }).collect(Collectors.toList());
    }
//    差集
//    求List1中有的但是List2中没有的元素
    public static List<String> subList2(List<String> list1, List<String> list2) {
        Map<String, String> tempMap = list2.parallelStream().collect(Collectors.toMap(Function.identity(), Function.identity(), (oldData, newData) -> newData));
        return list1.parallelStream().filter(str->{
            return !tempMap.containsKey(str);
        }).collect(Collectors.toList());
    }
}
