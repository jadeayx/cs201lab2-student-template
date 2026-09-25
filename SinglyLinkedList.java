import java.util.*;

public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;
    
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
    
        public E getElement(){
            return element;
        }
    
        public Node<E> getNext(){
            return next;
        }
    
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    // write your codes here
    public void swap(){
        int n = this.size();
        ArrayList<E> arr = new ArrayList<>();
        Node<E> curr = head;
        while (curr != null) {
            arr.add(curr.getElement());
            curr = curr.getNext();
        }
        arr.sort(null);

        for (int i = 0; i < n / 2; i++) {
        E smallest = arr.remove(0);
        E largest = arr.remove(arr.size() - 1);

        Node<E> big = head;
        Node<E> prevB = null;
        while (!big.getElement().equals(largest)) {
            prevB = big;
            big = big.getNext();
        }

        Node<E> small = head;
        Node<E> prevS = null;
        while (!small.getElement().equals(smallest)) {
            prevS = small;
            small = small.getNext();
        }

            if(big == small){
                continue;
            }

            if(big.getNext() == small){
                if(prevB == null) head = small; else prevB.setNext(small); 
                big.setNext(small.getNext());
                small.setNext(big);
                if(big.getNext() == null) tail = big;
            } else if(small.getNext() == big){
                if(prevS == null) head = big; else prevS.setNext(big); 
                small.setNext(big.getNext());
                big.setNext(small);
                if(small.getNext() == null) tail = small;
            } else {
                if(prevB == null) head = small; else prevB.setNext(small);
                if(prevS == null) head = big; else prevS.setNext(big); 

                Node<E> tempB = big.getNext();
                Node<E> tempS = small.getNext();

                big.setNext(tempS);
                small.setNext(tempB);

                if(big.getNext() == null) tail = big;
                if(small.getNext() == null) tail = small;

            }

            }

    }
   
}

