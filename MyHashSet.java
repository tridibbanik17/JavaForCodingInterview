// This is an implementation of a HashSet without using any built-in hash table libraries.
class MyHashSet {
    // Represents a single key in the hash set
    private static class Node {
        int key; // The key stored in this node
        Node next; // Pointer to the next node in the chain

        Node(int key) {
            this.key = key;
        }
    }

    private static final int SIZE = 1000; // Fixed size of the primary array (number of buckets)
    private Node[] set; // Array to store linked lists (buckets)

    // Initializes the hash set with empty buckets
    public MyHashSet() {
        set = new Node[SIZE];
    }

    // Computes the index in the array using the hash function
    private int hash(int key) {
        return key % SIZE;
    }

    // Adds a key to the hash set
    // If the key already exists, no action is taken
    public void add(int key) {
        int index = hash(key); // Compute the bucket index
        if (set[index] == null) {
            // Create a new linked list if the bucket is empty
            set[index] = new Node(key);
        } else {
            Node current = set[index]; // Traverse the linked list
            while (current != null) {
                if (current.key == key) {
                    return; // Key already exists, do nothing
                }
                if (current.next == null) {
                    // Add a new node to the end of the list
                    current.next = new Node(key);
                    return;
                }
                current = current.next;
            }
        }
    }

    // Removes a key from the hash set if it exists
    public void remove(int key) {
        int index = hash(key); // Compute the bucket index
        Node current = set[index]; // Get the linked list at the index
        Node prev = null; // Keep track of the previous node

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    // Remove the head node
                    set[index] = current.next;
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

    // Checks if a key exists in the hash set
    public boolean contains(int key) {
        int index = hash(key); // Compute the bucket index
        Node current = set[index]; // Get the linked list at the index

        while (current != null) {
            if (current.key == key) {
                return true; // Key found
            }
            current = current.next; // Move to the next node
        }
        return false; // Key not found
    }
    
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);       // The set is now [1]
        myHashSet.add(2);       // The set is now [1, 2]
        System.out.println(myHashSet.contains(1)); // Output: true
        System.out.println(myHashSet.contains(3)); // Output: false
        myHashSet.add(2);       // No change, key 2 already exists
        System.out.println(myHashSet.contains(2)); // Output: true
        myHashSet.remove(2);    // The set is now [1]
        System.out.println(myHashSet.contains(2)); // Output: false
    }
}

