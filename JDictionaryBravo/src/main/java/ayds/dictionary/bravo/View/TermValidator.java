package ayds.dictionary.bravo.View;

import ayds.dictionary.bravo.Model.ErrorHandlerModule;

class TermValidator {

    public static boolean isTermValid(String term) {
        boolean isValid = false;
        String termWithoutWhiteSpaces = term.trim().replaceAll("\\s+", " ");

        if (termWithoutWhiteSpaces.matches("([A-Za-zÀ-ÿ]+\\s?)+"))
            isValid = true;

        if (isValid==false) ErrorHandlerModule.getInstance().getErrorHandler().hasError
                ("Ha ingresado un caracter prohibido. Los caracteres aceptados son a-Z.");

        return isValid;
    }
}
