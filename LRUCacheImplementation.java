package appPack;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import cachePack.Cache;
import cachePack.CacheItem;
import cachePack.CacheView;

/*
 * Author Pawe³ Szymaszek
 * 19.08.2017
 * 
 * 
 */
public class LRUCacheImplementation<K, V> extends LinkedHashMap<String, Object> implements Cache {

	private static final long serialVersionUID = 1L;

	// field determining max size of cache
	private int limiter;

	/*
	 * constructor of cache
	 */
	public LRUCacheImplementation(int size) {
		super(size, 0.75f, true);
		this.limiter = size;
	}

	/*
	 * This method removes least recently used item from cache
	 * 
	 * @return boolean
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
		return size() > limiter;
	}

	// @return current size of cache
	@Override
	public int size() {
		return super.size();
	}

	/*
	 * Method moving requested item (by index) to head, with getKey() or
	 * getValue() returns selected param.
	 * 
	 * @return LRU cache instance
	 */
	@Override
	public CacheItem getItem(int index) {

		int i = 0;

		if (index > this.size()) {
			return null;
		}

		for (String key : this.keySet()) {
			if (i == index) {
				this.get(key);
				break;
			}
			i++;

		}

		return this;
	}

	/*
	 * Method moving requested item (by key) to head, with getKey() or
	 * getValue() returns selected param.
	 * 
	 * @return LRU cache instance
	 */
	@Override
	public CacheItem getItem(String key) {

		if (!this.containsKey(key)) {
			return null;
		}

		this.get(key);
		return this;
	}
	/*
	 * @return key from head of LRU cache instance
	 */

	@Override
	public String getKey() {
		String key = "";
		try {
			Iterator<String> it = this.keySet().iterator();
			while (it.hasNext()) {
				key = it.next();
			}
		} catch (NullPointerException e) {
			e.getMessage();
			System.out.println("No such Object");
		}
		return key;

	}

	/*
	 * @return value from head of LRU cache instance
	 */
	@Override
	public Object getValue() {
		Object result = null;
		try {
			Iterator<Object> it = this.values().iterator();
			while (it.hasNext()) {
				result = it.next();
			}
		} catch (NullPointerException ex) {
			ex.getMessage();
			System.out.println("No such Object");
		}
		return result;
	}

	/*
	 * This method inserts key and value to LRU cache instance
	 * 
	 * @param Object item
	 * 
	 * @param String key
	 * 
	 * @return instance of cache with params
	 */
	@Override
	public CacheItem cacheItem(Object item, String key) {

		return (CacheItem) super.put(key, item);
	}

	/*
	 * Cleans everything from cache
	 */
	@Override
	public void invalidateCache() {
		super.clear();
	}

	/*
	 * Method showing cache
	 * 
	 * @return instance of LRU cache
	 */
	@Override
	public CacheView getView() {

		return this;
	}

}