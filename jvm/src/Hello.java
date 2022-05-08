public class Hello {
    public static void main(String[] args) {
        new Hello().hello();
    }

    public void hello(){
        int a = 1;
        double b = a * (double)1;
        double c = b + b;
        System.out.println(c);
        for (int i=0; i<5; i++){
            System.out.println(i);
        }
        if(a==1){
            System.out.println(a);
        }
    }
}
