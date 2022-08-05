import java.util.*;

public class PriorityQueue<AnyType> extends AbstractCollection<AnyType> {

    private static final int DEFAULT_CAPACITY= 100;
    private int currentSize;
    private AnyType [] array;
    private Comparator<? super AnyType> cmp;

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
        return getLeftChildIndex(index)<currentSize;
    }
    private boolean hasRightChild(int index){
        return getRightChildIndex(index)<currentSize;
    }
    private boolean hasParent(int index){
        return getParentIndex(index) < currentSize;
    }
    private AnyType leftChild(int index){return array[getLeftChildIndex(index)];}
    private AnyType rightChild(int index){
        return array[getRightChildIndex(index)];
    }
    private AnyType parent(int index){
        return array[getParentIndex(index)];
    }
    private void swap(int index1, int index2){
        AnyType temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue() {
        currentSize = 0;
        cmp= null;
        array =  (AnyType[]) new Object[ DEFAULT_CAPACITY+ 1 ];
    }
    public PriorityQueue(Comparator<? super AnyType> c) {
        currentSize = 0;
        cmp = c;
        array= (AnyType[]) new Object[ DEFAULT_CAPACITY+ 1 ];
    }
    public PriorityQueue(Collection<? extends AnyType> coll) {
        currentSize = coll.size();
        cmp = null;
        array= (AnyType[]) new Object[ DEFAULT_CAPACITY+ 1 ];
        int i = 0;
        for(AnyType item : coll) {array[i++] = item;
        buildHeap();}
    }

    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
    public void clear(){
        currentSize = 0;
    }
    public AnyType firstElement(){
        if(isEmpty())
            throw new NoSuchElementException();
        return array[1];
    }
//    public boolean addElement(AnyType element){
//        if(currentSize+1 == array.length)
//            doubleCapacity();
//        int hole = ++currentSize;
//        array[0] = element;
//        for( ; compare( element, array[ hole/ 2 ] ) < 0; hole/= 2 )
//            array[ hole] = array[ hole/ 2 ];
//        array[ hole] = element;
//        return true;
//    }
    public void addElement(AnyType element){
        doubleCapacity();
        array[currentSize] = element;
        currentSize++;
        heapifyUp(currentSize-1);
    }
    public AnyType deleteFirstElement(){
        if(currentSize == 0)
            System.out.println("Heap Array eshte bosh...!");
        AnyType item = array[0];
        array[0] = array[currentSize-1];
        currentSize--;
        heapifyDown(0);
        return item;
    }
    private int compare(AnyType lhs, AnyType rhs) {
        if( cmp == null)
            return ((Comparable) lhs).compareTo(rhs);
        else
            return cmp.compare( lhs, rhs);
    }
    private void heapifyUp(int ind) {
        int index = ind;

        while (hasParent(index) && ((Comparable) parent(index)).compareTo(array[index])>0) {  //compareTo(parent(index),array[index])>0
            // kushti i dyte per te pare nqs parent element is bigger
            // than the child's element atehere do te bejme swap keto 2 elemente
            swap(getParentIndex(index),index);
            index = getParentIndex(index); // move upwards (kalo ne parent element)
        }
    }
    private void heapifyDown(int ind) {
        int index = ind;
        while (hasLeftChild(index)){     // if a parent has a child there is a MUST to be having a left child
            int smallerChildIndex = getLeftChildIndex(index);   // declare and initialize index-in e child me te vogel me index te left child
            if(hasRightChild(index) && ((Comparable) rightChild(index)).compareTo(leftChild(index)) < 0)  // nqs ka dhe right child dhe ky right child eshe me i vogel se left child i mesiperm
                smallerChildIndex = getRightChildIndex(index);      // atehere ne i japim vlere index-it te child me te vogel ate te index-it te femijes se djathte

            if(((Comparable) array[index]).compareTo(array[smallerChildIndex]) < 0)
                break;                  // nqs elementi qe po krahasojme eshte me i vogel se elementi me indeks sa index-i smallesht child atehere eshte ne rregull
            else swap(index,smallerChildIndex);     // per ndryshe ne bejme swap keto 2 elemente
            index = smallerChildIndex;      // avancojme index tek index i smallest child
        }
    }
    public void printHeap(){
        for(int i = 0; i < currentSize; i++)
            System.out.print(array[i]+"\t");
    }
    private void doubleCapacity(){
        if(currentSize + 1 == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
    private void buildHeap() {
        for(int i = currentSize/ 2; i >= 0; i--)
            heapifyDown(i);
    }
    public void remove(int ind){
        array[ind] = array[currentSize--];
        buildHeap();
    }
    public void zvogeloPrioritet(int index, int sasia){
        int temp = (int) array[index]-sasia;
        array[index]=(AnyType)(Object)((int)array[index]-sasia);
        buildHeap();
    }
    public void rritPrioritet(int index, int sasia){
        int temp = (int) array[index]-sasia;
        array[index]=(AnyType)(Object)((int)array[index]+sasia);
        buildHeap();
    }
}
