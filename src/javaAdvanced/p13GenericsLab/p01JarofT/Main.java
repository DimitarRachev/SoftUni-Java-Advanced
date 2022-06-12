package javaAdvanced.p13GenericsLab.p01JarofT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();
        jar.add("text");
        jar.add("text1");
        jar.add("text2");
        System.out.println(jar.remove());
    }
}
