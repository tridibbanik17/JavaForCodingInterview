// // This is an implementation of a HashMap without using any built-in hash table libraries.
class MyHashMap {
    // Represents a single key-value pair in the hash map
    private static class Node {
        int key; // The key associated with this node
        int value; // The value associated with the key
        Node next; // Pointer to the next node in the chain

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 1000; // Fixed size of the primary array (number of buckets)
    private Node[] map; // Array to store linked lists (buckets)

    // Initializes the hash map with empty buckets
    public MyHashMap() {
        map = new Node[SIZE];
    }

    // Hash function
    // input = key, output = value
    private int hash(int key) {
        return key % SIZE; // value = key % SIZE
    }

    // Inserts or updates a key-value pair in the hash map
    public void put(int key, int value) {
        int index = hash(key); // Compute the bucket index
        if (map[index] == null) {
            // Create a new linked list if the bucket is empty
            map[index] = new Node(key, value);
        } else {
            Node current = map[index]; // Traverse the linked list
            while (current != null) {
                if (current.key == key) {
                    // Update the value if the key already exists
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    // Add a new node to the end of the list
                    current.next = new Node(key, value);
                    return;
                }
                current = current.next;
            }
        }
    }

    // Retrieves the value associated with the given key
    // Returns -1 if the key does not exist
    public int get(int key) {
        int index = hash(key); // Compute the bucket index
        Node current = map[index]; // Get the linked list at the index
        while (current != null) {
            if (current.key == key) {
                return current.value; // Key found, return its value
            }
            current = current.next; // Move to the next node
        }
        return -1; // Key not found
    }

    // Removes the key-value pair from the hash map if it exists
    public void remove(int key) {
        int index = hash(key); // Compute the bucket index
        Node current = map[index]; // Get the linked list at the index
        Node prev = null; // Keep track of the previous node

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    // Remove the head node
                    map[index] = current.next;
                } else {
                    // Remove the node by skipping it
                    prev.next = current.next;
                }
                return;
            }
            prev = current; // Update the previous node
            current = current.next; // Move to the next node
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);    // The map is now [[1,1]]
        myHashMap.put(2, 2);    // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1)); // Output: 1
        System.out.println(myHashMap.get(3)); // Output: -1
        myHashMap.put(2, 1);    // Update value for key 2
        System.out.println(myHashMap.get(2)); // Output: 1
        myHashMap.remove(2);    // Remove key 2
        System.out.println(myHashMap.get(2)); // Output: -1
    }
}