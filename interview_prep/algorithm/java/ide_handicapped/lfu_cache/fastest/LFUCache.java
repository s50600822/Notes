class LFUCache {
    class Node {
        int key;
        int val;
        int cnt = 1;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node[] keys = new Node[100001];
    Node[] cnts = new Node[200001];
    Node tail;
    int size = 0;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev != null)
            prev.next = next;

        if (next != null)
            next.prev = prev;

        keys[node.key] = null;
        if (cnts[node.cnt] == node) {
            if (next != null && next.cnt == node.cnt)
                cnts[node.cnt] = next;
            else
                cnts[node.cnt] = null;
        }

        if (tail == node)
            tail = prev;

        node.prev = null;
        node.next = null;
    }

    void insert(Node node, Node next) {
        cnts[node.cnt] = node;
        keys[node.key] = node;
        if (next == null) {
            if (tail != null)
                tail.next = node;
            node.prev = tail;
            tail = node;
        }
        else {
            if (next.prev != null)
                next.prev.next = node;
            node.prev = next.prev;
            node.next = next;
            next.prev = node;
        }
    }

    void moveUp(Node node) {
        Node next = cnts[node.cnt + 1] != null ? cnts[node.cnt + 1] : cnts[node.cnt];
        if (next == node)
            next = node.next;

        remove(node);
        node.cnt++;
        insert(node, next);
    }

    public int get(int key) {
        Node node = keys[key];

        if (node == null)
            return -1;

        moveUp(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node node = keys[key];
        if (node == null) {
            node = new Node(key, value);
            if (size >= capacity)
                remove(tail);
            else
                size++;

            insert(node, cnts[1]);
        }
        else {
            moveUp(node);
            node.val = value;
        }
    }
}