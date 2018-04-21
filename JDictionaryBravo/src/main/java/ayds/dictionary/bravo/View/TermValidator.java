package ayds.dictionary.bravo.View;

public class TermValidator {

    public static boolean isValidTerm(String term) {
        boolean isValid = false;

        String termWithoutWhiteSpaces = term.trim().replaceAll("\\s+", " ");

        if (termWithoutWhiteSpaces.matches("([A-Za-zÀ-ÿ]+\\s?)+"))
            isValid = true;
        return isValid;
    }
}
