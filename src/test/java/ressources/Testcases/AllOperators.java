package ressources.Testcases;

public class AllOperators {
    public int c = 3;

    //public AllOperators(int pC) {
    //    c = pC;
    //}*/

    public static void main(String[] args) {
        AllOperators allOps = new AllOperators();
        System.out.println(allOps.plus(2, 5));
        System.out.println(allOps.minus(2, 5));
        System.out.println(allOps.mul(2, 5));
        System.out.println(allOps.div(2, 5));
        System.out.println(allOps.incpre(2));
        System.out.println(allOps.incsuf(2));
        System.out.println(allOps.decpre(2));
        System.out.println(allOps.decsuf(2));
        System.out.println(allOps.relLess(2, 5));
        System.out.println(allOps.relGreater(2, 5));
        System.out.println(allOps.relLessEqual(2, 5));
        System.out.println(allOps.relGreatEqual(2, 5));
        System.out.println(allOps.equal(2, 5));
        System.out.println(allOps.notEqual(2, 5));
        System.out.println(allOps.And(true, false));
        System.out.println(allOps.Or(true, false));
        System.out.println(allOps.bwAnd(true, false));
        System.out.println(allOps.bwOr(true, false));
        System.out.println(allOps.assign(3));
        System.out.println(allOps.plusAssign(3));
        System.out.println(allOps.minusAssign(3));
        System.out.println(allOps.mulAssing(2));
        System.out.println(allOps.divAssing(2));
        System.out.println(allOps.modAssing(2));

    }

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int mod(int a, int b) {
        return a % b;
    }

    public int incpre(int a) {
        return ++a;
    }

    public int incsuf(int a) {
        a++;
        return a;
    }

    public int decpre(int a) {
        return --a;
    }

    public int decsuf(int a) {
        a--;
        return a;
    }

    public boolean relLess(int a, int b) {
        return a < b;
    }

    public boolean relGreater(int a, int b) {
        return a > b;
    }

    public boolean relLessEqual(int a, int b) {
        return a <= b;
    }

    public boolean relGreatEqual(int a, int b) {
        return a >= b;
    }

    public boolean equal(int a, int b) {
        return a == b;
    }

    public boolean notEqual(int a, int b) {
        return a != b;
    }

    public boolean And(boolean a, boolean b) {
        return a && b;
    }

    public boolean Or(boolean a, boolean b) {
        return a || b;
    }

    public boolean bwAnd(boolean a, boolean b) {
        return a & b;
    }

    public boolean bwOr(boolean a, boolean b) {
        return a | b;
    }

    public int assign(int a) {
        c = a;
        return c;
    }

    public int plusAssign(int a) {
        c = 3;
        return c += a;
    }

    public int minusAssign(int a) {
        c = 3;
        return c -= a;
    }

    public int mulAssing(int a) {
        c = 4;
        return c *= a;
    }

    public int divAssing(int a) {
        c = 4;
        return c /= a;
    }

    public int modAssing(int a) {
        c = 4;
        return c %= a;
    }
}
