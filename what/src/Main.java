import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *  随机生成1000内的随机整数，按照输入的随机整数的数值，随机赋予1000以内的随机数，然后去重+排序
 */
public class Main{
    public static void main(String[] args){
        Random r=new Random();
        List<Integer> list=new ArrayList();
        int n = r.nextInt(100)+1;
        for (int i = 0; i <n ; i++) {
            int t = r.nextInt(100)+1;

            for (int i1 = 0; i1 < list.size(); i1++) {//去重
                if(list.get(i)==t){
                    break;
                }
                if(i1==list.size()-1){
                    list.add(t);
                }
            }

        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}