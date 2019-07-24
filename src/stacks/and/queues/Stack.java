package stacks.and.queues;

import java.util.Iterator;
import java.util.function.Consumer;

public class Stack<Item> implements Iterable<Item>{

    class Node {
        Item data;
        Node next;

        public Node(Item data) {
            this.data = data;
        }
    }

    private Node first;

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item data){
        Node oldFirst = first;
        first = new Node(data);
        first.next = oldFirst;
    }

    public Item pop(){
        if(isEmpty()) return null;
        Item data = first.data;
        first = first.next;
        return data;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

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
            Item item = current.data;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Stack is Empty: "+stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
