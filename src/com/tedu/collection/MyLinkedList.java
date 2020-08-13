package com.tedu.collection;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public boolean add(Object o) {
        Node node = new Node();
        node.setValue(o);
        if (head == null && tail == null) {
            head = node;
            tail = node;
            size++;
            return true;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            size++;
            return true;
        }
    }

    public Object get(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("" + i);
        Node n = getNode(i);

        return n.getValue();//返回节点实例中封装的数据
    }

    private Node getNode(int i) {
        if (i == 0) return head;
        if (i == size - 1) return tail;
        Node n;//用来保存最终找到的节点
        if (i <= size / 2) {
            //前边一半
            n = head; //头部是下标0
            //下标1到下标i
            for (int j = 1; j <= i; j++) {
                n = n.getNext();//把n节点的下一个节点存到n
            }
        } else {
            //后边一半
            n = tail;//尾部下标是size-1

            //下标从size-2到下标i
            for (int j = size - 2; j >= i; j--) {
                n = n.getPrev();//把n节点的上一个节点存到n
            }

        }
        return n;
    }
    public int size() {
        return size;
    }
    @org.junit.Test
    public  void test(){
        MyLinkedList l = new MyLinkedList();
        boolean add = l.add(0);
        l.add("zhangsan");
        System.out.println(l.get(0));
    }

}

class Node {
    private Node prev;
    private Object value;
    private Node next;

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

