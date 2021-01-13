/** this is the class that I will be using to store each individual character as a root in the intitial tree
 *
 * The InitialTree stores data of type cf (another class defined earlier) and overrides the getData() and toString()
 * methods of binary tree. It also has a super method that calls the toString of binary tree to test the tree.
 *
 */

public class InitialTree extends BinaryTree {

    cf data;

    // creates a binary tree with the data type being "cf"
    public InitialTree(cf data, InitialTree left, InitialTree right) {
        super(data, left, right);
        this.data = data;
    }

    //return cf data
    @Override
    public cf getData(){
        return this.data;
    }

    //the other getter methods are already defined for us in the binaryTree class
    @Override
    public String toString(){
        return data.toString();
    }

    // method overload
    public String toSuperString(){
        return super.toString();
    }
}


