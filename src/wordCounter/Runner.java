package wordCounter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

	private static final List<String> files = new ArrayList<String>();
	private static Map<String, String> uniqueWords = new LinkedHashMap<String, String>();
	private static String masterCopy;
	private static String path;
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException  
	{	
		Runner go = new Runner();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Is this a system test?");
		String sysTest = sc.nextLine();
		String wordname = null;
		
		go.load();
		
		if (sysTest.equals("no")) {
			System.out.println("Please enter a search term:");
			wordname = sc.nextLine();
		}
		else if (sysTest.equals("yes")) {
			for (String file: files) {
				go.loadDictionary(file); 
			}
			masterCopy = masterCopy.toLowerCase();
			masterCopy = masterCopy.replaceAll("[^a-zA-Z0-9\\s]", "");
			
			String[] strArray = masterCopy.split("\\s+");
			for (int i = 0; i < strArray.length; i++) {
				if (!uniqueWords.containsKey(strArray[i])) {
					uniqueWords.put(strArray[i], "unique value");
				}
			}
		}

		System.out.println("Please choose a search method:" );
		System.out.println("1) String Match" );
		System.out.println("2) Regular Expression" );
		System.out.println("3) Indexed" );
		int choice = sc.nextInt();
		
		
		
		long startTime = System.nanoTime();
		
		List<String> keys = new ArrayList<>(uniqueWords.keySet());
		Random rand = new Random();

		if (sysTest.equals("yes")) {
			long counter = 0;
			while (counter <= 2000000) {
				go.options(choice, keys.get(rand.nextInt(keys.size())));
				counter++;
			}
			
		}
		else {
			
			go.options(choice, wordname);
		}
		long endTime = System.nanoTime();

		// get difference of two nanoTime values
		long timeElapsed = endTime - startTime;

//		System.out.println("Execution time in nanoseconds  : " + timeElapsed);

		System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);

	}
	
	public void load() {
		path = "/home/bart/eclipse-workspace/CountOccurences/files/";
		files.add("french_armed_forces.txt");
		files.add("hitchhikers.txt");
		files.add("warp_drive.txt");
	}
	
	public void options(int choice, String wordname) throws FileNotFoundException, IOException {
		
		FileSearcher serFile = new FileSearcher();
		
		switch(choice) {
		case 1:
			for (String file: files) {
				serFile.searchString(path, file, wordname); //572957
			}
			break;
		case 2:
			for (String file: files) {
				serFile.searchRegex(path, file, wordname);
			}
			break;
		case 3:
			for (String file: files) {
				serFile.searchIndex(path, file, wordname);
			}
			break;	
		}


	}
	
	public void loadDictionary(String filename) throws IOException{
		try (Stream<String> lines = Files.lines(Paths.get(path+filename))){
			String content = lines.collect(Collectors.joining(System.lineSeparator()));
			masterCopy = content + masterCopy;
		}
	}
}