import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    static class Point {
        int x, y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Building {
        private int l, r, h;
        Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
//    public static List<Point> skyline(Building[] B) {
//        // TODO
////        if(B.length <2){
////            Point[] sline = now Point[3];
////            sline[0] = [0,0];
////            sline[1] = [B.l, B.h];
////            sline[3] = [B.r, 0];
////            return sline;}
////        Building[] a = Arrays.copyOfRange(array,0,array.length/2);
////        Building[] b = Arrays.copyOfRange(array,array.length/2, array.length);
////        Point[] left = Skyline(a);
////        Point[] right = Skyline(b);
////        Point[] sky = merge(left,right);
//        Point[] gh = null;
//        return gh ;
        //return new ArrayList<>();
    }
//    public List<Point> merge(Building[] a, Building[] b){
//        Point[] c = new Point[a.length + b.length];
//    }
}
//// first marge sort