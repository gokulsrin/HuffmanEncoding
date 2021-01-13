import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.*;

/**
 * This CodeCompression class was created to do the compression of a text provided the original text, and the HashMap
 * containing each of the characters, and its binary string representation, as well as the input and output path names
 *
 * This class includes a test method for the compression
 */

public class CodeCompression {

    private BufferedReader input;
    private BufferedBitWriter output;

    public CodeCompression(HashMap <Character, String> code, String inputPathName, String outputPathName){
        try {
            File file = new File(inputPathName);
            // create input buffered reader and output bitwriter
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
            output = new BufferedBitWriter(outputPathName);
            // x is each individual character in the file
            int x;
            while ((x = input.read()) != -1) {
                // find the character
                char character = (char) x;
                // find the corresponding huffman code for the character
                String num = code.get(character);
                // create a character array from that code, each index being one of its characters
                char [] characters = num.toCharArray();
                for(char c: characters){
                    // write the bit
                    output.writeBit(c == '1');
                }

            }
        }
        catch (IOException e){
            System.out.println("IOExcpetion caught");
        }
        finally {
            try {
                input.close();
                output.close();
            }
            catch (IOException e){
                System.out.println("File not found");
            }
        }

    }
    // test for compression
    public static void main(String [] args){
        FrequencyTable table = new FrequencyTable("/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/testtext.txt");
        //create priorityTreequeue
        PriorityTreeQueue queue = new PriorityTreeQueue(table);
        //create the tree based on priority queue
        TreeCreation tree = new TreeCreation(queue.getQueue());
        // get the map
        System.out.println(tree.toString());
        HashMap <Character, String> code = tree.codeRetrieval();
        System.out.println(code);
        CodeCompression compress = new CodeCompression(code,"/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/testtext.txt", "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/compressedfile.txt");

    }
}
