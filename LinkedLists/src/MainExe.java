public class MainExe {
    public static void main(String[] args){
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);
        list1.insert(7);
        list1.insert(13);
        System.out.println("Lista e pare : ");
        list1.printList(list1);
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);
        list2.insert(8);
        list2.insert(10);
        System.out.println("\n\nLista e dyte : ");
        list2.printList(list2);
        LinkedList<Integer> listaNew = list1.bashkimiListave(list2);
        listaNew.sortList();
        System.out.println("\n\n\nLista e re : ");
        listaNew.printList(listaNew);
    }
}
