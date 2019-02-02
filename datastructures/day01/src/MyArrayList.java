public class MyArrayList {
    private Cow[] elems;
    private int size;

    // TODO: Runtime: O(1)
    public MyArrayList() {
        elems = new Cow[10];
        size = 0;

    }

    // TODO: Runtime: O(1)
    public MyArrayList(int capacity) {
        elems = new Cow[capacity];
        size = 0;
    }

    // TODO: Runtime: O(1)
    public void add(Cow c) {
        if (size + 1 > elems.length) {
            Cow[] temp = new Cow[elems.length * 2];
            System.arraycopy(elems, 0, temp, 0, size);
            elems = temp;
        }
        elems[size] = c;
        size = 1 + size;
    }

    // TODO: Runtime: O(1)
    public int size() {
        return size;
    }

    // TODO: Runtime: O(1)
    public Cow get(int index) {
        return elems[index];
    }

    // TODO: Runtime: O(n)
    public Cow remove(int index) {
        if(index >= size) { throw new IndexOutOfBoundsException(); }
        if (size - 1 < elems.length/4){
            Cow[] temp = new Cow[elems.length/2];
            System.arraycopy(elems, 0, temp, 0, size);
            elems = temp;
        }
        Cow badCow = elems[index];
        for (int i = 0; i < elems.length-1 - index; i++){
            elems[index+i] = elems[index+1+i];
        }
        size = size -1;
        return badCow;
    }

    // TODO: Runtime: O(n)
    public void add(int index, Cow c) {
        if(index > size) { throw new IndexOutOfBoundsException(); }
        if (size + 1 > elems.length){
            Cow[] temp = new Cow[elems.length*2];
            System.arraycopy(elems, 0, temp, 0, size);
            elems = temp;
        }
        for (int i = size-1; i >= index-1; i--){
            if(i < index){
                elems[index] = c;
                size = size +1;
            } else {
                elems[i+1] = elems[i];
            }
        }
    }
}