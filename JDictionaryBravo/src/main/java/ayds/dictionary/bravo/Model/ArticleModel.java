package ayds.dictionary.bravo.Model;public interface ArticleModel {    ArticleInterface getArticle();    void searchArticle(String term);    void setListener(ArticleModelListener listener);    void setErrorListener(ErrorHandlerListener listener);}