import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.util.*;
import java.io.*;

/**
 * This class creates the original frequency table for all of the characters. It stores these characters in a HashMap.
 * The HashMap implementation was chosen in order to index in constant time.
 *
 * This class includes a test method for the created map
 */

public class FrequencyTable {
    Map<Character, Integer> table;
    public FrequencyTable(String fileName){
            // the implementation here for the map ADT is a hasMap because we can index in constant time
            table = new HashMap<>();
            BufferedReader br = null;
            try {
                // create a buffered reader that reads the file
                File file = new File(fileName);
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
                // have to create new buffered reader to check because readLine() progresses the buffered reader to the next line
                BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
                // check if the file is blank
                if(check.readLine() == null){
                    throw new IllegalArgumentException("File '"+fileName+"' is blank. Files must contain information.");
                }
                // x is each individual character in the file
                int x;
                while ((x = br.read()) != -1) {
                    // create a string array where each string is a character
                    char character = (char) x;
                    // for each char, add to map if its not there, increment index if it is
                    if (!table.containsKey(character)) {
                        table.put(character, 1);
                    }
                    else {
                        int count = table.get(character);
                        table.put(character, count + 1);
                    }
                }
            }
            catch (IOException e){
                System.out.println("An IOException error was caught");
            }
            finally {
                try{
                    br.close();
                }
                catch (IOException e){
                    System.out.println("An IOException error was caught");
                }
            }
    }
    public Map getMap(){
        return table;
    }
    // test code for the Frequency Table
    public static void main(String[] args){
        // create new frequency table
        FrequencyTable table = new FrequencyTable("/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/testtext.txt");
        // comment out empty as you'd like. Tests the empty file test case.
//        FrequencyTable empty = new FrequencyTable("/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/empty.txt");
        System.out.println("Size:" + table.getMap().size());
        long i = 0;
        // iterator to iterate through the map
        Iterator <Map.Entry<Character, Integer>> it = table.getMap().entrySet().iterator();
        // while it.next exists
        while (it.hasNext()) {
            Map.Entry<Character, Integer> pair = it.next();
            //print out the pair
            System.out.println(pair);
            i += pair.getKey() + pair.getValue();
        }
    }
}
