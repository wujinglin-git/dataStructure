/**
 * @Author: wugege
 * @Date: 2019/11/1 10:54
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * @size 指向数组的索引
     *
     * @param capacity
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    //获取容积
    public int getCapacity(){
        return data.length;
    }

    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 在index位置插入一个新元素e
     * @param index
     * @param e
     *
     *
     * 在java的arraylist中 resize扩容的值是1.5
     */
    public void add(int index,E e ){
        //判断是否已满
        if(size==data.length){
            resize(2*data.length);
        }
        //index是负数为非法，或者索引之中有空值即index超出
        if(index < 0 || index > size){
            throw new IllegalArgumentException("addLast faild.array is full");
        }

        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void addFirst(E e){
            add(0,e);
        }

        /**
         * 在所有元素后添加一个新元素
         */
        public void addLast(E e){
            add(size,e);
        }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1){
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }

    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("get faild.Index is Illegal");
        }
            return data[index];
    }
    public void set(int index , E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("get faild.Index is Illegal");
        }
        data[index] = e;
    }

    public E getFirst(){
           return get(0);
    }

    public E getLast(){
            return get(size-1);
    }

    /**
     * 是否存在
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找e的索引
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除索引为index的元素
     *
     * 返回被删除的元素
     *
     * 内存泄漏：是指程序中己动态分配的堆内存由于某种原因程序未释放或无法释放，
     * 造成系统内存的浪费，导致程序运行速度减慢甚至系统崩溃等严重后果。
     *
     * (size == data.length/2)  为了防止复杂度震荡，此处的resize过于着急了，应该采用更加消极的方法用以提高整体性能
     *
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("remove faild.Index is Illegal");
        }
        E ret= data[index];
        for (int i = index+1; i < size ; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; //游离的元素 loitering objects ！= memory leak（内存泄漏）
        if (size == data.length&&data.length/2!=0)
        {
            resize(data.length/4);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0 );
    }

    public E removeLast(){
        return remove(size-1 );
    }
    /**cc
     * 如果有就删除
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }
}