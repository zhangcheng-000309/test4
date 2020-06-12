import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class select {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next = scanner.nextInt();
        System.out.println(next);
        List list = new ArrayList();
        for (int i = 1; i <= next; i++) {
            list.add(i);
        }
//        System.out.println(list);

        int s = 0;
        while (true) {
            for (int j = 0; j < list.size(); j++) {
                s = s + 1;
                if (s % 2 == 1) {
                    list.remove(j);
                    j--;
                }
                if (list.size() == 1) {
                    System.out.println("这是幸运鱼：" + list.get(0));
                    return;
                }
            }
            System.out.println("list:" + list);
        }
    }
}
