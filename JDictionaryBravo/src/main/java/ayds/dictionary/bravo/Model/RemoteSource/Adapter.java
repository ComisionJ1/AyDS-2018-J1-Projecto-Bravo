package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.bravo.Model.Article;

public interface Adapter {

    Article getArticle(String term) throws Exception;

}
