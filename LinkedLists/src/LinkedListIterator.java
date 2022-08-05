public class LinkedListIterator<AnyType extends Comparable> {
    ListNode<AnyType> current;

    public LinkedListIterator() {
        current = null;
    }
    public LinkedListIterator(ListNode<AnyType> node) {
        this.current = node;
    }
    public boolean isValid(){
        return current!=null;
    }
    public AnyType retrieve(){
        if (isValid()) {
            return current.element;
        }
        else return null;
    }
    public void advance(){
       if(isValid()){
           current = current.next;
       }
    }
}
