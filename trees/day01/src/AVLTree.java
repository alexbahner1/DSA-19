public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    /**
     * Delete a key from the tree rooted at the given node.
     */
    @Override
    TreeNode<T> delete(TreeNode<T> n, T key) {
        n = super.delete(n, key);
        if (n != null) {
            // TODO
            // update the height of the tree using the height of the left and right child
            //height();
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    /**
     * Insert a key into the tree rooted at the given node.
     */
    @Override
    TreeNode<T> insert(TreeNode<T> n, T key) {
        n = super.insert(n, key);
        if (n != null) {
            // TODO
            // update the height of the tree using the height of the left and right child
            //return balance(n);
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    /**
     * Delete the minimum descendant of the given node.
     */
    @Override
    TreeNode<T> deleteMin(TreeNode<T> n) {
        n = super.deleteMin(n);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    // Return the height of the given node. Return -1 if null.
    private int height(TreeNode<T> n) {
        // TODO
        if(n == null){return -1;}
        return n.height;
    }

    public int height() {
        return Math.max(height(root), 0);
    }

    // Restores the AVL tree property of the subtree. Return the head of the new subtree
    TreeNode<T> balance(TreeNode<T> n) {
        // TODO: (if you're having trouble, use pseudocode provided in slides)
        int Bf = balanceFactor(n);
        if(Bf > 1){
            if(balanceFactor(n.rightChild) <= -1){
                n.rightChild = rotateRight(n.rightChild);
            }
            n = rotateLeft(n);
        }
        if(Bf < -1){
            if(balanceFactor(n.leftChild) >= 1){
                n.leftChild = rotateLeft(n.leftChild);
            }
            n = rotateRight(n);
        }
        return n;
    }

    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     */
    private int balanceFactor(TreeNode<T> n) {
        //
        int Right = height(n.rightChild);
        int Left = height(n.leftChild);
        return Right - Left;
    }

    /**
     * Perform a right rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateRight(TreeNode<T> n) {
        // TODO
        TreeNode<T> x = n.leftChild;
        TreeNode<T> beta = x.rightChild;
        x.rightChild = n;
        n.leftChild = beta;
        n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
        x.height = 1 + Math.max(height(x.leftChild), height(x.rightChild));
        return x;
    }

    /**
     * Perform a left rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateLeft(TreeNode<T> n) {
        // TODO
        TreeNode<T> y = n.rightChild;
        TreeNode<T> beta = y.leftChild;
        y.leftChild = n;
        n.rightChild = beta;
        n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
        y.height = 1 + Math.max(height(y.leftChild), height(y.rightChild));
        return y;
    }
}
