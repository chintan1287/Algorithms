package stacks.and.queues;

import java.util.Iterator;
import java.util.function.Consumer;

public class Queue<Item> implements Iterable<Item>{

    class Node {
        Item data;
        Node next;

        public Node(Item data) {
            this.data = data;
        }
    }

    private Node first, last;

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Item data){
        Node oldLast = last;
        last = new Node(data);
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
    }

    public Item dequeue(){
        if(isEmpty()) return null;
        Item data = first.data;
        first = first.next;
        if(isEmpty()) last = null;
        return data;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;
        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {

        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item data = current.data;
            current = current.next;
            return data;
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        System.out.println("Queue is Empty: " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
