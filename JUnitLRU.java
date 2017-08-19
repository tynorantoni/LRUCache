package appPack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import entities.Example;
/*
 * Author Pawe³ Szymaszek
 * 19.08.2017
 * 
 * 
 */
public class JUnitLRU {

	LRUCacheImplementation<String, Object> test = new LRUCacheImplementation<>(2);
	Example exampleObject1 = new Example(1, "pierwszy", true);
	Example exampleObject2 = new Example(2, "drugi", true);
	Example exampleObject3 = new Example(3, "trzeci", true);

	@Test
	public void testSize() {
		test.cacheItem(exampleObject1, exampleObject1.getName());
		assertNotNull("not null", test.size());
		assertEquals("Size method test", 1, test.size());
	}

	@Test
	public void testRemoveEldestEntry() {
		test.invalidateCache();
		test.cacheItem(exampleObject3, exampleObject3.getName());
		test.cacheItem(exampleObject1, exampleObject1.getName());
		test.cacheItem(exampleObject2, exampleObject2.getName());
		assertNotNull(test);
		assertNull("least object was removed", test.getItem("trzeci"));
		
	}

	@Test
	public void testLRUCacheImplementation() {
		assertNotNull(test);
	}

	@Test
	public void testGetItemInt() {
		test.invalidateCache();
		test.cacheItem(exampleObject3, exampleObject3.getName());
		test.cacheItem(exampleObject1, exampleObject1.getName());
		assertNotNull(test);
		String byIndexOne = test.getItem(0).getValue().toString();
		assertEquals("Get Key Value Test", "Example [name=trzeci, id=3, isTrue=true]", byIndexOne);
		
		
		String byIndexTwo = test.getItem(0).getValue().toString();
		assertEquals("Get Key Value Test", "Example [name=pierwszy, id=1, isTrue=true]", byIndexTwo);
	}

	@Test
	public void testGetItemString() {
		test.invalidateCache();
		test.cacheItem(exampleObject3, exampleObject3.getName());
		test.cacheItem(exampleObject1, exampleObject1.getName());
		String byKeyOne = test.getItem("pierwszy").getValue().toString();
		String byKeyTwo = test.getItem("trzeci").getValue().toString();
		assertNotNull(test);
		assertEquals("Get Key Value Test", "Example [name=pierwszy, id=1, isTrue=true]", byKeyOne);
		assertEquals("Get Key Value Test", "Example [name=trzeci, id=3, isTrue=true]", byKeyTwo);
	}

	@Test
	public void testGetKey() {
		test.invalidateCache();
		test.cacheItem(exampleObject3, exampleObject3.getName());
		test.cacheItem(exampleObject1, exampleObject1.getName());
		String key = test.getKey();
		assertNotNull(test);
		assertEquals("Get last Key Value Test", "pierwszy", key);
	}

	@Test
	public void testGetValue() {
		test.invalidateCache();
		test.cacheItem(exampleObject3, exampleObject3.getName());
		test.cacheItem(exampleObject1, exampleObject1.getName());
		String value = test.getValue().toString();
		assertNotNull(test);
		assertEquals("Get last Object Value Test", "Example [name=pierwszy, id=1, isTrue=true]", value);
	}

	@Test
	public void testCacheItem() {
		test.invalidateCache();
		test.cacheItem(exampleObject2, exampleObject2.getName());
		assertNotNull(test);
		assertEquals("Insertion Test", "{drugi=Example [name=drugi, id=2, isTrue=true]}", test.toString());
	}

	@Test
	public void testInvalidateCache() {
		test.invalidateCache();
		assertNotEquals(exampleObject2, test);
		assertNotNull("Not null, but empty", test);
		assertEquals("Current size should be: 0", 0, test.size());
	}

	@Test
	public void testGetView() {
		test.invalidateCache();
		test.cacheItem(exampleObject3, exampleObject3.getName());
		test.cacheItem(exampleObject1, exampleObject1.getName());
		assertNotNull(test);
		assertEquals("View Test", "{trzeci=Example [name=trzeci, id=3, isTrue=true], pierwszy=Example "
				+ "[name=pierwszy, id=1, isTrue=true]}", test.getView().toString());
	}

}
