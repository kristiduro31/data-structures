package Heaps;

public class BinaryNode<AnyType>{
    AnyType element;
    BinaryNode<AnyType> left;
    BinaryNode<AnyType> right;

    public BinaryNode() {
        this.element = null;
        this.left = null;
        this.right = null;
    }
    public BinaryNode(AnyType element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }
    public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
