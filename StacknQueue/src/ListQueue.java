public class ListQueue<AnyType extends Comparable>{

    private ListNode<AnyType> front;
    private ListNode<AnyType> back;

    public ListQueue() {
        front = back = null;
    }
    private boolean isEmpty() {
        return front == null;
    }
    public void enqueue(AnyType element){
        if(isEmpty())
            back = front = new ListNode<>(element);
        else
            back = back.next = new ListNode<>(element);
    }
    public AnyType dequeue(){
        if(isEmpty()) {
            System.out.println("Queue eshte bosh...!");
            return null;
        }
        else{
            AnyType returnValue = this.front.element;
            front = front.next;
            return returnValue;
        }
    }
    public void makeEmpty(){
        front = back = null;
    }
    public int size(){
        int size = 0;
        ListNode<AnyType> temp = this.front;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    public ListQueue<AnyType> reverse() {
        ListQueue<AnyType> rev = new ListQueue<>();
        ListNode<AnyType> old = this.back;
        while(!this.isEmpty()){
            while(front!=old){
                enqueue(dequeue());
            }
            rev.enqueue(dequeue());
            old = this.back;
        }
        rev.copyAtList(this);
        return this;
    }

    public ListQueue copyAtList(ListQueue<AnyType> dest){//LinkedList<AnyType> toBeCopiedList){
        ListNode<AnyType> itr = this.front;
        while(itr!=null){
            dest.enqueue(itr.element);
            itr = itr.next;
        }
        return dest;
    }

    public void printQueue(){
        ListNode<AnyType> temp = front;
        while (temp!=null){
         System.out.print(temp.element+ "  ");
         temp = temp.next;
        }
        System.out.println();
    }
    public void sortList(){

        ListNode<AnyType> current = front;
        ListNode<AnyType> pos = null;
        AnyType temp;

        while (current != null) {
            pos = current.next;
            while (pos != null) {
                if ((current.element).compareTo(pos.element)>0) {
                    temp = (AnyType) current.element;
                    current.element = pos.element;
                    pos.element = temp;
                }
                pos = pos.next;
            }
            current = current.next;
        }
    }
    //sqarim...eshte kryer me 2 cikle nje cikel i jashtem qe cdo element i queue te kontrollohet dhe nje cikel i brendshem
    //ku ne te cilin, secilin prej ketyre elementeve *i* e kontrollojme me cdo element tjeter
    public void removeDuplicates(){
        ListNode i = front, j;
        while (i != null && i.next != null) {
            j = i;
            while (j.next != null) {
                if (i.element == j.next.element) {
                    j.next = j.next.next;
                }
                else j = j.next;
            }
            i = i.next;
        }
    }
    public ListQueue mergeQueue(ListQueue<AnyType> a1,ListQueue<AnyType> a2){
        ListQueue<AnyType> merge = new ListQueue<>();
        ListQueue<AnyType> temp = new ListQueue<>();
        while(!a1.isEmpty()) {
            AnyType tempValue = a1.dequeue();
            merge.enqueue(tempValue);
            temp.enqueue(tempValue);
        }
        temp.copyAtList(a1);
        temp.makeEmpty();

        while(!a2.isEmpty()) {
            AnyType tempValue = a2.dequeue();
            merge.enqueue(tempValue);
            temp.enqueue(tempValue);
        }
        temp.copyAtList(a2);

        merge.printQueue();
        return merge;
    }
}
