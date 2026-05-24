package prob2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class DictionaryJUnitTest {
	
	
	private static ADTDictionary<Integer, String> dict;
	  
	@BeforeAll
	public static void setUp() {
		
		dict = new LinkedListDictionary<Integer,String>();
		
	}

	@Test
	void testClear() {
		dict.clear();
		assertEquals(0, dict.size(), "clear failed, size is non zero");
	}

	@Test
	void testInsert() {
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		assertEquals(4, dict.size(), "insert failed, size is not as expected");
	}

	@Test
	void testRemove() {
		
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		dict.remove(0);
		
		assertEquals("3:grey , 2:yellow , 1:blue , ", dict.toString());
		
		assertEquals("grey", dict.find(3), "remove failed"); 
		
	}

	@Test
	void testRemoveAny() {
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		assertEquals("grey", dict.removeAny(), "removeAny failed"); 
		
		
	}

	@Test
	void testFind() {
		
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		
		assertNull(dict.find(5));
		
		assertEquals("grey", dict.find(3), "find failed"); 
	}

	@Test
	void testSize() {
		dict.clear();
		dict.insert(0, "red");
	
		
		assertEquals(1, dict.size(), "size failed, size is not as expected");
	}

}
