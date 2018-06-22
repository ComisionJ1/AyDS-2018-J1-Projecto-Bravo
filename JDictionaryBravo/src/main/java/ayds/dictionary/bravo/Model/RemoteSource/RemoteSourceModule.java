package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.WikipediaService.WikipediaService;
import ayds.dictionary.WikipediaService.WikipediaServiceModule;
import ayds.dictionary.delta.services.BigHugeLabsModule;
import ayds.dictionary.delta.services.BigHugeLabsService;
import ayds.dictionary.foxtrot.services.YandexService;
import ayds.dictionary.foxtrot.services.YandexServiceModule;

public class RemoteSourceModule {

    private static RemoteSourceModule instance;
    private RemoteSourceServices remoteSourceServices;

    private RemoteSourceModule() {
        BigHugeLabsService bigHugeLabsService = BigHugeLabsModule.getInstance().getBigHugeLabsService();
        WikipediaService wikipediaService = WikipediaServiceModule.getInstance().getWikipediaService();
        YandexService yandexService = YandexServiceModule.getInstance().getRemoteSource();

        RemoteSourceFactory remoteSourceFactory = new RemoteSourceFactoryImp(bigHugeLabsService,wikipediaService,yandexService);
        remoteSourceServices = new RemoteSourceServicesImp(remoteSourceFactory);
    }

    public static RemoteSourceModule getInstance() {
        if (instance == null) {
            instance = new RemoteSourceModule();
        }
        return instance;
    }

    public RemoteSourceServices getRemoteSourceServices() {
        return remoteSourceServices;
    }
}
