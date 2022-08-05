import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTree{  //has the same methods as BinaryTree + insert() methods etc...
    public BinaryNode<Integer> root;
    public BinarySearchTree() {
        this.root = null;
    }
    public BinarySearchTree(Integer nodeElement){
        root = new BinaryNode<>(nodeElement);
    }
    public BinarySearchTree(BinaryNode<Integer> root) {
        this.root = root;
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void printInOrder(BinaryNode<Integer> node){ //printing order ==> nodes (L-Root-R)
        if(node == null)
            return;
        else{
            printInOrder(node.left);
            System.out.print(node.element+"\t");
            printInOrder(node.right);
        }
    }
    public void printPreOrder(BinaryNode<Integer> node){  //printing order ==> nodes (Root-L-R)
        if(node == null)
            return;
        else{
            System.out.print(node.element+"\t");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
    public void printPostOrder(BinaryNode<Integer> node){  //printing order ==> nodes (L-R-Root)
        if(node == null)
            return;
        else{
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.element+"\t");
        }
    }
    public int findMax(BinaryNode<Integer> node){
        if(node == null)
            return Integer.MIN_VALUE;
        int max = (int) node.element;
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);

        if(leftMax > max)
            max = leftMax;
        if(rightMax > max)
            max = rightMax;

        return max;
    }
    public int findMin(BinaryNode<Integer> node){
        if(node == null)
            return Integer.MAX_VALUE;
        int min = (int)node.element;
        int leftMin = findMin(node.left);
        int rightMin = findMin(node.right);

        if(leftMin<min)
            min = leftMin;
        if(rightMin<min)
            min = rightMin;
        return min;
    }

    //we are going to find the parent node of the node,whose element is going to be targetElement
    public void findParent(BinaryNode<Integer> node,BinaryNode<Integer> parent,Integer targetElement){
        if(node == null) // base case if the node == null then this means that it has reached the end of its path so it will start popping functions from the call stack...
            return;
        if((node.element.compareTo(targetElement))==0) //base case if the node's value is equal to the targetElement then we will stop coz we found what we were looking for
            //so we will be printing the parent's node element...
            System.out.println("The element of the parent node of node with value = "+targetElement+", is ... "+ parent.element);
        else{   //otherwise we will search left and right down the paths recursively
            findParent(node.left,node,targetElement);
            findParent(node.right,node,targetElement);
        }
    }

    //leaves in BinaryTrees are nodes which have no children
    public int numberOfLeaves(BinaryNode<Integer> root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return numberOfLeaves(root.left)+numberOfLeaves(root.right);
    }

    //nodes in BinaryTrees are nodes which have children
    public int numberOfFullNodes(BinaryNode<Integer> root){
        if(root.left != null && root.right != null)  // as far as the node has still a node on it's left or right which is not null then the condition will go on
            return 1 + numberOfFullNodes(root.left)+numberOfFullNodes(root.right);
        else return 0; // is kinda the same of as the base condition which indicates the node has reached the end of the path
    }

    public int numberOfHalfNodes(BinaryNode<Integer> root){
        if(root == null)
            return 0;
        if((root.left == null && root.right != null) || (root.left != null && root.right == null)) //decide if the node has only the left child or only the right child
            return 1;
        else return numberOfHalfNodes(root.left)+numberOfHalfNodes(root.right);
    }
    public int numberOfTotalNodes(BinaryNode<Integer> root){
        if(root == null)  // base condition which indicates we have reaches the end of the call stack...
            return 0;
        else return 1 + numberOfTotalNodes(root.left)+numberOfTotalNodes(root.right);
    }
    public BinaryNode<Integer> deleteLeaves(BinaryNode<Integer> root){
        if(root == null)   // base condition which indicates we have reaches the end of the call stack...
            return null;

        if(root.left == null && root.right == null){  //condition to incicate that this node...doesnt have children...which means it is a leaf
            root = null;    //node becomes null...
            return null;
        }
        else{
            root.left = deleteLeaves(root.left);   //recursive call to go to the left children of the previous node from the call stack...
            root.right = deleteLeaves(root.right); //recursive call to go to the right children of the previous node from the call stack...
        }
        return root;
    }
    public int maxDepth(BinaryNode<Integer> root){   // find height is the same of the maxDepth
        if(root == null)  // base condition which indicates we have reaches the end of the call stack...
            return -1;
        else{
            int leftDepth = maxDepth(root.left);   // find the depth of each subtree...
            int rightDepth = maxDepth(root.right);
            if(leftDepth > rightDepth)             // return the largest of the calculated depths
                return leftDepth+1;
            else return rightDepth+1;
        }
    }
    public int findDepth(BinaryNode<Integer> root, Integer elementToFind){
        if(root == null)
            return 0;
        int distance = -1; // remember we are not considering counting the node whose element we want to find
        // checks if element found...        //checks for the element on the left                  //checks for the element on the right
        if ((root.element == elementToFind)||(distance = findDepth(root.left, elementToFind)) >= 0 ||(distance = findDepth(root.right, elementToFind)) >= 0)
            return distance + 1;
        return distance;
    }
    public void printOddElements(BinaryNode<Integer> root){
        if(root == null)        //base condition to indicate we have reached the end of call stack...
            return;
        // printing order strategy is the same of the PrintInOrder... Left-Root-Right
        // so the printing strategy is interchangeable as wanted...
        printOddElements(root.left);

        if((int)root.element % 2 == 0)          //if the remainder is 0 then this element is fully dividable by 2 ==> odd number
            System.out.print(root.element+"   ");

        printOddElements(root.right);
    }
    public void printEvenElements(BinaryNode<Integer> root){
        if(root == null)        //base condition to indicate we have reached the end of call stack...
            return;
        // printing order strategy is the same of the PrintInOrder... Left-Root-Right
        // so the printing strategy is interchangeable as wanted...
        printEvenElements(root.left);

        if((int)root.element % 2 != 0)      //if the remainder is NOT 0 then this element isn't fully dividable by 2 ==> even number
            System.out.print(root.element+"   ");

        printEvenElements(root.right);
    }
    public void symmetryBinaryTree(BinaryNode<Integer> root){
        if(root == null) // base case to indicate you have reached the end of the call stack...
            return;
        BinaryNode temp = root.left;  // swap the elements of the right side and the left side...
        root.left = root.right;
        root.right = temp;

        symmetryBinaryTree(root.left);   // recursive call to go to the left nodes...
        symmetryBinaryTree(root.right);  // recursive call to go to the right nodes...
    }
    public void insert(Integer key)  {
        root = insert_Recursive(root, key);
    }
    //recursive insert function
    private BinaryNode insert_Recursive(BinaryNode<Integer> root, Integer key) {
        //tree is empty
        if (root == null) {
            root = new BinaryNode(key);
            return root;
        }
        //traverse the tree
        if (key.compareTo(root.element)<0)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key.compareTo(root.element)>0)     //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }
    public void delete(Integer key){
        root = deleteRecursively(root,key);
    }
    private BinaryNode<Integer> deleteRecursively(BinaryNode<Integer> root, Integer targetElement){
        if(root == null)
            return root;
        else if(targetElement.compareTo(root.element)<0)
            root.left = deleteRecursively(root.left,targetElement);
        else if(targetElement.compareTo(root.element)>0)
            root.right = deleteRecursively(root.right,targetElement);
        else{
            // case 1 ---> the node is a leaf...
            if(root.left==null && root.right==null) {
                root = null;
                return root;
            }
            // case 2 ---> the node has only 1 child
            else if(root.left==null){
                root = root.right;
                root = null;
            }
            else if(root.right==null){
                root = root.left;
                root = null;
            }
            // case 3 ---> the node has 2 children
            else {
                BinaryNode<Integer> temp = new BinaryNode<>(findMin(root.right));
                root.element = temp.element;
                root.right = deleteRecursively(root.right, temp.element);
            }
        }
        return root;
    }
    public BinaryNode<Integer> mergeBinarySearchTrees(BinaryNode<Integer> t1,BinaryNode<Integer> t2){
        if(t1 == null) // if the node t1 is null then we will use the other node... (case 1)
            return t2;
        if(t2 == null)
            return t1; // if the node t2 is null then we will use the other node... (case 2)
        // case 3 when either of the nodes are null
        t1.element += t2.element;
        t1.left = mergeBinarySearchTrees( t1.left, t2.left);  // merge recursively left side...
        t1.right = mergeBinarySearchTrees(t1.right, t2.right); // merge recursively right side...
        return t1; // return t1 since we will merge the nodes in te first tree
    }
    public int findHeightNode(BinaryNode<Integer> targetNode){
        if(targetNode==null)
            return -1;  // this is done so the leaf's height is 0 // in other words... -1+1 = 0 (+1 from the recursive method below...)
        return Math.max(findHeightNode(targetNode.left),findHeightNode(targetNode.right))+1;
    }
    public boolean isBalanced(BinaryNode<Integer> root){
        return isBalancedRecursively(root) != -1;  // true if is not equal to -1
    }
    private int isBalancedRecursively(BinaryNode<Integer> root) {
        // method I
//        if(root == null)
//            return 0;  // gets the height of 0
//        int leftHeight = isBalancedRecursively(root.left);  // finds the height of the left subtree
//        if(leftHeight == -1)
//            return -1;
//        int rightHeight = isBalancedRecursively(root.right); // finds the height of the right subtree
//        if(rightHeight == -1)
//            return -1;
//        int gap = Math.abs(leftHeight-rightHeight);
//        if(gap>1)  // if the difference of subtree's heights is more than 1 than return -1
//            return -1;
//        return (Math.max(leftHeight,rightHeight)+1);
        // method II
        if(root==null)
            return 0;

        int leftHeight= isBalancedRecursively(root.left);   // finds the height of the left subtree
        int rightHeight = isBalancedRecursively(root.right);   // finds the height of the right subtree

        if(leftHeight != -1 && rightHeight !=-1 && Math.abs(leftHeight-rightHeight)<=1)
            return 1 + Math.max(leftHeight,rightHeight);
        else
            return -1;
    }
    public int sumOfLeaves(BinaryNode<Integer> root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.element;
        return sumOfLeaves(root.left)+sumOfLeaves(root.right);
    }
    public int sumAllNodes(BinaryNode<Integer> root){
        if (root == null)
            return 0;
        return root.element + sumAllNodes(root.right) + sumAllNodes(root.left);
    }
    public int sumLeftLeaves(BinaryNode<Integer> root){
        if (root == null)
            return 0;
        if (root.left!=null)
            if(root.left.left==null && root.left.right==null)
                return root.left.element;
        return sumLeftLeaves(root.left) + sumLeftLeaves(root.right);
    }
    public int sumRightLeaves(BinaryNode<Integer> root){
        if (root == null)
            return 0;
        if (root.right!=null)
            if(root.right.left==null && root.right.right==null)
                return root.right.element;
        return sumRightLeaves(root.left) + sumRightLeaves(root.right);
    }
    public boolean identicalTrees(BinaryNode<Integer> a, BinaryNode<Integer> b) {
        //1. both empty
        if (a == null && b == null)
            return true;
        // 2. both non-empty -> compare them
        if (a != null && b != null)
            return (a.element == b.element && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));
        // 3. one empty, one not -> false
        return false;
    }
    public void printPaths(BinaryNode<Integer> node) {
        int path[] = new int[1000];
        printPathsRecursively(node, path, 0);
    }
    /* Recursive helper function -- given a node, and an array containing
       the path from the root node up to but not including this node,
       print out all the root-leaf paths. */
    private void printPathsRecursively(BinaryNode<Integer> node, int path[], int pathLen) {
        if (node == null)
            return;
        /* append this node to the path array */
        path[pathLen] = node.element;
        pathLen++;
        /* it's a leaf, so print the path that led to here */
        if (node.left == null && node.right == null)
            printArray(path, pathLen);
        else {
            /* otherwise try both subtrees */
            printPathsRecursively(node.left, path, pathLen);
            printPathsRecursively(node.right, path, pathLen);
        }
    }
    /* Utility that prints out an array on a line */
    private void printArray(int nr[], int len) {
        for (int i = 0; i < len; i++)
            System.out.print(nr[i] + " ");
        System.out.println("");
    }
    public static ArrayList path;
    public boolean printPathRootToNode(BinaryNode<Integer> root, BinaryNode<Integer> dest){
            if(root==null)
                return false;
            if(root == dest || printPathRootToNode(root.left,dest) || printPathRootToNode(root.right,dest)){
                path.add(root.element);
                return true;
            }
            return false;
    }
    public boolean checkFull(BinaryNode<Integer> root){
        //empty tree, return true
        if(root==null)
            return true;
        // if node is a leaf node, return true
        if(root.left==null && root.right==null)
            return true;
        //check if node has only one child
        if((root.left==null && root.right!=null)||(root.left!=null && root.right==null))
            return false;
        //check recursively left and right child
        return checkFull(root.left) && checkFull(root.right);
    }
    public int findNrParentChildSumEqualToK(BinaryNode<Integer> node,BinaryNode<Integer> parent,Integer targetSum){
        if(node == null)
            return 0;
        int pair = findNrParentChildSumEqualToK(node.left,node,targetSum) +  findNrParentChildSumEqualToK(node.right,node,targetSum);
        if((node.element+parent.element)==targetSum)
            pair += 1;
        return pair;
    }
    public int nrOfNodesBiggerThanK(BinaryNode<Integer> root,Integer k){
        if(root==null)
            return 0;
        int nrNodesGreater = nrOfNodesBiggerThanK(root.right,k) + nrOfNodesBiggerThanK(root.left,k);
        if(root.element>k) {
            System.out.print(root.element+" ");
            nrNodesGreater += 1;
        }
        return nrNodesGreater;
    }
    public void printNodesAt_K_Depth(BinaryNode<Integer> root, int k){
        if( root == null || k < 0)  // reached the end
            return;
        if(k == 0)   // reached the destination
            System.out.print(root.element+"  ");
        else{
            printNodesAt_K_Depth(root.left,k-1);
            printNodesAt_K_Depth(root.right,k-1);
        }
    }
    public int sumOfNodesAtKDepth(BinaryNode<Integer> root, int k){
        if(root == null || k < 0 )
            return 0;
        int sumNodes = sumOfNodesAtKDepth(root.left,k-1) + sumOfNodesAtKDepth(root.right,k-1);
        if(k == 0)
            sumNodes += root.element;
        return sumNodes;
    }
    public int nrOfFullNodesAtKDepth(BinaryNode<Integer> root, int k){
        if(root == null || k < 0 )
            return 0;
        int nrNodes = nrOfFullNodesAtKDepth(root.left,k-1) + nrOfFullNodesAtKDepth(root.right,k-1);
        if(k == 0 && root.left!=null && root.right!=null)
            nrNodes += 1;
        return nrNodes;
    }
    static ArrayList<Integer> maxNodesAtK;
    public void nodesAtDepthK(BinaryNode<Integer> root, int k){
        if(root==null || k<0)
            return ;
        if(k == 0)
            maxNodesAtK.add(root.element);
        else{
            nodesAtDepthK( root.left, k-1);
            nodesAtDepthK( root.right, k-1);
        }
    }
}

