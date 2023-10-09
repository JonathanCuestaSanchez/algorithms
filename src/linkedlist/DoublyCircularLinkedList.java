package linkedlist;

public class DoublyCircularLinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    public void add(int position,T value){
        if(position <= size){
            Node<T> node = new Node<>(value);
            if(position == 0){
                if(head == null){
                    tail = node;
                    node.setNext(node);
                    node.setPrev(node);
                }else{
                    tail.setNext(node);
                    head.setPrev(node);
                    node.setNext(head);
                    node.setPrev(tail);
                }
                head = node;
            }else{
                Node<T> temp = head;
                for(int i = 1 ; i < position; i++){
                    temp= temp.getNext();
                }
                if(position == size){
                    node.setNext(head);
                    head.setPrev(node);
                    tail = node;
                }else {
                    temp.getNext().setPrev(node);
                    node.setNext(temp.getNext());
                }
                node.setPrev(temp);
                temp.setNext(node);
            }

            size ++;
            System.out.println(this);
        }
    }

    public void remove(int position){
        if(position < size){
            if(position == 0){
                if(size == 1){
                    head = null;
                    tail = null;
                }else{
                    head = head.getNext();
                    tail.setPrev(head);
                }
            }else{
                Node<T> temp = head;
                for(int i = 1 ; i< position ; i++){
                    temp = temp. getNext();
                }
                if(position == size-1){
                    temp.setNext(head);
                    head.setPrev(temp);
                    tail = temp;
                }else {
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().getNext().setPrev(temp);
                }
            }
            size--;
            System.out.println(this);
        }
    }

    @Override
    public String toString(){
        Node<T> node = head;
        StringBuilder string = new StringBuilder();
        for(int i = 0 ; i < size; i++){
            string.append(node.getValue());
            node = node.getNext();
            if(i != size -1){
                string.append("<=>");
            }
        }
        return string.toString();
    }

    public static void main(String[] arg){
        DoublyCircularLinkedList<Integer> list = new DoublyCircularLinkedList<>();
        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        list.add(2,4);
        list.add(3,5);
        list.add(1,6);
        list.add(2,7);
        list.add(list.size,8);
        list.remove( list.size/2);
        list.remove( 0);
        list.remove(list.size-1);
    }
}
