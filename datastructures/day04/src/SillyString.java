<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.Map;

>>>>>>> 170e3eaa258ce07b5f451e12f0bc2740ef342c15
public class SillyString {
    private final String innerString;

    public SillyString(String innerString) {
        this.innerString = innerString;
    }

    public String toString() {
        return innerString;
    }

    @Override
    public boolean equals(Object other) {
        return this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        // TODO What is bad about this hash function??
        int total = 0;
        for (int i=0; i<innerString.length(); i++) {
            total += innerString.charAt(i);
        }
        return total;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SillyString first = new SillyString("Hello");
        SillyString second = new SillyString("World");

        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
    }
}
