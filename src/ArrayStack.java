/**
 * @Author: wugege
 * @Date: 2019/11/3 15:09
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peak() {
        return array.getLast();
    }

    /**
     * 查看容积
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("stack:");
        str.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            str.append(array.get(i));
            if (i!=array.getSize()-1){
                str.append(",");
            }
        }
        str.append("]TOP");

        return str.toString();
    }
}
