package ayds.dictionary.bravo.Model.Exception;

import java.sql.SQLException;

public class ErrorSavingArticleException extends SQLException {
    public String getMessage(){
        return "Ocurrió un error guardando el articulo.";
    }
}
