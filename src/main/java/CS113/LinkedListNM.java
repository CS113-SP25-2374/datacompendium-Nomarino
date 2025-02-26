package CS113;

public class LinkedListNM<E> implements ListInterface<E>  {
    private class Node<E>{
        E element;
        Node<E> next;
        Node<E> prev;
        private Node(E element){
            this.element = element;
        }
    }

    Node<E> head;
    Node<E> tail;
    int size;

    private Node<E> getIndex(int index){
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        Node<E> curr = head;
        for (int i = 0; i < size; i++){
            curr = curr.next;
        }
        return curr;
    }


    @Override
    public boolean add(E element) {
        size++;
        Node<E> node = new Node<>(element);
        if(head == null){
            head = tail = node;
            return true;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        return true;
    }




    @Override
    public void add(int index, E element) {
    Node<E> node = new Node<>(element);
    Node<E> curr = getIndex(index);
    size++;

    node.next = curr.next;
    curr.next = node;
    node.prev = curr;
    if (node.next != null){
        node.next.prev = node;
    }

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void set(int index, E element) {

    }
}

