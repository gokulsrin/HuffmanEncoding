import java.util.*;

/**
 * The PriorityTreeQueue class takes a frequency table of all the characters, and creates a priority queue, with each
 * constituent being an InitialTree with just the one node containing the cf of the character and frequency from each
 * entry in the Frequency Table
 *
 */

public class PriorityTreeQueue {

    private ArrayList<InitialTree> initialTrees;
    private PriorityQueue<InitialTree> queue;

    public PriorityTreeQueue(FrequencyTable table) {
        //need to construct initial tree for every pair in table
        initialTrees = new ArrayList<>();
        long i = 0;
        // iterator to iterate through the map
        Iterator<Map.Entry<Character, Integer>> it = table.getMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> pair = it.next();
            //create new cf ("character-pair") object
            cf data = new cf(pair.getKey(), pair.getValue());
            //use this cf to create a tree with just central node and append to initialTrees
            initialTrees.add(new InitialTree(data, null, null));
            i += pair.getKey() + pair.getValue();
        }
        //create new comparator to pass to priority queue
        Comparator <InitialTree> freqCompare = new TreeComparator();
        //pass to queue the comparator
       queue = new PriorityQueue<>(freqCompare);
       // add all of the initial trees to the queue
       queue.addAll(initialTrees);
    }

    public PriorityQueue getQueue(){
        return queue;
    }
}

