package opcional2;

public class Principal {
    public static void main(String[] args) {
        A o1 = new A(5, 2);
        Sistema.print(o1.m1());

        A o2 = new A(-3, 2);
        Sistema.print(o2.m1());
    }
    
}
