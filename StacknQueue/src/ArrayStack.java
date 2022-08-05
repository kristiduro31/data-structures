import java.lang.reflect.Array;

public class ArrayStack<Anytype extends Comparable<?super Anytype>>{

    private Anytype[] theArray;
    private int topOfStack;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        theArray = (Anytype[]) new Comparable[DEFAULT_CAPACITY];
        topOfStack = -1;
    }
    public boolean isEmpty(){
        return this.topOfStack==-1;
    }
    public void push(Anytype x){
        if (topOfStack+1== theArray.length)
            doubleArray();
        theArray[++topOfStack] = x;
    }
    public Anytype top(){
        if(this.isEmpty())
            System.out.println("Stack eshte bosh !");
        return theArray[topOfStack];
    }
    public void pop(){
        if(this.isEmpty()) {
            System.out.println("Stack eshte bosh !");
            return;
        }
        topOfStack--;
    }
    public Anytype topnPop(){
        if(this.isEmpty()) {
            System.out.println("Stack eshte bosh !");
            return null;
        }
        Anytype top = this.theArray[topOfStack];  //
        topOfStack--;           // keto 3 rreshta jane per te afishuar topofstack dhe me pas
                                // per ti bere pop ketij elementi
        return top;         //
        //return this.theArray[topOfStack--]; per te bere afishimin e elementit te parafundit
        // ne stack dhe berjen pop te elementit te fundit
    }
    private void doubleArray() {
        Anytype[] newArray = (Anytype[]) new Comparable[this.theArray.length*2];
        for(int i=0;i<this.theArray.length;i++) {
            newArray[i]=this.theArray[i];
        }
        this.theArray=newArray;
    }

    //ushtrimi 1.a
    public int size(){
        return topOfStack+1;
    }

    //ushtrimi 1.b
    public void printStack(){
        for(int i = topOfStack;i>=0;i--){
            System.out.print(this.theArray[i]+"  ");
        }
        System.out.println();
    }

    //ushtrimi 1.c
    public void sort(){
        Anytype temp;
        for (int i = 0;i<=topOfStack-1;i++){
            for(int j = 1+i;j<=topOfStack;j++){
                if(this.theArray[i].compareTo(this.theArray[j])>0) {
                    temp = this.theArray[i];
                    this.theArray[i] = this.theArray[j];
                    this.theArray[j]=temp;
                }
            }
        }
    }

    //ushtrimi 1.d
    public void copyAtStack(ArrayStack dest){
        dest.topOfStack = this.topOfStack;
        for(int i = this.topOfStack;i>=0;i--){
            dest.theArray[i] = this.theArray[i];
        }
    }

    //ushtrimi 1.e
//    public void stivaMaxBinary(ArrayStack stack2){
//        int n1=0,n2=0;
//        for(int i = this.topOfStack;i>=0;i--){
//            n1+=((double)(this.theArray[i])*Math.pow(2, i));
//        }
//        for(int i = stack2.topOfStack;i>=0;i--){
//            n1+=((double)stack2.theArray[i])*Math.pow(2, i);
//        }
//        if(n1>n2)
//            System.out.println("Nr i stack 1 eshte me i madh: "+n1);
//        else
//            System.out.println("Nr i stack 2 eshte me i madh: "+n2);
//    }

    //ushtrimi 1.f
    public void neFillim(int k){
        ArrayStack<Anytype> s2 = new ArrayStack<Anytype>();
        Anytype temp;
        int i = 1;
        while(i<k &&!isEmpty()){
            temp = topnPop();
            s2.push(temp);
            i++;
        }
        Anytype v = topnPop();

        while(!s2.isEmpty()){
            temp = s2.topnPop();
            push(temp);
        }
        push(v);
    }
    public ArrayStack<Anytype> reverse(){
        ArrayStack stack2 = new ArrayStack<Anytype>();
        for(int i = topOfStack;i>=0;i--){
            stack2.push(this.theArray[i]);
        }
        stack2.copyAtStack(this);
        return this;
    }
    public Anytype peek(){
        return this.theArray[topOfStack];
    }

//    public void isPalindrome(){
//        ArrayStack<Anytype> copy = new ArrayStack<>();
//        ArrayStack<Anytype> rev = new ArrayStack<>();
//        this.copyAtStack(copy);
//        rev = this.reverse(); // ose pa modifikuar this... pra kopjojme dhe this tek rev pastaj i bejme reverse rev-it
//        for(int i = topOfStack; i>=0;i--){
//            if(copy.theArray[i]!=rev.theArray[i]) {
//                System.out.println("Fjala ne stack NUK eshte palindrome !");
//                return;
//            }
//        }
//        System.out.println("Fjala ne stack eshte palindrome !");
//    }
    //menyra 2 e isPalindrome() duke kopjuar vetem 1 stack rev dhe me pas i bejme reverse ketij te fundit
    public void isPalindrome(){

        ArrayStack<Anytype> rev = new ArrayStack<>();
        this.copyAtStack(rev);
        rev.reverse();
        for(int i = topOfStack; i>=0;i--){
            if(theArray[i]!=rev.theArray[i]) {
                System.out.println("Fjala ne stack NUK eshte palindrome !");
                return;
            }
        }
        System.out.println("Fjala ne stack eshte palindrome !");
    }
    public void removeDuplicates() {
        for(int i = topOfStack; i > 0; i--){
            for(int j = i-1; j >=0 ; j--){
                if(theArray[i]==theArray[j])
                   pop();
            }
        }
    }

    public ArrayStack mergeStacks(ArrayStack<Anytype> a1,ArrayStack<Anytype> a2){
        ArrayStack<Anytype> merge = new ArrayStack<>();
        for(int i = 0; i<= a1.topOfStack; i++) {
            merge.push(a1.theArray[i]);
        }
        for(int i = 0; i<= a2.topOfStack; i++) {
            merge.push(a2.theArray[i]);
        }
        merge.printStack();
        return merge;
    }

}
