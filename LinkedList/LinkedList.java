package LinkedList;

import java.util.ArrayList;

// Linked Lists are our first node based data structure and the first one we will be making ourselves.

// You will need the two following classes. (If you are not familiar with python classes you can find the information hereLinks to an external site.)

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

// Doubly Linked List Class

// Attributes
// Start -> the node that starts the linked list
// end -> the node that is the end of the linked list
// Methods (Methods that try and access non existent indexes or remove values not present can throw exceptions javaLinks to an external site. pythonLinks to an external site. 
// append(x): O(1) -> adds a new node to the end of the list with value x
// prepend(x) O(1)-> adds a new node to the start of the list with value x 



public class LinkedList {

    Node start;
    Node end;

    public LinkedList() {
        this.start = null;
        this.end = null;
    }

    public void append(int v) {
        Node newNode = new Node(v);

        if (start == null) {
            start = newNode;
            end = newNode;
        } else {
            end.setNext(newNode);
            newNode.setPrevious(end);
            end = newNode;
        }
    }

    public void prepend(int v) {
        Node newNode = new Node(v);

        if (start == null) {
            start = newNode;
            end = newNode;
        } else {
            start.setPrevious(newNode);
            newNode.setNext(start);
            start = newNode;
        }
    }

    public void insert(int index, int v) {
        Node newNode = new Node(v);

        if (start == null) {
            start = newNode;
            end = newNode;
        } else {
            Node current = start;
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }

            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());

            if (current.getPrevious() != null) {
                current.getPrevious().setNext(newNode);
            } else {
                start = newNode;
            }
            current.setPrevious(newNode);
        }
    }

    public int popFront() {
        if (start == null) {
            return -1;
        }
    
        int value = start.value;
    
        if (start == end) {
            start = null;
            end = null;
        } else {
            start = start.getNext();
            start.setPrevious(null);
        }
    
        return value;
    }
    
    public int popEnd() {
        if (end == null) {
            return -1;
        }
    
        int value = end.value;
    
        if (start == end) {
            start = null;
            end = null;
        } else {
            end = end.getPrevious();
            end.setNext(null);
        }
    
        return value;
    }    
    
    
    public int delete(int index) {
        if (start == null) {
            return -1;
        }
    
        Node current = start;
        for (int i = 0; i < index && current != null; i++) {
            current = current.getNext();
        }
    
        if (current == null) {
            return -1;
        }
    
        int value = current.value;
    
        if (current.getPrevious() != null) {
            current.getPrevious().setNext(current.getNext());
        } else {
            start = current.getNext();
        }
    
        if (current.getNext() != null) {
            current.getNext().setPrevious(current.getPrevious());
        } else {
            end = current.getPrevious();
        }
    
        return value;
    }
    
    public int get(int index) {
        Node current = start;
        for (int i = 0; i < index && current != null; i++) {
            current = current.getNext();
        }
        if (current == null) {
            return -1;
        }
        return current.value;
    }
    
    public int find(int v) {
        Node current = start;
        int index = 0;
        while (current != null) {
            if (current.value == v) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public ArrayList toArray() {

        Node current = start;
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        while (current != null) {
            arraylist.add(current.value);
            current = current.next_node;
        }

        return arraylist;
    }

    @Override
    public String toString() {

        Node current = start;

        while (current != null) {
            System.out.print(current.value);
            if (current.getNext() != null) {
                System.out.print(" <-> ");
            }
            current = current.next_node;
        }

        return "";
    }
}



// insert(index, x) O(n)-> adds a new node at the specified index to the list with value x
// popFront() O(1)-> removes the first node from the list and returns the value that was there.
// popEnd() O(1)-> removes the last node form the list and returns the value that was there.
// delete(index) O(n)-> Removes the node at the given index from the list and returns the value that was there.
// get(index) O(n)-> returns the value of the node at the given index.
// find(x) O(n)-> returns the index of the first node with the value of x within the linked list.(Can return -1 or throw an exception if no value exists.)
// toArray() O(n)-> returns the contents of the linked list in the form of an array(arraylist or list are fine)
// toString() -> Override the default toString method to print out your linked list.
// an example of a printed list might look like this (Double Linked List: <-> 17 <-> 5 <-> 7 <-> 12 <-> )
// I would recommend doing this one first for testing purposes.