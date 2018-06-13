package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.WikipediaService.WikipediaService;
import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.EmptyArticle;
import ayds.dictionary.bravo.Model.Source;

import java.io.IOException;

public class WikipediaRemoteSourceAdapter implements RemoteSource {

    private WikipediaService wikipediaService;

    public WikipediaRemoteSourceAdapter(WikipediaService wikipediaService) {
        this.wikipediaService = wikipediaService;
        //vamos a tener un facotory que cree las instancias por cada una
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
