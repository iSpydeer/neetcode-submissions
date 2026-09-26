private class Node {
    private int key;
    private int value;
    private Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable {
    private int capacity;
    private int size;
    private Node[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Node[capacity];
    }

    private int hashKey(int key) {
        return key % this.capacity;
    }

    public void insert(int key, int value) {
        int index = hashKey(key);
        Node node = this.table[index];

        if (node == null) {
            this.table[index] = new Node(key, value);
            this.size++;
        } else {
            Node prev = null;
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                prev = node;
                node = prev.next;
            }
            prev.next = new Node(key, value);
            this.size++;
        }

        if ((double) this.size / this.capacity >= 0.5) {
            resize();
        }
    }

    public int get(int key) {
        int index = hashKey(key);
        Node node = this.table[index];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }

        return -1;
    }

    public boolean remove(int key) {
        int index = hashKey(key);
        Node node = this.table[index];
        Node prev = null;
        while (node != null) {
            if (node.key == key) {
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    this.table[index] = node.next;
                }
                this.size--;
                return true;
            }
            prev = node;
            node = prev.next;
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        int newCapacity = 2 * this.capacity;
        Node[] newTable = new Node[newCapacity];
        for (Node node : this.table) {
            while (node != null) {
                int index = hashKey(node.key);
                if (newTable[index] == null) {
                    newTable[index] = new Node(node.key, node.value);
                } else {
                    Node newNode = newTable[index];
                    while (newNode.next != null) {
                        newNode = newNode.next;
                    }
                    newNode.next = new Node(node.key, node.value);
                }
                node = node.next;
            }
        }
        this.capacity = newCapacity;
        this.table = newTable;
    }
}
