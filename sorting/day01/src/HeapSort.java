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
        if (a[i] < leftChild(a[i]) || a[i] < rightChild(a[i])) {
            if (leftChild(a[i]) > rightChild(a[i])) {
                int temp = a[i];
                a[i] = leftChild(a[i]);
                leftChild(a[i]) = temp;
            } else{
                int temp = a[i];
                a[i] = rightChild(a[i]);
                rightChild(a[i]) = temp;
            }
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            // TODO
            sink(i)
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
        }

        return heap;
    }
}
