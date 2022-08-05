package Heaps;

import java.util.ArrayList;

public class BinaryTree<AnyType extends Comparable>{
    public BinaryNode<AnyType> root;

    public BinaryTree() {
        this.root = null;
    }
    public BinaryTree(AnyType nodeElement){
        root = new BinaryNode<>(nodeElement);
    }
    public BinaryTree(BinaryNode<AnyType> root) {
        this.root = root;
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void printInOrder(BinaryNode<AnyType> node){ //printing order ==> nodes (L-Root-R)
        if(node == null)
            return;
        else{
            printInOrder(node.left);
            System.out.print(node.element+"\t");
            printInOrder(node.right);
        }
    }
    public void printPreOrder(BinaryNode<AnyType> node){  //printing order ==> nodes (Root-L-R)
        if(node == null)
            return;
        else{
            System.out.print(node.element+"\t");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
    public void printPostOrder(BinaryNode<AnyType> node){  //printing order ==> nodes (L-R-Root)
        if(node == null)
            return;
        else{
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.element+"\t");
        }
    }
    public int findMax(BinaryNode<AnyType> node){
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
    public int findMin(BinaryNode<AnyType> node){
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
    public void findParent(BinaryNode<AnyType> node,BinaryNode<AnyType> parent,AnyType targetElement){
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
    public int numberOfLeaves(BinaryNode<AnyType> root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        else return numberOfLeaves(root.left)+numberOfLeaves(root.right);
    }

    //nodes in BinaryTrees are nodes which have children
    public int numberOfFullNodes(BinaryNode<AnyType> root){
        if(root.left != null && root.right != null)  // as far as the node has still a node on it's left or right which is not null then the condition will go on
            return 1 + numberOfFullNodes(root.left)+numberOfFullNodes(root.right);
        else return 0; // is kinda the same of as the base condition which indicates the node has reached the end of the path
    }

    public int numberOfHalfNodes(BinaryNode<AnyType> root){
        if(root == null)
            return 0;
        if((root.left == null && root.right != null) || (root.left != null && root.right == null)) //decide if the node has only the left child or only the right child
            return 1;
        else return numberOfHalfNodes(root.left)+numberOfHalfNodes(root.right);
    }

    public int numberOfTotalNodes(BinaryNode<AnyType> root){
        if(root == null)  // base condition which indicates we have reaches the end of the call stack...
            return 0;
        else return 1 + numberOfTotalNodes(root.left)+numberOfTotalNodes(root.right);
    }

    public BinaryNode<AnyType> deleteLeaves(BinaryNode<AnyType> root){
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

    //depth is the number of nodes along the longest path from the root node down to the farthest leaf node
    public int maxDepth(BinaryNode<AnyType> root){
        if(root == null)  // base condition which indicates we have reaches the end of the call stack...
            return 0;
       else{
           int leftDepth = maxDepth(root.left);   // find the depth of each subtree...
           int rightDepth = maxDepth(root.right);
           if(leftDepth > rightDepth)             // return the largest of the calculated depths
               return leftDepth+1;
           else return rightDepth+1;
        }
    }
    public int findDepth(BinaryNode<AnyType> root, AnyType elementToFind){
        if(root == null)
            return 0;
        int distance = -1; // remember we are not considering counting the node whose element we want to find
             // checks if element found...        //checks for the element on the left                  //checks for the element on the right
        if ((root.element == elementToFind)||(distance = findDepth(root.left, elementToFind)) >= 0 ||(distance = findDepth(root.right, elementToFind)) >= 0)
            return distance + 1;
        return distance;
    }

    public void printOddElements(BinaryNode<AnyType> root){
        if(root == null)        //base condition to indicate we have reached the end of call stack...
            return;
        // printing order strategy is the same of the PrintInOrder... Left-Root-Right
        // so the printing strategy is interchangeable as wanted...
        printOddElements(root.left);
        if((int)root.element % 2 == 0)          //if the remainder is 0 then this element is fully dividable by 2 ==> odd number
            System.out.print(root.element+"   ");

        printOddElements(root.right);
    }

    public void printEvenElements(BinaryNode<AnyType> root){
        if(root == null)        //base condition to indicate we have reached the end of call stack...
            return;
        // printing order strategy is the same of the PrintInOrder... Left-Root-Right
        // so the printing strategy is interchangeable as wanted...
        printEvenElements(root.left);

        if((int)root.element % 2 != 0)      //if the remainder is NOT 0 then this element isn't fully dividable by 2 ==> even number
            System.out.print(root.element+"   ");

        printEvenElements(root.right);
    }

    public boolean isPalindrome(BinaryNode<AnyType> root){ // or void
        if(root == null)        // base case to indicate you have reached the end of the call stack...
            return false;
        if(root.left.element != root.right.element) {  // base case to indicate that a node of the left side is different from the right side
        //    System.out.println("\nBinary Tree is NOT a palindrome...");  // so if this condition is valid then it will be returned and exited
            return false;
        }
        isPalindrome(root.left);    // recursive call to go to the left nodes...
        isPalindrome(root.right);   // recursive call to go to the right nodes...
      //  System.out.println("\nBinary Tree is a palindrome...");
        return true;
    }

    public void reverseBinaryTree(BinaryNode<AnyType> root){
            if(root == null) // base case to indicate you have reached the end of the call stack...
                return;
            BinaryNode temp = root.left;  // swap the elements of the right side and the left side...
            root.left = root.right;
            root.right = temp;
            reverseBinaryTree(root.left);   // recursive call to go to the left nodes...
            reverseBinaryTree(root.right);  // recursive call to go to the right nodes...
    }

    // same methods as BST
    public BinaryNode<Integer> mergeBinaryTrees(BinaryNode<Integer> t1,BinaryNode<Integer> t2){
        if(t1 == null) // if the node t1 is null then we will use the other node... (case 1)
            return t2;
        if(t2 == null)
            return t1; // if the node t2 is null then we will use the other node... (case 2)
        // case 3 when either of the nodes are null
        t1.element += t2.element;
        t1.left = mergeBinaryTrees( t1.left, t2.left);  // merge recursively left side...
        t1.right = mergeBinaryTrees(t1.right, t2.right); // merge recursively right side...
        return t1; // return t1 since we will merge the nodes in te first tree
    }
    public int findHeightNode(BinaryNode<AnyType> targetNode){
        if(targetNode==null)
            return -1;
        return Math.max(findHeightNode(targetNode.left),findHeightNode(targetNode.right))+1;
    }
    public boolean isBalanced(BinaryNode<AnyType> root){
        return isBalancedRecursively(root) != -1;  // true if is not equal to -1
    }
    private int isBalancedRecursively(BinaryNode<AnyType> root) {
        if(root == null)
            return 0;  // gets the height of 0
        int leftHeight = isBalancedRecursively(root.left);  // finds the height of the left subtree
        if(leftHeight == -1)
            return -1;
        int rightHeight = isBalancedRecursively(root.right); // finds the height of the right subtree
        if(rightHeight == -1)
            return -1;
        int gap = Math.abs(leftHeight-rightHeight);
        if(gap>1)  // if the difference of subtree's heights is more than 1 than return -1
            return -1;
        return (Math.max(leftHeight,rightHeight)+1);
    }
    public boolean isBinarySearchTree(BinaryNode<Integer> root){
//        // empty tree is by default BST...
        if (root == null )
            return true;

        // below cases for parent with 2 children
        if ((root.left!=null && root.element> root.left.element) && (root.right!=null && root.element<root.right.element))
            return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);

        // below cases for parent with only 1 child
        else if (root.left==null && root.right!=null && root.right.element>root.element)
            return isBinarySearchTree(root.right);
        else if (root.left!=null && root.right==null && root.left.element<root.element)
            return isBinarySearchTree(root.left);

        return false;
    }
    static ArrayList<Integer> duplicates;
    public void checkTreeDuplicates(BinaryNode<Integer> root){
        if (root == null)
            return ;
        else {
            duplicates.add(root.element);
            checkTreeDuplicates(root.left);
            checkTreeDuplicates(root.right);
        }
    }
    public boolean checkDuplicates(ArrayList<Integer> duplicates){
        for(int i = 0; i < duplicates.size()-1; i++ ){
            for ( int j = i+1; j < duplicates.size(); j++){
                if ( duplicates.get(i) == duplicates.get(j))
                    return true;
            }
        }
        return false;
    }
    private boolean isComplete(BinaryNode<Integer> root,int index, int nrNodes){
        if(root == null)
            return true;
        if(index >= nrNodes)
            return false;
        return isComplete(root.left,2*index+1,nrNodes) && isComplete(root.right,2*index+2,nrNodes);
    }
    private boolean isHeapAux(BinaryNode<Integer> root){
        if(root.left == null && root.right == null)   // base case
            return true;
        if  (root.right == null)    // node eshte ne nivelin e parafundit dhe kontrollo nqs elementi i root eshte me i madh se elementi i left child
            return root.element>=root.left.element;
        else{
            if(root.element>=root.left.element && root.element>=root.right.element)
                return isHeapAux(root.left) && isHeapAux(root.right);
            return false;
        }
    }
    public boolean isHeap(BinaryNode<Integer> root){
        if (root == null)
            return true;
        int nrNode = numberOfTotalNodes(this.root);
        if(isComplete(root,0,nrNode)==true && isHeapAux(root)==true)
            return true;
        return false;
    }
}

