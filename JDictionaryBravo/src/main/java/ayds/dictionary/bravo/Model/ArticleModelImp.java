package ayds.dictionary.bravo.Model;class ArticleModelImp implements ArticleModel {    private final Repository repository;    private Article article;    private ErrorHandler errorHandler;    private ArticleModelListener listener;    ArticleModelImp(Repository repository, ErrorHandler errorHandler) {        this.errorHandler=errorHandler;        this.repository = repository;    }    public Article getArticle() {        return article;    }    public ErrorHandler getErrorHandler() {        return errorHandler;    }    public void setListener(ArticleModelListener listener) {        this.listener = listener;    }    public void searchArticle(String term) {        article = repository.getArticle(term);        notifyListener();    }    private void notifyListener() {        if (listener != null) {            listener.didUpdateArticle();        }    }}