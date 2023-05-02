package cs.dsa.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKeys {

	// Generic method to sort map by keys using `TreeMap`
    public static <K, V> Map<K, V> sortByKeys(Map<K, V> unsortedMap)
    {
        // construct a `TreeMap` from the given map and return it
        return new TreeMap<>(unsortedMap);
    }
    
 // Generic method to sort map by keys using `LinkedHashMap`
    public static <K extends Comparable, V> Map<K, V> sortByKeys_LL(Map<K, V> map)
    {
        // create a list of map keys and sort it
        List<K> keys = new ArrayList(map.keySet());
        Collections.sort(keys);
 
        // create an empty insertion-ordered `LinkedHashMap`
        Map<K, V> linkedHashMap = new LinkedHashMap<>();
 
        // for every key in the sorted list, insert key-value
        // pair in `LinkedHashMap`
        for (K key: keys) {
            linkedHashMap.put(key, map.get(key));
        }
 
        return linkedHashMap;
    }
 
    public static void main(String[] args)
    {
        Map<String, String> country = new HashMap<>();
 
        country.put("India", "New Delhi");
        country.put("USA", "Washington D.C.");
        country.put("Japan", "Tokyo");
        country.put("China", "Beijing");
 
        //country = sortByKeys(country);
        country = sortByKeys_LL(country);
        System.out.println("Sorted map by keys :\n" + country);
    }

}
