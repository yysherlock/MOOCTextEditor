package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MarkovTextGeneratorTester {

	MarkovTextGeneratorLoL ins = new MarkovTextGeneratorLoL(new Random(42));
	
	List<ListNode> wordList;
	String sourceText = "hi there hi Leo";
			//"hello world. This is a funny guy. hello, hello world. This is a good guy.";
	
	@Before
	public void setUp(){
		ins.train(sourceText);
		wordList = new LinkedList<ListNode>();
		wordList.add(new ListNode("A"));
		wordList.add(new ListNode("B"));
		
	}
	
	@Test
	public void testContains(){
		//System.out.println(wordList);
		assertEquals(true, wordList.contains(new ListNode("A")));
		assertEquals(true, wordList.contains(new ListNode("B")));
		assertEquals(false, wordList.contains(new ListNode("C")));
		assertEquals(false, wordList.contains("B"));
		assertEquals(false, wordList.contains("C"));
	}
	
	@Test
	public void testIndexOf(){
		assertEquals(0, wordList.indexOf(new ListNode("A")));
		assertEquals(1, wordList.indexOf(new ListNode("B")));
		assertEquals(-1, wordList.indexOf(new ListNode("C")));
	}
	
	@Test
	public void testTrain(){
		//ins.train(sourceText);
		System.out.println(ins.toString());
		ins.train("");
		System.out.println(ins.toString());
		ins.train("");
		System.out.println(ins.toString());
	}
	
	@Test
	public void testGenerate(){
		
		//System.out.println(ins.generateText(5));
	}
	
}
