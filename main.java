import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Test appending
        System.out.println("Appending 10, 20, 30:");
        list.append(10);
        list.append(20);
        list.append(30);
        System.out.println(list.toString());

        // Test prepending
        System.out.println("\nPrepending 5:");
        list.prepend(5);
        System.out.println(list.toString());

        // Test inserting at index
        System.out.println("\nInserting 15 at index 2:");
        list.insert(2, 15);
        System.out.println(list.toString());

        // Test popping from front
        System.out.println("\nPopping from front:");
        System.out.println("Popped: " + list.popFront());
        System.out.println(list.toString());

        // Test popping from end
        System.out.println("\nPopping from end:");
        System.out.println("Popped: " + list.popEnd());
        System.out.println(list.toString());

        // Test deleting by index
        System.out.println("\nDeleting value at index 1:");
        System.out.println("Deleted: " + list.delete(1));
        System.out.println(list.toString());

        // Test get by index
        System.out.println("\nGet value at index 1:");
        System.out.println("Value: " + list.get(1));

        // Test finding value
        System.out.println("\nFind index of value 10:");
        System.out.println("Index of 10: " + list.find(10));

        System.out.println("\nFind index of value 100:");
        System.out.println("Index of 100: " + list.find(100));

        // Test converting to array
        System.out.println("\nLinked list as array:");
        ArrayList<Integer> array = list.toArray();
        System.out.println(array);
    }
}