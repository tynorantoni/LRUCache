package cachePack;


public interface Cache extends CacheView {

	CacheItem cacheItem(Object item, String key);//zapisuje obiekt w Cache�u
	
	void invalidateCache();//czy�ci nasz Cache
	
	CacheView getView();//zwraca �widok� na nasz Cache
	
	
}
