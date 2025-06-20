package opcional2;

public class A {
    private int v1;

    public A(int x, int y) {
        v1 = (x > y) ? x+10 : y;
    }

    public int m1() {
        return v1;
    }    
}
