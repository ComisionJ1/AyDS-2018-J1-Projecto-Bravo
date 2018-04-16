package ayds.dictionary.bravo.fulllogic.Modelo.RemoteSource;

public class RemoteSourceModule {

    private static RemoteSourceModule instance;
    private RemoteSource remoteSource;

    private RemoteSourceModule() {
        remoteSource=new RemoteSourceImp();
    }

    public static RemoteSourceModule getInstance() {
        if(instance == null) {
            instance =  new RemoteSourceModule();
        }
        return instance;
    }

    public RemoteSource getRemoteSource() {
        return remoteSource;
    }

}
