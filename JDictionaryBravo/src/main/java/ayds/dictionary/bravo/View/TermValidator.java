package ayds.dictionary.bravo.View;

import ayds.dictionary.bravo.Model.Exception.UnallowedCharacterException;

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
