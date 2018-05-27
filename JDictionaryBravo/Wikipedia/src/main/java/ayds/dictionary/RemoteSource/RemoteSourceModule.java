package ayds.dictionary.RemoteSource;

public class RemoteSourceModule {

    private static RemoteSourceModule instance;
    private RemoteSource remoteSource;

    private RemoteSourceModule() {

        ResponseFormatParser parser = new ParserFromXML();
        remoteSource = new RemoteSourceImp(parser);
    }

    public static RemoteSourceModule getInstance() {
        if (instance == null) {
            instance = new RemoteSourceModule();
        }
        return instance;
    }

    public RemoteSource getRemoteSource() {
        return remoteSource;
    }

}
