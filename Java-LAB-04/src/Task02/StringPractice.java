package Task02;

public class StringPractice {

    public static void main(String[] args) {
        String str = "I learn Java!!!";

        char lastChar = str.charAt(str.length() - 1);
        System.out.println("Останній символ рядка: " + lastChar);

        boolean endsWithExclamation = str.endsWith("!!!");
        System.out.println("Чи закінчується рядок на \"!!!\": " + endsWithExclamation);

        boolean startsWithILearn = str.startsWith("I learn ");
        System.out.println("Чи починається рядок на \"I learn \": " + startsWithILearn);

        boolean containsJava = str.contains("Java");
        System.out.println("Чи містить рядок підрядок \"Java\": " + containsJava);

        int indexOfJava = str.indexOf("Java");
        System.out.println("Позиція підрядка \"Java\": " + indexOfJava);

        String replacedString = str.replace('a', 'o');
        System.out.println("Замінені \"a\" на \"o\": " + replacedString);

        String upperCaseString = str.toUpperCase();
        System.out.println("Рядок у верхньому регістрі: " + upperCaseString);

        String lowerCaseString = str.toLowerCase();
        System.out.println("Рядок у нижньому регістрі: " + lowerCaseString);

        String cutJava = str.substring(0, indexOfJava) + str.substring(indexOfJava + 4);
        System.out.println("Рядок без \"Java\": " + cutJava);
    }
}
