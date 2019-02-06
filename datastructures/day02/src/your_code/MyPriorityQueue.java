package your_code;

import ADTs.QueueADT;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    private LinkedList<Integer> ll;

    public MyPriorityQueue() {
        ll = new LinkedList<>();
    }

    public void enqueue(int item) {

        int numpop = 0;
        for (int i = 0; i < ll.size(); i++ ){
            if(item <= ll.peek()){
                int pop = ll.removeFirst();
                ll.addLast(pop);
                ++numpop;
            }
        }
        ll.addFirst(item);
        for(int i = 0; i < numpop; i++){
            int pop = ll.removeFirst();
            ll.addLast(pop);
        }

    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        int pop = ll.removeFirst();

        return pop;

    }

}