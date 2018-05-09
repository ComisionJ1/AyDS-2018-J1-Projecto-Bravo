package ayds.dictionary.bravo.Model.Exception;

import java.sql.SQLException;

public class ErrorGettingArticleFromLocalDatabase extends SQLException {

    public String getMessage(){
        return "Ocurrió un error al obtener el articulo de la base de datos local.";
    }
}
