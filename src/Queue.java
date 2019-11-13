/**
 * @Author: wugege
 * @Date: 2019/11/3 20:53
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();


}
