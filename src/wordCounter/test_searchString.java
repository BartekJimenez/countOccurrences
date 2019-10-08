package wordCounter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class test_searchString {

	@Test
	void test() throws FileNotFoundException, IOException {
		FileSearcher test = new FileSearcher();
		int output;
		output = test.searchString("/home/bart/eclipse-workspace/CountOccurences/files/","hitchhikers.txt","the");
		assertEquals(29,output);

		
}

}
