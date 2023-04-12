public class Main {
    static long count = 0;
    public static void c(){
        count++;
        System.out.println(count);
        c();
    }
    public static void main(String[] args) {
        String str = "a";
        System.out.println(str.substring(1));
    }
}