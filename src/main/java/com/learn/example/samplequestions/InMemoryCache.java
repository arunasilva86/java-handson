package com.learn.example.samplequestions;

import java.util.*;


/**
 Design and implement an in-memory cache library

 Requirements:
 - It should have a positive maximum capacity
 - It should support 'first in first out' eviction policy
 - put(key, value) should Insert/Update the [key,value] into the cache
 - get(key) should return the value if the key exists.
 **/

// add classes here

public class InMemoryCache <K, V> {

    private int maxObjectCount;
    private Map<K,V> data;
    private TreeMap<Date, K> treeMap;

    public InMemoryCache(int maxObjectCount) {
        this.maxObjectCount = maxObjectCount;
        this.data = new HashMap();
        this.treeMap = new TreeMap<>();
    }

    public synchronized V  put (K key, V value) {
        int currentCount = data.size();
        if (currentCount >= maxObjectCount) {
            evict();
        }
        data.put(key, value);
        treeMap.put(new Date(), key);
        return value;
    }

    public V get (K key) {
        return data.get(key);
    }

    private void evict () {
        Date oldestRecordDate = treeMap.lastKey();
        K keyToBeRemoved = treeMap.get(oldestRecordDate);
        data.remove(keyToBeRemoved);
        treeMap.remove(oldestRecordDate);
    }
}



class Solution {

    public static void main(String[] args) {
        // test your logic here
    }
}
