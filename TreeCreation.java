import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * This is the TreeCreation class which creates composite tree recursively given the priority queue.
 *
 * Test code given in Tree Creation Driver.
 */

public class TreeCreation {

    private PriorityQueue <InitialTree> queue;
    private HashMap<Character, String> code;

    public TreeCreation(PriorityQueue <InitialTree> queue){
        this.queue = queue;
        // the case where the queue size is 1 implies either a.) repeat characters or b.) a single character; for either the soln is the same
        if(queue.size() == 1){
            //basically, if there's only one node in the queue, I'm going to create a parent node, and assign the previous node as its child
            //  the catch is, this tree will always have the child to the right, but functionally it makes no difference
                InitialTree t1 = queue.remove();
                //get the sum of t1 and 0
                cf data = new cf(t1.getData().getFrequency());
                //create the parent node
                InitialTree r = new InitialTree(data, t1, null);
                this.queue.add(r);
            }

        //execute algorithim to consolidate priority queue of just initial tree nodes into 1 large initial tree
        while(queue.size() != 1){
            //remove should remove the ones with the highest priority (or lowest freq)
            InitialTree t1 = queue.remove();
            InitialTree t2 = queue.remove();
            // create new cf data object containing only frequency which is the sum of t1 and t2
            cf data = new cf( t1.getData().getFrequency() + t2.getData().getFrequency());
            // create new initialTree with data, and t1 and t2 as children nodes
            InitialTree r = new InitialTree(data, t1, t2);
            this.queue.add(r);
        }
    }
    // this returns a map with keys being characters and values being binary representation of the nodes position on the tree
    public HashMap codeRetrieval(){
        code = new HashMap<>();
        InitialTree tree = queue.peek();
        codeRetrievalHelper(code, tree,"");
        return code;
    }
    // helper function for codeRetrievalHelper
    public void codeRetrievalHelper(HashMap<Character, String> code, InitialTree tree, String x){
        String numbers = x;
        // if there are children
        if(tree.hasLeft() || tree.hasRight()){
            //if there's only a left
            if((tree.hasLeft() && !tree.hasRight())){
                codeRetrievalHelper(code,(InitialTree)tree.getLeft(), numbers + "0");
            }
            //if there's only a right
            else if((!tree.hasLeft() && tree.hasRight())){
                codeRetrievalHelper(code,(InitialTree)tree.getRight(),numbers + "1");
            }
            //if both exist
            else{
                codeRetrievalHelper(code,(InitialTree)tree.getRight(), numbers + "1");
                codeRetrievalHelper(code,(InitialTree)tree.getLeft(), numbers + "0");
            }
        }
        //if the node is a child
        else{
            code.put(tree.getData().getCharacter(), numbers);
        }
    }
    public PriorityQueue<InitialTree> getTree(){
        return this.queue;
    }
    public String toString(){
        if(!queue.isEmpty()){
            String text = "super";
            return queue.peek().toSuperString();
        }
        else{
            return "Queue is empty";
        }
    }
}
