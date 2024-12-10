package Task_02;

public class StringPractice {

    public static void main(String[] args) {
        String str = "I learn Java!!!";

        char lastChar = str.charAt(str.length() - 1);
        System.out.println("The last character of the string: " + lastChar);

        boolean endsWithExclamation = str.endsWith("!!!");
        System.out.println("Does the string end in \"!!!\": " + endsWithExclamation);

        boolean startsWithILearn = str.startsWith("I learn ");
        System.out.println("Does the string begin with \"I learn \": " + startsWithILearn);

        boolean containsJava = str.contains("Java");
        System.out.println("Does the string contain a substring \"Java\": " + containsJava);

        int indexOfJava = str.indexOf("Java");
        System.out.println("Substring position \"Java\": " + indexOfJava);

        String replacedString = str.replace('a', 'o');
        System.out.println("Replaced by. \"a\" на \"o\": " + replacedString);

        String upperCaseString = str.toUpperCase();
        System.out.println("The string is in upper case: " + upperCaseString);

        String lowerCaseString = str.toLowerCase();
        System.out.println("The string is in lower case: " + lowerCaseString);

        String cutJava = str.substring(0, indexOfJava) + str.substring(indexOfJava + 4);
        System.out.println("A string without \"Java\": " + cutJava);
    }
}
