package mmc.parser;

class Main {
    //Test
    public static void main(String[] args) {
        foo();
    }

    public static void foo() {
        System.out.println(Test.getInstance().test2.getTest3().a.charAt(1));
    }
}

class Test {
    String a = "MMC";

    Test2 test2 = new Test2();



    static Test getInstance() {
        return new Test();
    }
}

class Test2 {

    String a = "MMC";

    Test3 test3 = new Test3();

    Test3 getTest3 () {
        return test3;
    }

    static Test2 getInstance() {
        return new Test2();
    }
}

class Test3 {
    String a = "MMC";
}