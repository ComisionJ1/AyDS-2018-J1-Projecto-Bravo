package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.EmptyArticle;
import ayds.dictionary.bravo.Model.Source;
import ayds.dictionary.delta.services.BigHugeLabsService;

public class BigHugeLabsRemoteSourceAdapter implements RemoteSource {

    private BigHugeLabsService bigHugeLabsService;

    public BigHugeLabsRemoteSourceAdapter(BigHugeLabsService bigHugeLabsService) {
        this.bigHugeLabsService = bigHugeLabsService;
    }

    @Override
    public Article getArticle(String term) throws Exception {

        if(isWellFormedTermFormat(term)) {

            String meaning = bigHugeLabsService.getMeaning(term);
            if (meaning == null || meaning.trim().equals("")) {
                return new EmptyArticle(term, Source.BIGHUGELABS);
            } else {
                return new Article(term, meaning, Source.BIGHUGELABS);
            }
        }
        else
            return new EmptyArticle(term, Source.BIGHUGELABS);

    }

    //Código incluido por petición de los dueños de la librería
    private boolean isWellFormedTermFormat(String term) {
        char termLetter;
        boolean wellFormedTerm = true;
        for (int i = 0; i < term.length() && wellFormedTerm; i++) {
            termLetter = term.charAt(i);
            if (!Character.isLetter(termLetter)) {
                wellFormedTerm = false;
            }
        }
        return wellFormedTerm;
    }
}