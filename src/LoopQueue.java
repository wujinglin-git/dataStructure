/**
 * @Author: wugege
 * @Date: 2019/11/4 9:33
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }


    @Override
    public int getSize() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return front ==tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length == front){
            resize(2*getCapacity());
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    private void resize(int capacity){
        E[] newData = (E[])new Object[capacity+1];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("cannot dequeue from on empty queue");
        }
        E de = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size --;
        if (size ==getCapacity()/4&&getCapacity() / 2!=0){
            resize(getCapacity()/2);
        }
        return de;
    }

    @Override
    public E getFront() {

        return data[front];
    }

    public E get(int index){
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("LoopQueue:");
        str.append("front[");
        for (int i = front; i != tail; i = (i+1)%data.length) {
            str.append(get(i));
            if ((i+1)%data.length != tail) {
                str.append(",");
            }
        }
        str.append("]tail");

        return str.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }

        loopQueue.dequeue();
        loopQueue.dequeue();
        System.out.println(loopQueue);

        for (int i = 0; i < 8; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            System.out.println(loopQueue.getCapacity());
        }
    }

}
