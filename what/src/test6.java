import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test6{
    public static void main(String[] args){

        Map map=new HashMap();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(1,"ss");
        Set set = map.keySet();
        for (Object o : set) {
            Object o1 = map.get(o);
            System.out.println(o1);
        }
    }
}
