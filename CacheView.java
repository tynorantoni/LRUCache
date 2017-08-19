package cachePack;

public interface CacheView extends CacheItem {

	int size();//zwraca wielko�� Cache�a
	 
	CacheItem getItem(int index);//zwraca obiekt o podanym indeksie
	
	CacheItem getItem(String key);//zwraca obiekt o podanym kluczu
	
}
