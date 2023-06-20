package ressources.Testcases;

public class Fibbonacci {


    public static void main(String[] args) {
        int x = getFibonacciNumberAt(7); // 5
        System.out.println(x);
    }

    public static int getFibonacciNumberAt(int n) {
        if (n < 2) {
            return n;
        } else
            return getFibonacciNumberAt(n - 1) + getFibonacciNumberAt(n - 2);
    }

}
