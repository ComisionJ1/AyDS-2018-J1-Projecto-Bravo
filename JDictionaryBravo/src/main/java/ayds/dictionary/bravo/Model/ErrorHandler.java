package ayds.dictionary.bravo.Model;

public class ErrorHandler {

    private ErrorHandlerListener listenerError;

    public void setListener(ErrorHandlerListener listener) {
        this.listenerError = listener;
    }

    public void hasError(String message) {
        notifyListener(message);
    }
    private void notifyListener(String message) {
        if (listenerError != null) {
            listenerError.errorEvent(message);
        }
    }
}
