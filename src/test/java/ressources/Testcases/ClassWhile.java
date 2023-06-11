package ressources.Testcases;

public class ClassWhile {

    public int mult(int a, int b) {
        int c = 0;
        if (a == 0 || b == 0) {
            return 0;
        }
        while (b != 1) {
            c += a;
            b--;
        }
        return c;
    }
}
