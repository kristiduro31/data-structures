package Heaps;

import java.util.Arrays;

public class MaximumHeap {
    private int capacity = 10;
    public int size = 0;
    public int [] items = new int [capacity];
    private int getLeftChildIndex(int parentIndex){
        return parentIndex*2+1;
    }
    private int getRightChildIndex(int parentIndex){
        return parentIndex*2+2;
    }
    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }
    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index)<size;
    }
    private boolean hasRightChild(int index){
        return getRightChildIndex(index)<size;
    }
    private boolean hasParent(int index){
        return getParentIndex(index)<size;
    }
    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    private int parent(int index){
        return items[getParentIndex(index)];
    }
    private void swap(int index1, int index2){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
    private void doubleCapacity(){
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }
    public int firstElement(){
        if(size == 0)
            System.out.println("Heap Array eshte bosh...!");
        return items[0];
    }
    public int deleteFirstElement(){
        if(size == 0)
            System.out.println("Heap Array eshte bosh...!");
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    public void addElement(int element){
        doubleCapacity();
        items[size] = element;
        size++;
        heapifyUp();
    }
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < items[index]) { // kushti i dyte per te pare nqs parent element is bigger
            // than the child's element atehere do te bejme swap keto 2 elemente
            swap(getParentIndex(index),index);
            index = getParentIndex(index); // move upwards (kalo ne parent element)
        }
    }
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)){     // if a parent has a child there is a MUST to be having a left child
            int smallerChildIndex = getLeftChildIndex(index);   // declare and initialize index-in e child me te vogel me index te left child
            if(hasRightChild(index) && rightChild(index) > leftChild(index))  // nqs ka dhe right child dhe ky right child eshe me i vogel se left child i mesiperm
                smallerChildIndex = getRightChildIndex(index);      // atehere ne i japim vlere index-it te child me te vogel ate te index-it te femijes se djathte
            if(items[index]<items[smallerChildIndex])
                break;                  // nqs elementi qe po krahasojme eshte me i vogel se elementi me indeks sa index-i smallesht child atehere eshte ne rregull
            else swap(index,smallerChildIndex);     // per ndryshe ne bejme swap keto 2 elemente
            index = smallerChildIndex;      // avancojme index tek index i smallest child
        }
    }
    public void printHeap(){
        for(int i = 0; i < size; i++)
            System.out.print(items[i]+"\t");
    }
    public boolean isHeap(int[] itm, int s){
        for (int i = 0; i<=(s-2)/2;i++) {
            if (itm[2*i+1] > itm[i])   // check nqs left child is bigger than his parent
                return false;
            if ((2*i+2)<s && (itm[2*i+2] > itm[i]))  // check nqs right child is within the array size and is bigger than his parent
                return false;
        }
        return true;
    }
}

