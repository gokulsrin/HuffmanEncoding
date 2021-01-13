import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileWriter;
import java.util.PriorityQueue;

/**
 * This CodeDecompression class was created to decompress a compressed file provided an original priority queue with
 * a completed tree, as well as the input, and output path names\
 *
 * This class includes a test for the decompression
 */

public class CodeDecompression {
    private BufferedWriter output;
    private BufferedBitReader input;
    private InitialTree tree;
    public CodeDecompression(PriorityQueue <InitialTree> queue, String inputPathName, String outputPathName){
        //get the final tree from tree creation
        tree = queue.peek();

        try{
            input = new BufferedBitReader(inputPathName);
            output = new BufferedWriter(new FileWriter(outputPathName));
            char c;

            while (input.hasNext()) {
                boolean bit = input.readBit();
                    // move the tree to the right
                    if(bit){
                        tree = (InitialTree)tree.getRight();
                        // if the tree is a leaf
                        if(!tree.hasLeft() && !tree.hasRight()){
                            //get the char from that node
                            c = tree.getData().getCharacter();
                            // write the char to file
                            output.write(c);
                            //reset the tree to the original
                            tree = queue.peek();
                        }
                    }
                    //move the tree to the left
                    else{
                        tree = (InitialTree)tree.getLeft();
                        if(!tree.hasLeft() && !tree.hasRight()){
                            //get the char from that node
                            c = tree.getData().getCharacter();
                            // write the char to file
                            output.write(c);
                            //reset the tree to the original
                            tree = queue.peek();
                        }
                    }
                }
            }

        catch (IOException e){
            System.out.println("IOException caught");
        }
        finally {
            try{
                input.close();
                output.close();
            }
            catch (IOException e){
                System.out.println("IOException caught");
            }
        }
    }
    // test for decompression
    public static void main(String [] args){
        FrequencyTable table = new FrequencyTable("/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/testtext.txt");
        //create priorityTreequeue
        PriorityTreeQueue queue = new PriorityTreeQueue(table);
        //create the tree based on priority queue
        TreeCreation tree = new TreeCreation(queue.getQueue());
        //decompress
        CodeDecompression decompress = new CodeDecompression(tree.getTree(),"/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/compressedfile.txt", "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/decompressedfile.txt");
    }
}
