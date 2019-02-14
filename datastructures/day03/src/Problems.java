import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        // TODO: your code here
        // For now, return a List that's correct size, but contains only 0s
        LinkedList<Integer> l = new LinkedList<>();
       // LinkedList<Integer> m = new LinkedList<>();
        int count =0;
        for (int i = 0; i < A.length ; i++) {
            int current = A[i];
            while (!l.isEmpty() && current < l.peekLast() && count < k) {
                l.removeLast();
                count++;

            }
            if (l.size() < A.length - k) {
                l.addLast(current);
            }
        }
            return l;

    }


    public static boolean isPalindrome(Node n) {

        Node current = n;
        int size = 0;
        while(current != null){
            current = current.next;
            size++;
        }
        if(size < 2){return true;}

        Node next = null;
        Node prev = null;
        current = n;
        int mid = (size/2 + size%2);
        int count = 0;
        while(current != null){
            if(count >= mid){
                //System.out.println("hit");
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }else {
                //System.out.println("pop");
                current = current.next;
                count++;
            }
        }
        Node fount = n;
        for(int i = 0; i < size/2; i++){
            if(fount.val!=prev.val){
                return false;
            }
            //stem.out.print();
            //stem.out.println();
            fount= fount.next;
            prev = prev.next;
        }
        return true;
    }

    public static String infixToPostfix(String s) {
        // TODO
        LinkedList<Character> l = new LinkedList<>();
        String sub = "";
        for(int i=0; i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                sub = sub+s.charAt(i)+" ";
            }
            if(s.charAt(i) == '+' || s.charAt(i) == '*'){
                l.addFirst(s.charAt(i));}
            if(s.charAt(i) ==')'){
                sub = sub+l.getFirst()+' ';
                l.removeFirst();
            }
        }
        //System.out.println(sub);

        return sub.substring(0,sub.length() - 1);
    }

}
