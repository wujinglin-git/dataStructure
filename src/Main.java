/**
 * @Author: wugege
 * @Date: 2019/11/1 10:54
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

    }
}
