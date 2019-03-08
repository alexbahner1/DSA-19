import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        // TODO
        //make into a tree
        // inodersort it
        // find middle put in tree
        // make child middle of the two
        System.out.print("value list length ");
        System.out.println(values.size());
        BinarySearchTree<Integer> bee = new BinarySearchTree<>();
        for(Integer val : values){
            bee.add(val);
        }
        List<Integer> sorted = bee.inOrderTraversal();
        System.out.print("sorted list length ");
        System.out.println(sorted.size());
        //BinarySearchTree<Integer> miniLvTree = new BinarySearchTree<>();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        BinarySearchTree<Integer> finTree = helperBST(sorted,tree);


        return finTree;
    }
    public static  BinarySearchTree<Integer>  helperBST(List<Integer> list,  BinarySearchTree<Integer> tree){
        //BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        if(list.size() == 0){
            //tree.add(list.get(0));
            return null; }
//        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int mid = list.size()/2;
        tree.add(list.get(mid));
        BinarySearchTree<Integer> left = helperBST(list.subList(0,mid), tree);
        BinarySearchTree<Integer> right = helperBST(list.subList(mid+1,list.size()), tree);
//        tree.root.leftChild =(left.root != null)? left.root:null;
//        tree.root.rightChild = (right.root != null)? right.root:null;
        return tree;
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // TODO
        return false;
    }
}
