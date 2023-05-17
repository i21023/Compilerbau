package ressources.Testcases;

public class FieldVarClassMutable {
    int x = 10;
    int y = 0;
    FieldVarClassMutable(int pY){
        y=pY;
    }

    public int addXY(){
        return x+y;
    }
}
