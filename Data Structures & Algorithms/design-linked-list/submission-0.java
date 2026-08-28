class MyLinkedList {

    private Node head;
    private Node tail;
    int length;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    
    public int get(int index) {
        if (index > length -1) {
            return -1;
        } else {
            int i = 0;
            Node currNode = head;
            while (i < index) {
                currNode = currNode.next;
                i++;
            }
            return currNode.val;
        }
    }
    
    public void addAtHead(int val) {
        if (head == null && tail == null) { 
            head = new Node(val);
            tail = head;
        } else {
            head.prev = new Node(val, head, null);
            head = head.prev;
        }
        length++;
    }
    
    public void addAtTail(int val) {
        if (head == null && tail == null) {
            tail = new Node(val);
            head = tail;
        } else {
            tail.next = new Node(val, null, tail);
            tail = tail.next;
        }
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        } else if (index == length) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            int i = 0;
            Node currNode = head;
            while (i < index) {
                currNode = currNode.next;
                i++;
            }
            
            Node tempNode = new Node(val, currNode, currNode.prev);
            currNode.prev.next = tempNode;
            currNode.prev = tempNode;
            length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index >= length || index < 0) {
            return;
        } else if (length == 1) {
            head = null;
            tail = null;
            length--;
        } else if (index == length - 1) {
            tail.prev.next = null;
            tail = tail.prev;
            length--;
        } else if (index == 0){
            head.next.prev = null;
            head = head.next;
            length--;
        } else {
            int i = 0;
            Node currNode = head;
            while (i < index) {
                currNode = currNode.next;
                i++;
            }
            currNode.next.prev = currNode.prev;
            currNode.prev.next = currNode.next;
            length--;
        }


    }

    private class Node {
        int val;
        Node next;
        Node prev;
        
        Node(final int val) {
            this(val, null, null);
        }
        
        Node(final int val, final Node next, final Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
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