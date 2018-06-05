package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.EmptyArticle;
import ayds.dictionary.bravo.Model.Source;

import java.io.IOException;

public class WikipediaRemoteSource implements RemoteSource {

    private ayds.dictionary.RemoteSource.RemoteSource remoteSource;

    public WikipediaRemoteSource(ayds.dictionary.RemoteSource.RemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override
    public Article getArticle(String term) throws IOException {
        String meaning = remoteSource.getMeaning(term);
        if (meaning == null || meaning.trim().equals("")) {
            return new EmptyArticle(term, Source.WIKIPEDIA);
        } else {
            return new Article(term, meaning, Source.WIKIPEDIA);
        }
    }
}
