package ayds.dictionary.bravo.View;

class TermValidator {

    public static boolean isTermValid(String term) throws UnallowedCharacterException {
        boolean isValid = false;
        String termWithoutWhiteSpaces = term.trim().replaceAll("\\s+", " ");

        if (termWithoutWhiteSpaces.matches("([A-Za-zÀ-ÿ]+\\s?)+"))
            isValid = true;
        else throw new UnallowedCharacterException();

        return isValid;
    }
}
