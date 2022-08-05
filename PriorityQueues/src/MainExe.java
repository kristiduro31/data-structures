public class MainExe {
    public static void main(String[] args){
        PriorityQueue heap = new PriorityQueue();
        heap.addElement(15);
        heap.addElement(12);
        heap.addElement(10);
        heap.addElement(9);
        heap.printHeap();
      //  System.out.println(heap.deleteFirstElement());
        System.out.println();
       // heap.remove(3);
        heap.zvogeloPrioritet(3,8);
        heap.printHeap();

    }
}
