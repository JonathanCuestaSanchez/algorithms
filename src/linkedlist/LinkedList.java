package linkedlist;

public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int  size = 0;

    public void addPosition(int position, T value){
        Node<T> node = new Node(value);
        if(position <= size){
            if(position == 0) {
                if (head == null) {
                    tail = node;
                } else {
                    node.setNext(head);
                }
                head = node;
            }else if (position == size){
                tail.setNext(node);
                tail = node;
            }else {
                Node<T> temp = head;
                for(int i = 1 ; i < position; i++){
                    temp = temp.getNext();
                }
                node.setNext(temp.getNext());
                temp.setNext(node);
            }
            size++;
        }
    }

    public int search(T value){
        if(size > 0){
            Node<T> node = head;
            for(int i = 0 ; i < size; i++){
                if(node.getValue().equals(value)){
                    return i;
                }
                node = node.getNext();
            }
        }
        return -1;
    }

    public void remove(int position){
        if(position< size){
            if(position == 0){
                if(head.getNext() == null){
                    tail = null;
                }
                head = head.getNext();
            }else{
                Node<T> temp = head;
                for(int i =1; i < position; i++){
                    temp = temp.getNext();
                }
                temp.setNext(temp.getNext().getNext());
                if(position == size -1){
                    tail = temp;
                }
            }
            size --;
        }
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        Node<T> node = head;
        for(int i = 0 ;i < size ; i++){
            string.append(node.getValue());
            node = node.getNext();
            if(i < size -1){
                string.append("->");
            }
        }
        return string.toString();

    }

    public static void main(String[] arc){
        LinkedList<Integer> list = new LinkedList<>();
        list.addPosition(0,1);
        list.addPosition(0,2);
        list.addPosition(0,3);
        list.addPosition(list.size-1,4);
        list.addPosition(list.size-1,5);
        list.addPosition(list.size,6);
        list.addPosition(list.size,7);
        System.out.println(list);
        System.out.println(list.size);
        System.out.println(list.search(1));
        list.remove(0);
        list.remove(list.size-1);
        list.remove(2);
        System.out.println(list);
   }
}

