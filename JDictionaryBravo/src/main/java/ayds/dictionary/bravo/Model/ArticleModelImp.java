package ayds.dictionary.bravo.Model;import ayds.dictionary.bravo.Model.ErrorHandler.ErrorHandler;class ArticleModelImp implements ArticleModel {    private final Repository repository;    private ArticleInterface article;    private ErrorHandler errorHandler;    private ArticleModelListener listener;    ArticleModelImp(Repository repository, ErrorHandler errorHandler) {        this.errorHandler = errorHandler;        this.repository = repository;    }    public ArticleInterface getArticle() {        return article;    }    public void setErrorListener(ErrorHandlerListener listener) {        errorHandler.setErrorListener(listener);    }    public void setListener(ArticleModelListener listener) {        this.listener = listener;    }    public void searchArticle(String term) {        article = repository.getArticle(term);        notifyListener();    }    private void notifyListener() {        if (listener != null) {            listener.didUpdateArticle();        }    }}