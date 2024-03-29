package me.blueslime.nmshandlerapi.utils.storage;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class PluginStorage<K, V> {
    private final Map<K, V> map;

    public PluginStorage(Map<K, V> initialMap) {
        this.map = initialMap;
    }

    public void add(K key, Function<? super K, ? extends V> function) {
        map.computeIfAbsent(key, function);
    }

    public void set(K key, V value) {
        map.put(key, value);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public V get(K key) {
        return map.get(key);
    }

    public V getAndRemove(K key) {
        return map.remove(key);
    }

    public V get(K key, Function<? super K, ? extends V> function) {
        add(key, function);
        return map.get(key);
    }

    public List<V> getValues() {
        return new ArrayList<>(map.values());
    }

    @SuppressWarnings("unused")
    public List<K> getKeys() {
        return new ArrayList<>(map.keySet());
    }

    public boolean contains(K key) {
        return map.containsKey(key);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    public Map<K, V> toMap() {
        return map;
    }

    public void clear() {
        map.clear();
    }

    public int size() {
        return map.size();
    }

    public static <K, V> PluginStorage<K, V> initAsHash() {
        return new PluginStorage<>(new HashMap<>());
    }

    public static <K, V> PluginStorage<K, V> initAsConcurrentHash() {
        return new PluginStorage<>(new ConcurrentHashMap<>());
    }

    public static <K extends Enum<K>, V> PluginStorage<K, V> initAsEnum(Class<K> kClass) {
        return new PluginStorage<>(new EnumMap<>(kClass));
    }

}




