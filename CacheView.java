package cachePack;

public interface CacheView extends CacheItem {

	int size();//zwraca wielkoœæ Cache’a
	 
	CacheItem getItem(int index);//zwraca obiekt o podanym indeksie
	
	CacheItem getItem(String key);//zwraca obiekt o podanym kluczu
	
}
