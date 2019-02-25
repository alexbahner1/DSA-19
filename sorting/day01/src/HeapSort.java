public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        // TODO
        int left = 2*i + 1;
        int right = 2*i +2;
        if(left > size-1){return;}
        if(right > size-1){
            if(heap[i] < heap[left]){
                swap(heap, i, left);
                return;

            }else{return;}
        }
        if(heap[i] < heap[left] || heap[i] < heap[right]){
            int max = (heap[left]>=heap[right])?left:right;
            swap(heap, i, max);
            sink(max);

        }else{return;}

    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            // TODO
            sink(i);
        }
    }

    /**
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);

        for (int i=size-1; i>0; i--) {
            // TODO
            swap(heap,0 , i);
            size--;
            sink(0);
        }

        return heap;
    }
}
