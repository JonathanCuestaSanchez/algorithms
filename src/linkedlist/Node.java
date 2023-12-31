package linkedlist;

public class Node<T>{

    private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node (T value){
        this.value = value;
    }

    public void setNext(Node<T> next){
        this.next= next;
    }

    public void setPrev (Node<T> prev){this.prev = prev; }

    public Node<T> getNext(){
        return next;
    }

    public Node<T> getPrev() {return prev;}

    public T getValue() {
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}
