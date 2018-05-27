package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.RemoteSource.RemoteSource;
import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.Source;

import java.io.IOException;

public class WikipediaAdapter implements Adapter {

    private RemoteSource remoteSource;

    public WikipediaAdapter(RemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override
    public Article getArticle(String term) throws IOException {
        String meaning = remoteSource.getMeaning(term);
        return new Article(term, meaning, Source.WIKIPEDIA);
    }
}
