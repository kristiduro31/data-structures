public class ListStack <AnyType extends Comparable>{

    private ListNode<AnyType> topOfStack;

    public ListStack() {
        topOfStack = null;
    }

    public void push(AnyType x){
        ListNode<AnyType> temp = new ListNode<AnyType>();
        temp.element = x;
        temp.next = topOfStack;
        topOfStack = temp; //pra elementi i fundit qe shtohet ne stack do te kete .next elementin paraardhes qe ka qene ne stack
    }
    public void pop(){
        if(isEmpty())
            System.out.println("Stack eshte bosh !");
        else
            topOfStack = topOfStack.next;
    }
    public boolean isEmpty(){
        return topOfStack==null;
    }
    public AnyType peek(){
        if(!isEmpty())
            return topOfStack.element;
        else return null;
    }
    public void display(){
        if (isEmpty())
            System.out.println("Stack eshte bosh !");
        else{
            ListNode<AnyType> temp = topOfStack;
            while(temp!=null){
                System.out.print(temp.element+"  ");
                temp = temp.next;
            }
        }
        System.out.println();
    }
    public void makeEmpty(){
        topOfStack = null;
    }
    public int size(){
        int size = 0;
        ListStack<AnyType> temp = new ListStack<>();
        while(!this.isEmpty()){
            temp.push(topOfStack.element);
            this.pop();
            size++;
        }
        while(!temp.isEmpty()) {
            this.push(temp.topOfStack.element);
            temp.pop();
        }
        return size;
    }
    public void copyAtStack(ListStack<AnyType> dest){
        ListStack<AnyType> temp = new ListStack<>();
        while(!this.isEmpty()){
            temp.push(topOfStack.element);
            this.pop();
        }
        while(!temp.isEmpty()) {
            this.push(temp.topOfStack.element);
            dest.push(temp.topOfStack.element);
            temp.pop();
        }
    }
    public void reverse(){
        ListStack<AnyType> temp = new ListStack<>();
        while(!this.isEmpty()){
            temp.push(topOfStack.element);
            this.pop();
        }
        temp.copyAtStack(this);
    }
}
