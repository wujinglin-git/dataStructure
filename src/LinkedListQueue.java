/**
 * @Author: wugege
 * @Date: 2019/11/7 9:45
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e ,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }
        public Node(){
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail=null;
        size=0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public void enqueue(E e) {
        if(tail ==null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty Queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if(head ==null){
            tail =null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("empty Queue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("queue:front");
        Node cur = head;
        for (int i = 0; i < size; i++) {
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue();

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        queue.dequeue();
        System.out.println(queue);
    }
}
