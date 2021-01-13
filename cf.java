/** this is the class that I will use to store character frequency together; they will be 'cf' objects
 *
 * cf objects will contain the frequency of a specific character
 */
public class cf {
    // this is var for the stat of char, initialized or not, 1 if yes, 0 if no. This was for the extra credit.
    private int char_initial_state = 0;
    private int frequency;
    private char character;

    // constructor overloading because we don't enter in characters for the composite trees in the tree creation step
    public cf(char c, int frequency){
        this.frequency = frequency;
        this.character = c;
        char_initial_state = 1;
    }
    // constructor for just frequency; character remains uninitialized
    public cf(int frequency){
        this.frequency = frequency;
    }

    public int getChar_initial_state(){
        return char_initial_state;
    }

    public int getFrequency(){
        return frequency;
    }

    public char getCharacter(){
        return character;
    }
    @Override
    public String toString(){
        return "Character:" + character + "; Frequency: " + frequency;
    }
}
