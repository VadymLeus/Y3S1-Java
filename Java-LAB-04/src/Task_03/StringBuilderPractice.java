package Task_03;

public class StringBuilderPractice {

    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 36;

        StringBuilder sb1 = new StringBuilder();
        sb1.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        System.out.println(sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        sb2.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        System.out.println(sb2.toString());

        StringBuilder sb3 = new StringBuilder();
        sb3.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println(sb3.toString());

        StringBuilder sb1Modified = new StringBuilder(sb1);
        int equalSignIndex1 = sb1Modified.indexOf("=");
        sb1Modified.deleteCharAt(equalSignIndex1);
        sb1Modified.insert(equalSignIndex1, "evenly");
        System.out.println("After insert and deleteCharAt: " + sb1Modified.toString());

        StringBuilder sb2Modified = new StringBuilder(sb2);
        int equalSignIndex2 = sb2Modified.indexOf("=");
        sb2Modified.replace(equalSignIndex2, equalSignIndex2 + 1, "even");
        System.out.println("After  replace: " + sb2Modified.toString());

        StringBuilder sb3Reversed = new StringBuilder(sb3);
        sb3Reversed.reverse();
        System.out.println("After  reverse: " + sb3Reversed.toString());

        System.out.println("Length sb1: " + sb1.length());
        System.out.println("Capacity sb1: " + sb1.capacity());
    }
}
