package levelcache;

/**
 * Multi Level Cache
 * L0 L1, L2
 * if value available in L0
 *      return the value
 *      if not available check next available cache
 *   Read Operation
 *    Read will start from 1st level cache  if key found return otherwise
 *     Try to read from Next Level .... Keep doing util value of key is found at any level or last level has been
 *     reached.
 *   Write will start from 1st Level
 *   write value in this level and write its below level
 *   at any level value of key is the same then dont write just return
 */
public interface ILevelCache<K,V>{
    V getValue(K key);
    void putValue(K key, V value);
}
