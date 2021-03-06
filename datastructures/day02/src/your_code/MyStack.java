package your_code;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private LinkedList<Integer> max;

    public MyStack() {
        ll = new LinkedList<>();
        max = new LinkedList<>();
    }


    @Override
    public void push(Integer e) {

        ll.addFirst(e);
        if (max.peek() == null || e > max.peek()){
            max.addFirst(e);
        }
    }

    @Override
    public Integer pop() {
        Integer pop = ll.removeFirst();
        if (pop == max.peek()){
            max.removeFirst();
        }
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        // TODO
        return max.peek();
    }
}
