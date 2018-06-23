package ayds.dictionary.bravo.Model.ErrorHandler;

import ayds.dictionary.bravo.Model.ErrorHandlerListener;

import java.util.List;

public interface ErrorHandler {

    void setErrorListener(ErrorHandlerListener listener);

    void hasError(Exception e);

    void hasError(List<Exception> exceptionList);

}
