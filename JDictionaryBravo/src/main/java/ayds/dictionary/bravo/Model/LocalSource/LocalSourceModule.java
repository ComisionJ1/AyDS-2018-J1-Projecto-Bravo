package ayds.dictionary.bravo.Model.LocalSource;

public class LocalSourceModule {

    private static LocalSourceModule instance;
    private LocalSource localSource;

    private LocalSourceModule() {
        localSource=new LocalSourceImp();
    }

    public static LocalSourceModule getInstance() {
        if(instance == null) {
            instance =  new LocalSourceModule();
        }
        return instance;
    }

    public LocalSource getLocalSource() {
        return localSource;
    }
}
