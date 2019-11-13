/**
 * @Author: wugege
 * @Date: 2019/11/6 18:57
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class LinkedListStack<E> implements Stack<E> {
    LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public int getSize() {
        return linkedList.gitSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peak() {
        return linkedList.get(linkedList.gitSize()-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack:top");
        sb.append(linkedList);
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
