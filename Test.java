public class Test {
    public static void main(String[] args) {
        List<Integer> arr = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        arr.remove(1);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}