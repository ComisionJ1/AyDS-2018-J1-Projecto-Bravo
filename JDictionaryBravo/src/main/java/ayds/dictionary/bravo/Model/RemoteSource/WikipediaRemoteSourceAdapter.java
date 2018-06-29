package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.WikipediaService.WikipediaService;
import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.EmptyArticle;
import ayds.dictionary.bravo.Model.Source;

import java.io.IOException;

class WikipediaRemoteSourceAdapter implements RemoteSource {

    private WikipediaService wikipediaService;

    WikipediaRemoteSourceAdapter(WikipediaService wikipediaService) {
        this.wikipediaService = wikipediaService;
    }

    @Override
    public Article getArticle(String term) throws IOException {
        String meaning = wikipediaService.getMeaning(term);
        if (meaning == null || meaning.trim().equals("")) {
            return new EmptyArticle(term, Source.WIKIPEDIA);
        } else {
            return new Article(term, meaning, Source.WIKIPEDIA);
        }
    }
}
