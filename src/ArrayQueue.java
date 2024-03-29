/**
 * @Author: wugege
 * @Date: 2019/11/3 20:55
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
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
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Queue:");
        str.append("front[");
        for (int i = 0; i < array.getSize(); i++) {
            str.append(array.get(i));
            if (i != array.getSize() - 1) {
                str.append(",");
            }
        }
        str.append("]tail");

        return str.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue  = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }


    }
}


