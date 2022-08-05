public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello");
        ArrayStack s1 = new ArrayStack();
        ArrayStack s3 = new ArrayStack();
        ArrayStack s4 = new ArrayStack();

        ListQueue s2 = new ListQueue();
        s1.push("r");
        s1.push("a");
        s1.push("d");
        s1.push("a");
        s1.push("r");
        s3.push("1");
        s3.push("2");
        s3.push("3");
        s3.push("4");
        s3.push("5");
        s3.push("6");

//        s2.enqueue("r");
//        s2.enqueue("a");
//        s2.enqueue("d");
//        s2.enqueue("a");
//        s2.enqueue("r");

//        s1.display();
//        s1.pop();
//        s1.display();
////        s1.makeEmpty();
////        s1.display();
//        System.out.println(s1.size());
//        s1.display();
////        s1.copyAtStack(s2);
////        s1.display();
////        s2.display();
//        s1.reverse();
//        s1.display();
        s1.printStack();
        s4.mergeStacks(s1,s3);
//        s1.isPalindrome();
//        s1.removeDuplicates();
//        s1.printStack();
////        s1.sort();
////        s1.printStack();
////        ArrayStack s2 = new ArrayStack<>();
////        s1.copy(s2);
////        s2.printStack();
//        s1.reverse();
        ListQueue q1 = new ListQueue();
        ListQueue q2 = new ListQueue<>();
        ListQueue q3 = new ListQueue<>();
        for(int i=0;i<7;i++)
        {
            q1.enqueue(i);
        }
        for(int i=10;i<15;i++)
        {
            q2.enqueue(i);
        }

//        q1.copyAtList(q2);
        q1.printQueue();
        q2.printQueue();
        q3.mergeQueue(q1,q2);
        q1.printQueue();
        q2.printQueue();
//        q1.reverse();
//        s2.printQueue();
//        s2.removeDuplicates();
//        s2.printQueue();
//        q1.sortList();
//        q1.printQueue();
    }
}
