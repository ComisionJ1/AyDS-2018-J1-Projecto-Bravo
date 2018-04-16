package ayds.dictionary.bravo.fulllogic.Modelo;

import ayds.dictionary.bravo.fulllogic.Modelo.LocalSource.LocalSource;
import ayds.dictionary.bravo.fulllogic.Modelo.LocalSource.LocalSourceImp;
import ayds.dictionary.bravo.fulllogic.Modelo.RemoteSource.RemoteSource;
import ayds.dictionary.bravo.fulllogic.Modelo.RemoteSource.RemoteSourceImp;

public class ArticleModelModule {

    private static ArticleModelModule instance;
    private ArticleModel articleModel;

    private ArticleModelModule() {

        LocalSource localSource= new LocalSourceImp();
        RemoteSource remoteSource = new RemoteSourceImp();
        Repository repository=new Repository(localSource, remoteSource);
        articleModel= new ArticleModelImp(repository);

    }

    public static ArticleModelModule getInstance() {
        if(instance == null) {
            instance =  new ArticleModelModule();
        }
        return instance;
    }

    public ArticleModel getArticleModel() {
        return articleModel;
    }

}
