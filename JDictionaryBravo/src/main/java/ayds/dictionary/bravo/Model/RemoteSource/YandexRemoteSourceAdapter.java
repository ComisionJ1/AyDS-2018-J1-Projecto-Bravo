package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.EmptyArticle;
import ayds.dictionary.bravo.Model.Source;
import ayds.dictionary.foxtrot.services.YandexService;

import java.io.IOException;

public class YandexRemoteSourceAdapter implements RemoteSource{

    private YandexService yandexService;

    public YandexRemoteSourceAdapter(YandexService yandexService) {
        this.yandexService = yandexService;
        //vamos a tener un facotory que cree las instancias por cada una
    }

    @Override
    public Article getArticle(String term) throws IOException {
        String meaning = yandexService.getMeaning(term);
        if (meaning == null || meaning.trim().equals("")) {
            return new EmptyArticle(term, Source.YANDEX);
        } else {
            return new Article(term, meaning, Source.YANDEX);
        }
    }

}
