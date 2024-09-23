public class main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.append(10);
        list.append(20);
        list.append(30);
        System.out.println(list.toString());

        list.prepend(5);
        System.out.println(list.toString());

        System.out.println("Deleted value at index 2: " + list.delete(2));
        System.out.println(list.toString());

        int[] array = list.toArray();
        System.out.println("Linked list as array: " + java.util.Arrays.toString(array));
    }
}