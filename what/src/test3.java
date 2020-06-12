import java.util.Scanner;

public class test3 extends Base{
    public static void main(String[] args) {
        new test3();
        //调用父类无参的构造方法
        new Base();
    }

}
class Base {
    Base() {
        System.out.print("Base");
    }
}

