import java.util.HashMap;
public class MainExe {
    public static <K,V> HashMap<K,V> copyHashMap(HashMap<K,V> map1){
        HashMap<K,V> map2 = new HashMap<>();
        for (HashMap.Entry<K, V> entry : map1.entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
        }
        return map2;
    }
    public static void main(String[] args){
        HashMap<Integer,String> m1 = new HashMap<>();
        m1.put(33,"Kristi");
        m1.put(8,"Johan");
        m1.put(10,"Gjergji");
        m1.put(31,"Helena");
        System.out.println(m1);
        HashMap<Integer,String> m2 = copyHashMap(m1);
        System.out.println(m2);
    }
}
