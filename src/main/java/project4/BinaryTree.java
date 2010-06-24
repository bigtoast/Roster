/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project4;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import project3.SimpleLinkedList;

/**
 *
 * @author andy
 */
public class BinaryTree<T> implements Iterable<T> {

    private Node<T> root;
    private int size;
    private Comparator<? super T> comparator;

    public static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(){};
        public Node(T value){ this.value = value; }
        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }


        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }


    }
    
    public BinaryTree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public int size() { return size; }
    
    public Iterator iterator() {
        return values().iterator();
    }

    public Collection<T> values(){
        SimpleLinkedList list = new SimpleLinkedList<T>();
        addToCollection(root, list);
        return list;
    }

    private void addToCollection(Node<T> current, Collection<T> c){
        if(current == null)
            return;

        addToCollection(current.getLeft(), c);
        c.add(current.getValue());
        addToCollection(current.getRight(), c);
    }


    public boolean add(T item){
        if (contains(item))
            return false;

        if (root == null){
            root = new Node(item);
            size = 1;
        } else {
            addNode(root, new Node(item));
            size++;
        }
        return true;
    }

    private void addNode(Node<T> current, Node<T> node){
        int res = comparator.compare(node.getValue(), current.getValue());
        if (res < 0 && current.getLeft() == null)
            current.setLeft(node);
        else if(res < 0)
            addNode(current.getLeft(), node);
        else if(res >= 0 && current.getRight() == null)
            current.setRight(node);
        else if(res >= 0)
            addNode(current.getRight(), node);
    }
    
    public boolean remove(T item){
        if(!contains(item))
            return false;

        remove(null, root, item);
        size--;
        return true;
    }

    private void remove(Node<T> parent, Node<T> current, T item){
        int res = comparator.compare(item, current.getValue());
        if (res < 0 )
            remove(current, current.getLeft(), item);
        else if (res > 0)
            remove(current, current.getRight(), item);
        else if (res == 0) {
            if(current.equals(parent.getRight())){
                parent.setRight(null);
            } else if (current.equals(parent.getLeft())){
                parent.setLeft(null);
            } else {
                throw new IllegalStateException("Should never happen");
            }

            if(current.getLeft() != null)
                addNode(parent,current.getLeft());

            if(current.getRight() != null)
                addNode(parent,current.getRight());
        }
    }

    public boolean contains(T item){
        if (root == null)
            return false;

        return contains(root, item);
    }

    public boolean contains(Node<T> current, T item) {
        int res = comparator.compare(item, current.getValue());

        if(res == 0)
            return true;
        else if (res < 0 && current.getLeft() != null)
            return contains(current.getLeft(), item);
        else if (res > 0 && current.getRight() != null)
            return contains(current.getRight(), item);
        else
            return false;
    }


}
