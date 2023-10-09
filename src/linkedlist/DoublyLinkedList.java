package linkedlist;


public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public void add(int position, T value) {
        if (position <= size) {
            Node<T> node = new Node<>(value);
            if (position == 0) {
                if (head == null) {
                    tail = node;
                } else {
                    head.setPrev(node);
                }
                node.setNext(head);
                head = node;
            } else {
                Node<T> temp = head;
                for (int i = 1; i < position; i++) {
                    temp = temp.getNext();
                }
                if (position != size) {
                    temp.getNext().setPrev(node);
                    node.setNext(temp.getNext());
                } else {
                    tail = node;
                }
                node.setPrev(temp);
                temp.setNext(node);
            }
            size++;
        }
    }

    public void remove(int position) {
        if (position < size) {
            if (position == 0) {
                if (size == 1) {
                    tail = null;
                } else {
                    head.getNext().setPrev(null);
                }
                head = head.getNext();
            } else {
                Node<T> temp = head;
                for (int i = 1; i < position; i++) {
                    temp = temp.getNext();
                }
                if (position == size - 1) {
                    tail = temp;
                } else {
                    temp.getNext().getNext().setPrev(temp);
                }
                temp.setNext(temp.getNext().getNext());
            }
            size--;
        }
    }

    public String reverseTraversal() {
        Node<T> temp = tail;
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            string.append(temp.getValue());
            temp = temp.getPrev();
            if (i != size - 1) {
                string.append("<=>");
            }
        }
        return string.toString();
    }

    public int search(T value) {
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (value.equals(temp.getValue())) {
                return i;
            }
            temp = temp.getNext();
        }
        return -1;
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            string.append(temp.getValue());
            temp = temp.getNext();
            if (i != size - 1) {
                string.append("<=>");
            }
        }
        return string.toString();
    }

    public static void main(String[] arg) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(0, 1);
        doublyLinkedList.add(1, 2);
        doublyLinkedList.add(2, 3);
        doublyLinkedList.add(0, 4);
        doublyLinkedList.add(3, 5);
        System.out.println(doublyLinkedList.search(9));
        System.out.println(doublyLinkedList);
        System.out.println(doublyLinkedList.reverseTraversal());
        doublyLinkedList.remove(3);
        doublyLinkedList.remove(2);
        System.out.println(doublyLinkedList);
        System.out.println(doublyLinkedList.reverseTraversal());
    }

}
