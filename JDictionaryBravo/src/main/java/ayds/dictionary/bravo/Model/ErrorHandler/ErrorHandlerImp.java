package ayds.dictionary.bravo.Model.ErrorHandler;

import ayds.dictionary.bravo.Model.ErrorHandlerListener;

class ErrorHandlerImp implements ErrorHandler {

    private ErrorHandlerListener listenerError;

    public void setErrorListener(ErrorHandlerListener listener) {
        this.listenerError = listener;
    }

    public void hasError(Exception e) {
        notifyListener(e);
    }

    private void notifyListener(Exception e) {
        if (listenerError != null) {
            listenerError.errorEvent(e);
        }
    }
}
