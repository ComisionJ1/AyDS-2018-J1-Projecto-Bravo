package ayds.dictionary.bravo.Model.ErrorHandler;

import ayds.dictionary.bravo.Model.ErrorHandlerListener;

import java.io.IOException;
import java.util.List;

class ErrorHandlerImp implements ErrorHandler {

    private ErrorHandlerListener listenerError;

    public void setErrorListener(ErrorHandlerListener listener) {
        this.listenerError = listener;
    }

    public void hasError(Exception e) {
        notifyListener(e);
    }

    @Override
    public void hasError(List<Exception> exceptionList) {
        String errors="";

        for (Exception e: exceptionList) {
            if(e instanceof IOException){
                errors = errors + "Error de conexión." + '\n';
            }
            else {
                errors = errors + "Error inesperado." + '\n';
            }
        }

        notifyListener(new Exception(errors));
    }

    private void notifyListener(Exception e) {
        if (listenerError != null) {
            listenerError.errorEvent(e);
        }
    }
}
