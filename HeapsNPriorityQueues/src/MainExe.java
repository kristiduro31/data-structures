import Heaps.MinimumHeap;

public class MainExe {
    public static void main(String[] args){
        MinimumHeap heap = new MinimumHeap();
        heap.addElement(15);
        heap.addElement(12);
        heap.addElement(10);
        heap.addElement(9);
        heap.printHeap();
        System.out.println("\n"+heap.isHeap(heap.items,heap.size));
    }
}
