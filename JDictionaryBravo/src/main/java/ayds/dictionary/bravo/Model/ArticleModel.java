package ayds.dictionary.bravo.Model;import java.util.List;public interface ArticleModel {    List<Article> getArticles();    void searchArticles(String term);    void setListener(ArticleModelListener listener);    void setErrorListener(ErrorHandlerListener listener);}