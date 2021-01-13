/**
 * This class is the main driver for the compression and decompression of the texts provided in this problem set.
 * This file will use only a main method, and it will create objects from all of the classes created in this file.
 *
 * The file path names are hardcoded into the input and output variables below. Adjust them as you would like.
 *
 * I will be signing onto this file and not the others
 *
 * @author Gokul Srinivasan
 * Date: 2/11/20
 */
public class MainDriver {
    public static void main(String[] args) {

        //inputs
        String file1_input = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/USConstitution.txt";
        String file2_input = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/WarAndPeace.txt";

        //compressed outputs
        String file1_compress = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/USConstitution_compressed.txt";
        String file2_compress = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/WarAndPeace_compressed.txt";

        //decompressed outputs
        String file1_decompress = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/USConstitution_decompressed.txt";
        String file2_decompress = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/WarAndPeace_decompressed.txt";

        // create frequency table for file 1
        FrequencyTable table1 = new FrequencyTable(file1_input);
        // create priorityqueue
        PriorityTreeQueue queue1 = new PriorityTreeQueue(table1);
        // create tree with priority queue
        TreeCreation tree1 = new TreeCreation(queue1.getQueue());
        // create a compressed file with compression object
        CodeCompression compress1 = new CodeCompression(tree1.codeRetrieval(), file1_input, file1_compress);

        //repeat all of the above steps for file 2

        // create frequency table for file 2
        FrequencyTable table2 = new FrequencyTable(file2_input);
        // create priorityqueue
        PriorityTreeQueue queue2 = new PriorityTreeQueue(table2);
        // create tree with priority queue
        TreeCreation tree2 = new TreeCreation(queue2.getQueue());
        // create a compressed file with compression object
        CodeCompression compress2 = new CodeCompression(tree2.codeRetrieval(), file2_input, file2_compress);

        //decompress file 1
        CodeDecompression decompress = new CodeDecompression(tree1.getTree(),file1_compress, file1_decompress);

        //decompress file 2
        CodeDecompression decompress2 = new CodeDecompression(tree2.getTree(),file2_compress, file2_decompress);
    }
}
