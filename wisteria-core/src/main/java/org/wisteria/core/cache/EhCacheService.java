package org.wisteria.core.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheService<K> implements CacheService<K> {
	
	private static final String CACHE_NAME = "EHCACHE_NAME";
	private static CacheManager manager = CacheManager.create();
	private static Cache store = new Cache(CACHE_NAME, 100, false, false, 3600, 300);
	
	static {
		manager.addCache(store);
	}
	
	public EhCacheService() {}
	
	@Override
	public Object get(K key) {
		Element element = store.get(key);
		if (element != null) {
			return element.getObjectValue();
		}
		return null;
	}

	@Override
	public void put(K key, Object value) {
		Element element = new Element(key, value);
		store.put(element);
	}
	
	@Override
	public void put(K key, Object value, int liveSeconds) {
		Element element = new Element(key, value);
		element.setTimeToLive(liveSeconds);
		store.put(element);
	}

	@Override
	public boolean remove(K key) {
		return store.remove(key);
	}

	@Override
	public void clear() {
		store.removeAll();
	}

	@Override
	public boolean containsKey(K key) {
		return store.isKeyInCache(key);
	}

}
