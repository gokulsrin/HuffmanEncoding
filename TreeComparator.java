
import java.util.Comparator;

/**
 * This is the TreeComparator that is being passed to the priority queue in its creation. It takes two InitialTrees as
 * parameters.
 */

public class TreeComparator implements Comparator <InitialTree> {
    public int compare(InitialTree t1, InitialTree t2){
        // we want to return if t1 is less as positive
        return t1.getData().getFrequency() - t2.getData().getFrequency() ;
    }
}
