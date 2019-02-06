package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        Node temp = new Node(c);
        Node temptail = tail;
        if (size > 0){
            tail.next = temp;
            tail = temp;
            tail.prev = temptail;
            size++;

        }else {
            head = temp;
            tail = temp;
            size++;
        }
    }

    public void addFirst(Chicken c) {
        Node temp = new Node(c);
        Node temphead = head;
        if (size > 0){
            head.prev = temp;
            head = temp;
            head.next = temphead;


            size++;

        }else {
            head = temp;
            tail = temp;
            size++;
        }
    }

    public Chicken get(int index) {
        if(index >= size) { throw new IndexOutOfBoundsException(); }
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.val;
    }

    public Chicken remove(int index) {
        if(index >= size) { throw new IndexOutOfBoundsException(); }
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        if(current.prev != null){current.prev.next = current.next;}
        if(current.next != null){current.next.prev = current.prev;}
        size--;
        return current.val;
    }

    public Chicken removeFirst() {
        Node gone = head;
        if (size > 1) {
            head = head.next;
            head.prev = null;
            size--;
            return gone.val;
        } else if (size == 1) {
            head = null;
            size--;
            return gone.val;
        } else {
            head = null;
            size = 0;
            return null;
        }
    }


    public Chicken removeLast() {
        Node gone = tail;
        if (size > 1){
            tail = tail.prev;
            tail.next = null;
            size--;
            return gone.val;
        }else if(size == 1){
            tail = null;
            size--;
            return gone.val;
        }else{
            tail = null;
            size = 0;
            return null;
        }

    }
}