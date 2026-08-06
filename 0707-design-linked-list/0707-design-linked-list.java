class MyLinkedList {
    //Declare the data variables for the linked list
    Node head;
    int size;

    //Node class
    static class Node{
        int data;
        Node next;//Just like self referential structure
        //Constructor of Node
        Node(int data){
            this.data = data;
            this.next = null;//By default also after declaration it is null
        }
    }

    //constructor of LinkedList
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public int get(int index) {
        if(head == null || index > size-1)    return -1;
        int i = 0;
        Node temp  = head;
        while(temp.next != null){
            if(i == index){
                return temp.data;
            }
            temp=temp.next;
            i++;
        }
        //You are at the last node now it may be the index
        if(i == index){
            return temp.data;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        //You can only access the inner class variable from outer class by - obj of inner class (if non static) or name of inner class (static inner class)
        //Here it is static inner class => Node head;
        //And newNode is a type of Node so head can hold it
        //head.next is possible, you can directly access the inner class next because the outer class member head is of type Node
        newNode.next=head;
        head=newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head=newNode;
            size++;
            return;
        }
        Node temp = head;
        //The last node is like val,null (data,next)
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next=newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        size++;
        if(index == 0){
            newNode.next=head;
            head=newNode;
            return;
        }
        if(head == null){
            head = newNode;
            return;
        }
        if(index > size){
            return;
        }
        Node temp = head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    
    public void deleteAtIndex(int index) {
        if(head == null || index > size-1)  return;
        size--;
        if(index == 0){
            head = head.next;
            return;
        }
        int i=0;
        Node temp = head;
        while(i < index-1){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;//This also applicabe for last node;
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