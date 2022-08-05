public class ListNode<Anytype>{

    Anytype element;
    ListNode<Anytype> next;

    public ListNode(Anytype element) {
        this.element = element;
    }

    public ListNode(Anytype element, ListNode<Anytype> next) {
        this.element = element;
        this.next = next;
    }

    public ListNode() {}
}
