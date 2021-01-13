public class BoundaryTest {
    // here I will test the 3 boundary cases described
    public static void main(String [] args){

        //input files
        String single_char_input = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/singlechar.txt";
        String repeating_char_input = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/testtext.txt";
        String empty_file_input = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/empty.txt";

        //compressed output
        String single_char_compressed = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/singlechar_compressed.txt";
        String repeating_char_compressed = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/compressedfile.txt";
        String empty_file_compressed = "";

        //decompressed output
        String single_char_decompressed = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/singlechar_decompressed.txt";
        String repeating_char_decompressed = "/Users/gokulsrin/IdeaProjects/gcs10/PS3/output/decompressedfile.txt";
        String empty_file_decompressed = "";

        // we leave both empty compressed and decompressed files blank because an error is thrown at the beginning;

        //1.) Single Character File

        // create frequency table for single char
        FrequencyTable table1 = new FrequencyTable(single_char_input);
        // create priorityqueue
        PriorityTreeQueue queue1 = new PriorityTreeQueue(table1);
        // create tree with priority queue
        TreeCreation tree1 = new TreeCreation(queue1.getQueue());
        // create a compressed file with compression object
        CodeCompression compress1 = new CodeCompression(tree1.codeRetrieval(), single_char_input, single_char_compressed);
        // create a decompressed file
        CodeDecompression decompress1 = new CodeDecompression(tree1.getTree(),single_char_compressed, single_char_decompressed);

        //2.) Repeat Character File
        // create frequency table for repeat char
        FrequencyTable table2 = new FrequencyTable(repeating_char_input);
        // create priorityqueue
        PriorityTreeQueue queue2 = new PriorityTreeQueue(table2);
        // create tree with priority queue
        TreeCreation tree2 = new TreeCreation(queue2.getQueue());
        // create a compressed file with compression object
        CodeCompression compress2 = new CodeCompression(tree2.codeRetrieval(), repeating_char_input, repeating_char_compressed);
        // create a decompressed file
        CodeDecompression decompress2 = new CodeDecompression(tree2.getTree(),repeating_char_compressed, repeating_char_decompressed);

        //3.) Empty File
        // create frequency table for empty
//        FrequencyTable table3 = new FrequencyTable(empty_file_input);
        // you can't
        // error is thrown with blank files.
        //user has to provide file with something in it
        //comment this out to run the other two tests
    }
}
