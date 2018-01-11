package org.wisteria.util;

import org.wisteria.core.cache.CacheService;
import org.wisteria.core.cache.DefaultCacheService;

/**
 * 缓存工具类
 * @author Lei.Liu
 *
 */
public class CacheUtils {

	private static CacheService<String> store = new DefaultCacheService<String>();
	
	public static void put(String key, Object value) {
		store.put(key, value);
	}
	
	public void put(String key, Object value, int liveSeconds) {
		store.put(key, value, liveSeconds);
	}
	
	public static Object get(String key) {
		return store.get(key);
	}
	
	public static boolean remove(String key) {
		return store.remove(key);
	}
	
	public static void clear() {
		store.clear();
	}
	
	public static boolean containsKey(String key) {
		return store.containsKey(key);
	}
}
