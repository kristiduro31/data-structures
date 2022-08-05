import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainExe {
    public static void main(String[] args){

        // Binary Tree executed...
        BinaryTree<Integer> t1 = new BinaryTree<Integer>(3);
        t1.root.left = new BinaryNode<>(4);
        t1.root.right = new BinaryNode<>(2);
        t1.root.right.left = new BinaryNode<>(7);
        t1.root.right.left.left = new BinaryNode<>(9);
        t1.root.right.right = new BinaryNode<>(8);
        t1.root.left.left = new BinaryNode<>(6);
        t1.root.left.right = new BinaryNode<>(5);
        t1.printInOrder(t1.root);
        System.out.println("\nLargest number on BinaryTree: "+t1.findMax(t1.root));
        System.out.println("Smallest number on BinaryTree: "+t1.findMin(t1.root));
        t1.findParent(t1.root,t1.root,4);
        System.out.println("Number of Leaves on Binary Tree: "+t1.numberOfLeaves(t1.root));
        System.out.println("Number of Nodes which have Both Children on Binary Tree: "+t1.numberOfFullNodes(t1.root));
        System.out.println("Number of Nodes which have ONLY ONE Child on Binary Tree: "+t1.numberOfHalfNodes(t1.root));
        System.out.println("Total Number of Nodes on Binary Tree: "+t1.numberOfTotalNodes(t1.root));
        System.out.println("Max Depth of Binary Tree: "+t1.maxDepth(t1.root));
        System.out.println("Depth of this particular node is: "+t1.findDepth(t1.root,6));
        System.out.println("Printing all odd elements of the Binary Tree (below)");
        t1.printOddElements(t1.root);
        System.out.println("\nPrinting all even elements of the Binary Tree (below)");
        t1.printEvenElements(t1.root);
        System.out.println();       // \n purpose only...
        t1.reverseBinaryTree(t1.root);
        t1.printInOrder(t1.root);
//        t1.deleteLeaves(t1.root);
//        t1.printInOrder(t1.root);
//        t1.isPalindrome(t1.root);
        System.out.println("\nIs this Binary Tree a palindrome? "+t1.isPalindrome(t1.root));

        BinaryTree.duplicates = new ArrayList<Integer>();
        t1.checkTreeDuplicates(t1.root);
        System.out.println(t1.checkDuplicates(BinaryTree.duplicates));

        System.out.println();
        System.out.println();
        BinaryTree<Integer> t4 = new BinaryTree<Integer>(7);
        t4.root.left = new BinaryNode<>(4);
        t4.root.right = new BinaryNode<>(10);
        t4.root.left.right = new BinaryNode<>(9);
        t4.root.left.left = new BinaryNode<>(8);

        System.out.println("Is this Binary Tree a BST : "+t4.isBinarySearchTree(t4.root));

        // Binary Search Tree executed...
        // All other BinaryTree methods are working as expected on Binary Search Tree

        BinarySearchTree t2 = new BinarySearchTree();
        t2.insert(8);
        t2.insert(27);
        t2.insert(13);
        t2.insert(15);
        t2.insert(32);
        t2.insert(20);
        t2.insert(12);
        t2.insert(50);
        t2.insert(29);
        t2.insert(11);
        System.out.println();       // \n purpose only...
        System.out.println();       // \n purpose only...
        t2.printInOrder(t2.root);
        System.out.println();       // \n purpose only...
        t2.delete(11);
        t2.printInOrder(t2.root);
        t2.symmetryBinaryTree(t2.root);
        System.out.println();       // \n purpose only...
        t2.printInOrder(t2.root);

        BinarySearchTree t3 = new BinarySearchTree();
        t3.insert(15);
        t3.insert(2);
        t3.insert(10);
        t3.insert(1);
//        t3.insert(10);
        t3.insert(17);
        t3.insert(16);
        t3.insert(20);
////        t3.insert(16);
//        t3.insert(31);
//        t3.insert(40);
//        t3.root.left.left = new BinaryNode<>(20);
//        t3.root.left.left.left = new BinaryNode<>(40);
//        t2.mergeBinarySearchTrees(t2.root,t3.root);
        System.out.println();       // \n purpose only...
        System.out.println();       // \n purpose only...
        System.out.println();
        t3.printPreOrder(t3.root);
        System.out.println();
        t3.printInOrder(t3.root);
        System.out.println();
        System.out.println("Height of root: "+t2.findHeightNode(t3.root));
        System.out.println("Height of root: "+t3.maxDepth(t3.root));
        System.out.println(t3.isBalanced(t3.root));
        System.out.println(t3.sumOfLeaves(t3.root));
        System.out.println(t3.sumLeftLeaves(t3.root));
        System.out.println(t3.sumRightLeaves(t3.root));
        t3.printPaths(t3.root);

        System.out.println(t3.sumAllNodes(t3.root));

        t3.path = new ArrayList();
        t3.printPathRootToNode(t3.root,t3.root.left.right);
        Collections.reverse(t3.path);
        System.out.println("Path " + t3.path);
        System.out.println(t3.checkFull(t3.root));

        System.out.println(t3.findNrParentChildSumEqualToK(t3.root,t3.root,31));
        System.out.println(t3.nrOfNodesBiggerThanK(t3.root,16));
        t3.printNodesAt_K_Depth(t3.root,2);
        System.out.println();
        System.out.println(t3.sumOfNodesAtKDepth(t3.root,1));
        System.out.println(t3.nrOfFullNodesAtKDepth(t3.root,1));

        t3.maxNodesAtK = new ArrayList<>();
        t3.nodesAtDepthK(t3.root, 1);
        System.out.println(Collections.max(t3.maxNodesAtK));
    }
}
