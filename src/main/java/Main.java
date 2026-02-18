public class Main {
    public static void main(String[] args) {
        int x = 1;
        long result = cubic(x);
        System.out.println("result: " + result);

        String first = "Albert";
        String last = "Einsten";
        int result2 = findByName(last, first);
         System.out.println(first + " " + last);

        String str = 12 - 6 + "Hello" + 7 + 5;
        System.out.println("Str: " + str);


        char c = 'A';
       for(int i = 1; i <= 10; i++) {
            System.out.print(c++ + " ");
            }
        System.out.print(c);
    }

    public static long cubic(int y) {
        long longValue = (long) y;
        y = -1;

        return longValue * longValue * longValue;
    }

    public static int findByName(String lastName, String firstName) {
        lastName = "Lepota";
        firstName = "Mabotse";

        return -1;
         }
}
