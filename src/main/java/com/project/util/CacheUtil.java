package com.project.util;

import com.google.common.collect.Maps;

import java.util.concurrent.ConcurrentMap;

public final class CacheUtil {


    private CacheUtil(){}

    private static ConcurrentMap<String, String> cache = Maps.newConcurrentMap();

    public static String put(String key, String value){
        return cache.put(key,value);
    }


    public static String get(String key){
        return cache.get(key);
    }

}
