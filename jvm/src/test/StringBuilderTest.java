package test;

public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asd");
        stringBuilder.append("bvd");
        stringBuilder.append("bvc");
        System.out.println(stringBuilder);

        stringBuilder.append("asd");
        stringBuilder.append("bvd");
        stringBuilder.append("bvc");
        System.out.println(stringBuilder);
    }
}
