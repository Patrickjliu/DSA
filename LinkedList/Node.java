package LinkedList;
// Node class

// Following Attributes
// The value at the node(This can be whatever data type you prefer)
// The  next node in the linked list
// The previous node in the linked list
// These Functions
// getNext() -> returns the next node in the list
// getPrevious() -> returns the previous node in the list
// setNext(x) -> update the nodes next node to be x
// setPrevious(x) -> update the nodes previous node to x

public class Node {
    int value;
    Node next_node;
    Node previous_node;

    public Node(int v) {
        this.value = v;
        this.next_node = null;
        this.previous_node = null;
    }

    public Node getNext() {
        return this.next_node;
    }

    public Node getPrevious() {
        return this.previous_node;
    }

    public void setNext(Node node) {
        this.next_node = node;
    }

    public void setPrevious(Node node) {
        this.previous_node = node;
    }
}