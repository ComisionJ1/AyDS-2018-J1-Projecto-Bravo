package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.Source;

import java.util.List;

public interface RemoteSourceServices {

    List<Source> getSources();

    Article getArticle(Source source, String term) throws Exception;

}
