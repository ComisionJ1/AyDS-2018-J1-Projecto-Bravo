package ayds.dictionary.bravo.fulllogic.Modelo;

public class ModelModule {

    private static ModelModule instance;
    private Repository repository;

    private ModelModule() {
        LocalSource localSource= new LocalSourceImp();
        RemoteSource remoteSource = new RemoteSourceImp();
        repository=new Repository(localSource, remoteSource);
    }

    public static ModelModule getInstance() {
        if(instance == null) {
            instance =  new ModelModule();
        }
        return instance;
    }

    public Repository getRepository() {
        return repository;
    }

}
