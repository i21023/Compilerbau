package ressources.testcases;

public class Rekursion {
    public int addRek(int a, int b)
    {
        if(b==0)
        {
            return a;
        }
        return addRek(a++,b--);
    }
}
