import java.util.*;

/**
 * Test code for the tree creation class
 */

public class TreeCreationDriver {
    public static void main(String [] args) {
//      create new frequency table
        FrequencyTable table = new FrequencyTable("/Users/gokulsrin/IdeaProjects/gcs10/PS3/Input/testtext.txt");
        //create priorityTreequeue
        PriorityTreeQueue queue = new PriorityTreeQueue(table);
        // test if queue has constructed queue
        Iterator value = queue.getQueue().iterator();
        while(value.hasNext()){
            System.out.println(value.next());
        }
        //create the tree based on priority queue
        TreeCreation tree = new TreeCreation(queue.getQueue());
        // print the tree using toString
        System.out.println(tree.toString());
        //test the code that maps all characters
        Map <Character, String> map = tree.codeRetrieval();
        System.out.println(map);
    }

}
