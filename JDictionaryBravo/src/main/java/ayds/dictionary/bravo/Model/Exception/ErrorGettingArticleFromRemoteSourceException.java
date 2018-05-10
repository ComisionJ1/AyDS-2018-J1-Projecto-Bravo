package ayds.dictionary.bravo.Model.Exception;

import java.io.IOException;

public class ErrorGettingArticleFromRemoteSourceException extends IOException {

    public String getMessage(){
        return "Ocurrió un error al obtener el articulo de la fuente remota.";
    }
}
