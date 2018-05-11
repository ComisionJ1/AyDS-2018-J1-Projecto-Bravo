package ayds.dictionary.bravo.Model.ErrorHandler;

public class ErrorHandlerModule {

    private static ErrorHandlerModule instance;
    private ErrorHandlerImp errorHandler;

    private ErrorHandlerModule() {
        errorHandler = new ErrorHandlerImp();
    }

    public static ErrorHandlerModule getInstance() {
        if (instance == null) {
            instance = new ErrorHandlerModule();
        }
        return instance;
    }

    public ErrorHandlerImp getErrorHandler() {
        return errorHandler;
    }
}
