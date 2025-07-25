import java.util.LinkedList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    private static class Node<T>{
        T item;
        Node<T> prev;
        Node<T> next;
        
        Node(T i, Node<T> p, Node<T> n){
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node<T> sentinel;
    private int size;


    public LinkedListDeque61B(){
        sentinel = new Node(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }


    @Override
    public void addFirst(T x) {
        Node<T> newNode =new Node<T>(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node<T> newNode = new Node<T>(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<T>();
        Node<T> current = sentinel.next;
        while (current != sentinel){
            list.add(current.item);
            current = current.next;
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()){
            return null;
        }

        Node<T> firstNode = sentinel.next;
        T itemToRemove = firstNode.item;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        size--;
        return itemToRemove;

    }

    @Override
    public T removeLast() {
        if (isEmpty()){
            return null;
        }

        Node<T> lastNode = sentinel.prev;
        T itemToRemove = lastNode.item;
        sentinel.prev = lastNode.prev;
        lastNode.prev.next = sentinel;
        size--;
        return itemToRemove;
    }

    @Override
    public T get(int index) {
        if (index<0 || index >= size){
            return null;
        }
        Node<T> current = sentinel.next;
        for (int i=0;i<index;i++){
            current = current.next;
        }
        return current.item;
    }

    @Override
    public T getRecursive(int index) {
        
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }
    
    private T getRecursiveHelper(Node<T> node, int index){
        if (index == 0){
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
    
}