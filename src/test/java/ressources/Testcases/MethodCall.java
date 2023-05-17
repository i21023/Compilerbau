package ressources.Testcases;

public class MethodCall {

    private int getA() {
        int a = 1;
        return a;
    }

    public int addConstant(int b) {
        return b + getA();
    }

}
