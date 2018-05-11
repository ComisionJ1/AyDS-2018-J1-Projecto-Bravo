package ayds.dictionary.bravo.Model.LocalSource;

public class DBError extends Error {

    public String getMessage() {
        return "Error inesperado en la base de datos.";
    }

}
