package ayds.dictionary.bravo.Model.ErrorHandler;

import ayds.dictionary.bravo.Model.ErrorHandlerListener;

public interface ErrorHandler {

    void setErrorListener(ErrorHandlerListener listener);

    void hasError(Exception e);

}
