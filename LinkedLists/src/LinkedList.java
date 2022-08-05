
public class LinkedList<AnyType extends Comparable> {
    private ListNode<AnyType> header;

    public LinkedList() {
        header = new ListNode<AnyType>(null);
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public void makeEmpty() {
        header.next = null;
    }

    public LinkedListIterator<AnyType> zeroth() {
        return new LinkedListIterator<AnyType>(header);
    }

    public LinkedListIterator<AnyType> first() {
        return new LinkedListIterator<AnyType>(header.next);
    }

    public LinkedListIterator<AnyType> find(AnyType x) {
        ListNode<AnyType> node = header.next;
        while (node != null && !node.element.equals(x)) {
            node = node.next;
        }
        LinkedListIterator<AnyType> itr = new LinkedListIterator<AnyType>(node);
        return itr;
    }

    public LinkedListIterator<AnyType> findPrevious(AnyType x) {
        ListNode<AnyType> itr = header;
        while (itr.next != null && !itr.next.element.equals(x)) {
            itr = itr.next;
        }
        LinkedListIterator<AnyType> i = new LinkedListIterator<AnyType>(itr);
        return i;
    }

    public void printList(LinkedList<?> list) {

        if (list.isEmpty()) {
            System.out.println("Lista eshte bosh !");
        } else {
            System.out.println();
            LinkedListIterator<?> itr = list.first();
            for (; itr.isValid(); itr.advance()) {
                System.out.print(itr.retrieve() + "->");
            }
        }
        System.out.print("NULL");
    }

    public void insert(AnyType x) {
        ListNode<AnyType> itr = header;
        if (itr.next == null)
            itr.next = new ListNode<>(x, itr.next);
        else {
            while (itr.next != null) {
                itr = itr.next;
            }
            itr.next = new ListNode<>(x, itr.next);
        }
    }

    public void insertAt(AnyType x, int pos) {
        int i = 1; //duam ta vendosim kete element ne position te pos dhe jo tek pos-1
        ListNode itr = header;
        ListNode node = new ListNode<>(x);
        while (i != pos) {
            itr = itr.next;
            i++;
        }
        node.next = itr.next;
        itr.next = node;
    }

    public void remove(AnyType x) {
        ListNode<AnyType> itr = header;
        while (!itr.next.element.equals(x)) {
            itr = itr.next;
        }
        itr.next = itr.next.next;
    }

    public AnyType findValue(int pos) {
        int i = 0;
        ListNode<AnyType> itr = header;

        while (itr.next != null && i != pos) {
            itr = itr.next;
            i++;
        }
        if (itr.next == null) {
            System.out.println("\nKy indeks i elementit qe kerkuat nuk ekziston !");
            return null;
        } else return itr.element;
    }

    public int sizeList(LinkedList<AnyType> list) {
        int count = 0;
        ListNode<AnyType> itr = header;
        while (itr.next != null) {
            count++;
            itr = itr.next;
        }
        return count;
    }

    public int findBetween(AnyType x, AnyType y) {
        int i = -1;
        ListNode<AnyType> itr = header;
        ListNode<AnyType> node1 = new ListNode<>(x);
        ListNode<AnyType> node2 = new ListNode<>(y);

        while (!itr.next.element.equals(node1.element))
            itr = itr.next;

        while (!itr.next.element.equals(node2.element)) {
            i++;
            itr = itr.next;
        }
        return i;
    }

    public AnyType gjejMin() {
        ListNode<AnyType> itr = header;
        AnyType min = header.next.element;

        while (itr.next != null) {
            if (itr.next.element.compareTo(min) < 0) {
                min = itr.next.element;
            }
            itr = itr.next;
        }
//        itr = header;
//        while (itr.next!=null){
//            if(itr.next.element.compareTo(max)>0){
//                max = itr.next.element;
//            }
//            itr = itr.next;
//        }
        System.out.println("Vlera minimale e linkedlist eshte: " + min);
        return min;
        // System.out.println(max);
        //fshijme node qe ka minimumin dhe me pas i bejme insert ne fund fare te listes
        //fshijme node qe ka max dhe me pas i bejme insert ne fillim fare te listes duke e zhvendosur
    }

    public void zhvendosMin(LinkedList<AnyType> list) {
        AnyType min = list.gjejMin();
        list.remove(min);
        list.insert(min);
    }

    public AnyType gjejMax() {
        ListNode<AnyType> itr = header;
        AnyType max = header.next.element;
        while (itr.next != null) {
            if (itr.next.element.compareTo(max) > 0) {
                max = itr.next.element;
            }
            itr = itr.next;
        }
        System.out.println("Vlera max e linkedlist eshte: " + max);
        return max;
    }

    public void zhvendosMax(LinkedList<AnyType> list) {
        AnyType max = list.gjejMax();
        list.remove(max);
        list.insertAt(max, 1);
    }

    public void reverse(LinkedList<AnyType> list) {

        ListNode<AnyType> current = header.next;
        ListNode<AnyType> prev = null;
        ListNode<AnyType> nxt = null;

        while(current!=null){
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }
        header.next = prev;
    }

    public LinkedList<AnyType> copyList(LinkedList<AnyType> list){//,LinkedList<AnyType> copiedList){
        LinkedList<AnyType> copiedList = new LinkedList<>();
        ListNode<AnyType> itr = header.next;
        while(itr!=null){
            copiedList.insert(itr.element);
            itr = itr.next;
        }
        return copiedList;
    }
    public boolean isPalindrome(LinkedList<AnyType> list){

        LinkedList<AnyType> copy = list.copyList(list);
        list.reverse(list);
        ListNode<AnyType> itr1 = list.header.next;
        ListNode<AnyType> itr2 = copy.header.next;
        while(itr1!=null && itr2!=null){
            if(((itr1.element).equals(itr2.element))){
//                flag = 1;
                itr1 = itr1.next;
                itr2 = itr2.next;
            }
            else return false;
        }
        return true;
    }

    public LinkedList<AnyType> bashkimiListave(LinkedList<AnyType> list2){
        LinkedList<AnyType> listaNew = new LinkedList<>();
        int index = 1;
        ListNode<AnyType> itr1 = this.header.next;
        ListNode<AnyType> itr2 = list2.header.next;

        if(this.isEmpty() && list2.isEmpty()){
            System.out.println("Lista 1 dhe lista 2 jane lista boshe");
            return null;
        }

        while(itr1!=null && itr2!=null){
               listaNew.insert(itr1.element);
               listaNew.insert(itr2.element);
               itr1 = itr1.next;
               itr2 = itr2.next;
        }
        return listaNew;
    }

    public void sortList(){

        ListNode<AnyType> current = header.next;
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
    }
