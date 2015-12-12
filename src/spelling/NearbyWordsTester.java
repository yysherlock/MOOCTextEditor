package spelling;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NearbyWordsTester {

	String dictFile = "data/dict.txt";
	String s ;
	StringBuffer sb ;
	List<String> currentList = new ArrayList<String>();
	DictionaryBST dict = new DictionaryBST();
	NearbyWords ins;
	
	@Before
	public void setUp(){
		s = "like";
		sb = new StringBuffer(s);
		//currentList.add("he");
		DictionaryLoader.loadDictionary(dict, dictFile);
		ins = new NearbyWords(dict);
	}
	
	@Test
	public void testSBinsert(){
		sb.insert(0, 'a');
		assertEquals(true, sb.toString().equals("alike"));
		sb.insert(1, 'b');
		assertEquals(true, sb.toString().equals("ablike"));
		sb.insert(sb.length(), 'c');
		assertEquals(true, sb.toString().equals("ablikec"));
	}
	
	@Test
	public void testInsertion(){
		s = "he";
		ins.insertions(s, currentList, true);
		System.out.println(currentList);
	}
	@Test
	public void testDeletion(){
		s = "them";
		ins.deletions(s, currentList, true);
		System.out.println(currentList);
	}
}
