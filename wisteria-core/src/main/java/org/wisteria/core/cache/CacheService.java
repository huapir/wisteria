package org.wisteria.core.cache;

public interface CacheService<K> {

	Object get(K key);  
    
    void put(K key, Object value);
    
    void put(K key, Object value, int liveSeconds);
      
    boolean remove(K key);  
      
    void clear();  
      
    boolean containsKey(K key);
}
