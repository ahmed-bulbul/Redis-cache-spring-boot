public class Swap {

    public static void main(String[] args) {
        int a=20,b=10;

        a=a-b;
        b=a+b;
        a=b-a;
        System.out.println("a = "+a +" and b ="+b);
    }
}
