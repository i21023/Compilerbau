package ressources;

class Bar {
    public static int i = 0;
    public int j = 1;

    public void foo() {
        System.out.println(i);

    }

    public static int foo(int n) {
        return n;
    }

    class Test {

        public static void main(String[] args) {
            int p = ++Bar.i;
            ++p;
            System.out.println(p);
        }
    }
}
