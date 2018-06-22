package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.WikipediaService.WikipediaService;
import ayds.dictionary.bravo.Model.Source;
import ayds.dictionary.delta.services.BigHugeLabsService;
import ayds.dictionary.foxtrot.services.YandexService;

import java.util.HashMap;
import java.util.Map;

public class RemoteSourceFactoryImp implements RemoteSourceFactory {

    private Map<Source,RemoteSource> services;

    RemoteSourceFactoryImp(BigHugeLabsService bigHugeLabsService, WikipediaService wikipediaService, YandexService yandexService) {
        RemoteSource wikipedia = new WikipediaRemoteSourceAdapter(wikipediaService);
        RemoteSource yandex = new YandexRemoteSourceAdapter(yandexService);
        RemoteSource bigHugeLabs = new BigHugeLabsRemoteSourceAdapter(bigHugeLabsService);

        services=new HashMap<>();

        services.put(Source.BIGHUGELABS,bigHugeLabs);
        services.put(Source.WIKIPEDIA, wikipedia);
        services.put(Source.YANDEX, yandex);
    }

    @Override
    public Map<Source, RemoteSource> getServicies() {
        return services;
    }
}
