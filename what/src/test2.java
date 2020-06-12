public class test2 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public void reOrderArray(int[] array) {
        int[] array2 = new int[array.length];
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                array2[s1] = array[i];
                s1++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array2[s1 + s2] = array[i];
                s2++;
            }
        }
        array = array2;
    }

    public static void main(String[] args) {
        int[] arrs = {0, 2, 1, 4, 5, 7};

    }
}
