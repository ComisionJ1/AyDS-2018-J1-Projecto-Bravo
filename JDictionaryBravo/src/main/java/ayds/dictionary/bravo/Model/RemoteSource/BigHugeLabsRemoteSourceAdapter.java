package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.EmptyArticle;
import ayds.dictionary.bravo.Model.Source;
import ayds.dictionary.delta.services.BigHugeLabsService;

public class BigHugeLabsRemoteSourceAdapter implements RemoteSource {

    private BigHugeLabsService bigHugeLabsService;

    public BigHugeLabsRemoteSourceAdapter(BigHugeLabsService bigHugeLabsService) {
        this.bigHugeLabsService = bigHugeLabsService;
        //vamos a tener un facotory que cree las instancias por cada una
    }

    @Override
    public Article getArticle(String term) throws Exception {
        String meaning = bigHugeLabsService.getMeaning(term);
        if (meaning == null || meaning.trim().equals("")) {
            return new EmptyArticle(term, Source.BIGHUGELABS);
        } else {
            return new Article(term, meaning, Source.BIGHUGELABS);
        }
    }
}