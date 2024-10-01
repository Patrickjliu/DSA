package StackDequesQueue;

import java.util.HashMap;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        Deques deque = new Deques();

        deque.append(10);
        deque.append(20);
        deque.prepend(5);
        System.out.println("size: " + deque.size());

        System.out.println(validate("[(){[]}]"));

        System.out.println(validate("()[{]}"));

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(ListNode.palindrome(head));

        BrowserHistory history = new BrowserHistory("bentley.com");
        history.visit("google.com");
        history.visit("facebook.com");
        System.out.println(history.back(1));
        System.out.println(history.forward(1));
    }

    public static boolean validate(String input) {
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);
            if (bracketMap.containsKey(c)) {
                stack.push(c);
            } else if (bracketMap.containsValue(c)) {
                if (stack.isEmpty()) {

                    return false;
                }
                char openBracket = stack.pop();
                if (bracketMap.get(openBracket) != c) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        this.val = 0;
        this.next = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static boolean palindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            int top = stack.pop();

            if (temp.val != top) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }
}

class BrowserHistory {
    public Stack<String> backStack;

    public Stack<String> forwardStack;
    public String currentPage;

    public BrowserHistory(String homePage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = homePage;
    }
    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
    }
    

    public String forward(int steps) {
        while (steps > 0 && !forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            steps--;
        }
        return currentPage;
    }

    public String back(int steps) {
        while (steps > 0 && !backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            steps--;
        }
        return currentPage;
    }

    
}

class Deques {
    Node start;
    Node end;
    int size;

    public Deques() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public void append(int x) {
        Node newNode = new Node(x);
        if (size == 0) {
            start = newNode;
            end = newNode;
        } else {
            newNode.previous_node = end;
            end.next_node = newNode;
            end = newNode;
        }
        size++;
    }

    public void prepend(int x) {
        Node newNode = new Node(x);
        if (size == 0) {
            start = newNode;
            end = newNode;
        } else {
            newNode.next_node = start;
            start.previous_node = newNode;
            start = newNode;
        }
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        int value = end.value;
        end = end.previous_node;
        if (end == null) {
            start = null;
        } else {
            end.next_node = null;
        }
        size--;
        return value;
    }

    public int popLeft() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }

        int value = start.value;
        start = start.next_node;
        if (start == null) {
            end = null;
        } else {
            start.previous_node = null;
        }
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public void clear() {
        start = null;
        end = null;
        size = 0;
    }
}

class Node {
    int value;
    Node next_node;
    Node previous_node;

    public Node(int value) {

        this.value = value;
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

// 2.Write a function called validate(String input) that will take in a string that represents all the parenthesis and brackets from a program in order. 

// Have the function return whether or not the string supports a valid open and close. 

// Valid open brackets are { ( and [ valid close brackets are } ) ]. You can assume all characters within the string input will be one of these characters
// A string is valid under the following
// Every Open bracket is eventually closed
// A bracket is closed by it's matching set ( opens ) closes etc.
// Ever Close bracket is matched to be corresponding to the most recent unclosed open bracket.
// Ex validate("[(){[]}]") -> True
// Ex validate("()[{]}") -> False
