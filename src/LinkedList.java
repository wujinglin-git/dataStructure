/**
 * @Author: wugege
 * @Date: 2019/11/5 14:47
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class LinkedList<E> {
    /**
     * 私有内部类，只有奔雷可以访问
     *
     * 节点
     */
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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }
    public int gitSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
       add(0,e);
    }

    /**
     * 在index的位置加入新元素e
     */
    public void add(int index,E e){
        if(index<0 || index >size){
            throw new IllegalArgumentException("add failed.Illegal index");
        }
            Node prev = dummyHead ;
            for (int i = 0; i < index ; i++) {
                prev  = prev.next;
            }

           /* Node newNode = new Node(e);
            newNode.next = prev.next;
            prev.next = newNode;*/

            prev.next = new Node(e,prev.next);
            size++;
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index<0 || index >size){
            throw new IllegalArgumentException("add failed.Illegal index");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }
    /**
     * 修改第index的元素
     */
    public void set(int index,E e){
        if(index<0 || index >size){
            throw new IllegalArgumentException("add failed.Illegal index");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    /**
     * 查询是否存在e
     */
    public boolean contains(E e){
      /*  Node current = dummyHead.next;
        for (int i = 0; i < size-1; i++) {
            if (current.e == e){
                return true;
            }
            current = current.next;
        }
        return false;*/

      Node cur = dummyHead.next;
      while (cur!=null){
          if (cur.e.equals(e)){
              return true;
          }
          cur = cur.next;
      }

      return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur!=null){
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("NULL");

        return sb.toString();
    }

    /**
     * 删除索引为index的元素
     */
    public E remove(int index){
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //  prev.next.e  = null;
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);System.out.println(linkedList);
        linkedList.addFirst(2);System.out.println(linkedList);
        linkedList.addFirst(3);
        System.out.println(linkedList);

        linkedList.add(0,666);
        System.out.println(linkedList);
    }
}
