package ayds.dictionary.bravo.Model.Exception;

import java.sql.SQLException;

public class ConnectionWithDatabaseLostException extends SQLException {

    public String getMessage(){
        return "Ocurrió un error al conectarse con la base de datos local.";
    }

}
