package ressources.Testcases;

public class Verkettung {
    public static int getFinalInt() {
        return ++Test1.m.getR().getL().getT().c;
    }

    public static void main(String[] args) {
        getFinalInt();
    }
}

class Test1 {
    public int c = 2;
    public static Test3 m = new Test3();
}

class Test2 {
    Test1 t = new Test1();

    public Test1 getT() {
        return t;
    }
}

class Test3 {
    Test4 r = new Test4();


    public Test4 getR() {
        return r;
    }
}

class Test4 {
    Test2 l = new Test2();

    public Test2 getL() {
        return l;
    }
}
