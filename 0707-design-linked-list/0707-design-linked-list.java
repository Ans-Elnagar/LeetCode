class MyLinkedList {
    private static class Node{
        int val;
        Node next;
        Node(int val){this.val = val;}
    }
    int size;
    Node head;
    Node tail;
    public MyLinkedList() {
        this.size = 0;
    }
    
    public int get(int index) {
        if(index >= this.size || index < 0 )
            return -1;
        Node iterator = head;
        while(index-->0)
            iterator = iterator.next;
        return iterator.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null)
            tail = node;
        this.size++;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > this.size || index < 0 )
            return ;
        if(index == 0)
            addAtHead(val);
        else if(index == this.size)
            addAtTail(val);
        else{
            Node prev = head;
            Node iterator = head.next;
            index--;
            while(index-->0){
                prev = prev.next;
                iterator = iterator.next;
            }
            Node node = new Node(val);
            prev.next = node;
            node.next = iterator;
            this.size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >= this.size || index < 0 )
            return ;
        if(index == 0){
            head = head.next;
            if(this.size == 1)
                tail = null;
        }else{
            Node prev = head;
            Node iterator = head.next;
            int temp = index;
            temp--;
            while(temp-->0){
                prev = iterator;
                iterator = iterator.next;
            }
            prev.next = iterator.next;
            if(index == this.size-1)
                tail = prev;
        }
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */