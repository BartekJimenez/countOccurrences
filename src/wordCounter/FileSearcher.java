package wordCounter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSearcher {
	
	public int searchString(String path, String filename, String wordname) throws FileNotFoundException, IOException {
        String line;
        
	    int count = 0;
	    try (LineNumberReader r = new LineNumberReader(new FileReader(path+filename))) {

	        while ((line = r.readLine()) != null) {
	            for (String element : line.split(" ")) {
	            	element = element.replaceAll("[^a-zA-Z0-9]", "");
	                if (element.equalsIgnoreCase(wordname)) {
	                    count++;
	                }
	            }
	        }
	    }
	    
	    System.out.println("The word " + wordname + " appears " + count + " times using String Search in " + filename + ".");
		return count;
	}
	
	public int searchRegex(String path, String filename, String wordname){ 
		
		

        try (Stream<String> lines = Files.lines(Paths.get(path+filename))) {
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            content = content.toLowerCase();

            Pattern p = Pattern.compile("\\b" + wordname + "\\b");
            Matcher m = p.matcher(content);
            
      
            int count = 0; 
      
            while (m.find()) { 
                count++; 
            } 
            
    	    System.out.println("The word " + wordname + " appears " + count + " times using Regex search in " + filename + ".");
    	    return count;

        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
		
		
		
  

    }
	public int searchIndex(String path, String filename, String wordname) {
		try (Stream<String> lines = Files.lines(Paths.get(path+filename))) {
			List<Integer> indexes = new ArrayList<Integer>();
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            content = content.toLowerCase();
            wordname = wordname.toLowerCase();
            int wordLength = 0;
            
            int index =0;
            while(index != -1) {
            	index = content.indexOf(wordname, index + wordLength);
            	
            	
            	if (index != -1) {
            		indexes.add(index);
            	}
            	
            	wordLength = wordname.length();
            }
            
            int count = indexes.size();
           System.out.println("The word " + wordname + " appears " + count + " times using IndexOf search in " + filename + ".");
           return count;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	

}
