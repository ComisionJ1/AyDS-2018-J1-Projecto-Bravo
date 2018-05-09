package ayds.dictionary.bravo.Model.Exception;

public class UnallowedCharacterException extends Exception {

    public String getMessage(){
        return "Ha ingresado un caracter prohibido. Debe ingresar caracteres de a-Z.";
    }
}
