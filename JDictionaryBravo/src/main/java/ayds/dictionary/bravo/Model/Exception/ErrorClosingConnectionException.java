package ayds.dictionary.bravo.Model.Exception;

import java.sql.SQLException;

public class ErrorClosingConnectionException extends SQLException {

    public String getMessage(){
        return "Ocurrió un error intentando cerrar la conexión de la base de datos local.";
    }
}
