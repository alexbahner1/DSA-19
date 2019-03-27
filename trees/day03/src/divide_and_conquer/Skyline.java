package divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    public static class Point {
        public int x;
        public int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Building {
        private int l, r, h;
        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        // TODO
        if(B.length < 2){
            //if(B.length < 1){return;}

            ArrayList<Point> ref = new ArrayList<Point>();
            if(B.length < 1){return ref;}
            ref.add(new Point(B[0].l,B[0].h ));
            ref.add(new Point(B[0].r,0 ));
            return ref;
        }
        Building[] a = Arrays.copyOfRange(B,0,B.length/2);
        //System.out.println(a);
        Building[] b = Arrays.copyOfRange(B,B.length/2, B.length);
        //System.out.println(b);
        List<Point> left = skyline(a);
        List<Point> right = skyline(b);
        //return new ArrayList<>();
        return helperSkyline(left,right);
    }

    public static List<Point> helperSkyline(List<Point> a, List<Point> b) {
        // TODO
        ArrayList<Point> ref = new ArrayList<Point>();
        int i = 0;
        int j = 0;
        int maxA = 0;
        int maxB = 0;
        while(i < a.size() && j < b.size()){
            if(a.get(i).x == b.get(j).x){
                int x = a.get(i).x;
               int MAX = Math.max(a.get(i).y, b.get(j).y);
               if(MAX != maxA && MAX != maxB){
                   ref.add(new Point(x, MAX ));
               }
//                if(a.get(i).y > b.get(j).y && a.get(i).y != maxA && a.get(i).y != maxB ){
//                    ref.add(new Point(a.get(i).x, a.get(i).y ));}
//                if(a.get(i).y < b.get(j).y  && b.get(j).y != maxA && b.get(j).y != maxB ){
//                    ref.add(new Point(b.get(j).x, b.get(j).y ));}

                maxA = a.get(i).y;
                maxB = b.get(j).y;
                i++;
                j++;
            }

            else if(a.get(i).x < b.get(j).x){

                //if(a.get(i).y > maxA){
                if(a.get(i).y > maxB){
                    ref.add(new Point(a.get(i).x, a.get(i).y ));
                }else{
                    if( maxB < maxA){ref.add(new Point(a.get(i).x, maxB ));}
                }
                maxA = a.get(i).y;
                i++;
            }else{
                if(b.get(j).y > maxA){
                    ref.add(new Point(b.get(j).x, b.get(j).y ));
                }else{
                    if(maxA < maxB){ref.add(new Point(b.get(j).x, maxA ));}
                }
                maxB = b.get(j).y;
                j++;

            }
        }
        for(int g = i+j; g < (a.size()+b.size()); g++){
            if(i < a.size()){ ref.add(new Point(a.get(i).x, a.get(i).y )); i++;}
            if(j < b.size()){ ref.add(new Point(b.get(j).x, b.get(j).y )); j++;}
        }
        //return new ArrayList<>();
        return ref;
    }
}
