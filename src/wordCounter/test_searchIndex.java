package wordCounter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test_searchIndex {

	@Test
	void test() {
		FileSearcher test = new FileSearcher();
		int output;
		output = test.searchIndex("/home/bart/eclipse-workspace/CountOccurences/files/","hitchhikers.txt","the");
		assertEquals(33,output);
		
}

}
