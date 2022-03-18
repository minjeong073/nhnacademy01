//Swap advanced

public class prac4 {

    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("a: " + a + ", b: " + b);
        a = a + b - (b=a);
        System.out.println("After swap. a: " + a + ", b: " + b);
    }

}
