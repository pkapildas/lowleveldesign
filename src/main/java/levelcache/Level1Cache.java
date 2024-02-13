package levelcache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Level1Cache<K,V> extends ProcessCache implements ILevelCache<K,V>{
    final Map<K,V> cache = new ConcurrentHashMap<>();

    public Level1Cache(ILevelCache nextLevelCache) {
        super(nextLevelCache);
    }

    @Override
    public V getValue(K key) {
        V value;
        if(cache.containsKey(key)){
            value = cache.get(key);
        }else value = (V) super.nextLevelCache.getValue(key);
        return value;
    }

    @Override
    public void putValue(K key, V value) {
        this.cache.put(key, value);
        if(super.nextLevelCache!=null){
            super.nextLevelCache.putValue(key, value);
        }

    }
}
