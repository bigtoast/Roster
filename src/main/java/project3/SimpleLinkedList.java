
package project3;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author andy
 */
public class SimpleLinkedList<T> implements Collection<T> {

    private Node<T> start;
    private Node<T> end;
    private int size = 0;
    
    public static class Node<T> {
        private Node next;
        private T value;

        public Node(){}
        public Node(T value){ this.value = value; }

        public boolean hasNext() {
            if(next == null)
                return false;

            return true;
        }

        public void setNext(Node<T> next){ this.next = next; }
        public Node<T> getNext(){ return this.next; }
        public void setValue(T value){ this.value = value; }
        public T getValue() { return this.value; }

        private boolean isSet() {
            if(value == null)
                return false;

            return true;
        }
    }

    public static class SLLIterator<T> implements Iterator<T> {
        private SimpleLinkedList<T> list;
        private Node<T> node;
        private int index = 0;
        
        public SLLIterator(SimpleLinkedList<T> list){ 
            this.list = list;
        }
        
        public boolean hasNext() { 
            if(node != null)
                return node.hasNext();

            if(list.size > 0)
                return true;

            return false;
        }

        public T next() {
            if(node == null){
                node = list.start;
            } else {
                node = node.getNext();
                index++;
            }
            return node.value;
        }

        public void remove() {
           list.remove(index);
           Node<T> n = node;
           node = list.nodeAt(index);
           n = null;
        }
    }

    public Iterator<T> iterator() {
        return new SLLIterator<T>(this);
    }

    public int size(){
        int i = size;
        return i;
    }
    
    public boolean add(T item) {
        Node n = new Node(item);
        if ( start == null ) {
          this.start = n;
          this.end = n;
          size++;
          return true;
        }
        this.end.setNext(n);
        this.end = n;
        size++;
        return true;
    }

    private Node<T> nodeAt(int index){
        if ( index >= size )
            throw new IndexOutOfBoundsException();

        Node n = start;
        for(int i=0; i==index; i++) {
            n = n.getNext();
        }
        return n;
    }

    public boolean contains(Object item){
        Node<T> n = start;
        for(int i=0; i<size; i++){
            if(item.equals(n.value))
                return true;
        }
        return false;

    }

    public T get(int index){
        return nodeAt(index).getValue();
    }

    public boolean remove(int index){
       if ( index >= size )
           return false;

       if(index == 0){
           if( start.hasNext()){
               start = start.getNext();
           } else {
             start = null;
           }
           size--;
           return true;
       }

       Node<T> prev = nodeAt(index - 1);
       Node<T> node = nodeAt(index);
       if(node.hasNext()){
           prev.setNext(node.getNext());
       } else {
           prev.setNext(null);
       }
       node = null;
       size--;
       return true;

    }

    public boolean remove(){
        if(size == 0)
            return false;

        Node<T> n = start;
        start = start.getNext();
        n = null;
        size--;
        return true;
    }

    public boolean removeLast(){
        if(size == 0)
            return false;

        Node<T> last = end;
        if(size > 1){
            Node<T> prev = nodeAt(size - 2);
            prev.setNext(null);
            end = prev;
        }else {
            start = null;
            end = null;

        }
        last = null;
        size--;
        return true;

    }

    public boolean remove(Object item) {
        if(size == 0)
            return false;

        Node prev = null;
        Node n = start;
        for(int i=0; i<size; i++){
            if(item.equals(n.value)){
                if(prev == null){
                    return remove();
                } else {
                    if(!n.hasNext())
                       return removeLast();

                    prev.setNext(n.getNext());
                    n = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public T[] toArray() {
        T[] ary = (T[]) new Object[size];
        int i=0;
        for(T item : this){
            ary[i++] = item;
        }

        return ary;
    }

    public boolean addAll(Collection<? extends T> clctn) {
        boolean chg = false;
        for(T item : clctn){
            if(add(item))
                chg = true;
        }
        return chg;
    }

    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public <E> E[] toArray(E[] ts) {
        if(ts.length < size){
           return (E[]) toArray();
        }

        for(int i=0; i<ts.length; i++){
            if(i>= size-1)
                ts[i] = null;
            else
                ts[i] = (E) get(i);
        }

        return ts;
    }

    


}
