package ayds.dictionary.bravo.Model;

import ayds.dictionary.RemoteSource.RemoteSource;
import ayds.dictionary.RemoteSource.RemoteSourceModule;
import ayds.dictionary.bravo.Model.LocalSource.LocalSource;
import ayds.dictionary.bravo.Model.LocalSource.LocalSourceModule;

public class ArticleModelModule {

    private static ArticleModelModule instance;
    private ArticleModel articleModel;

    private ArticleModelModule() {
        LocalSource localSource = LocalSourceModule.getInstance().getLocalSource();
        RemoteSource remoteSource = RemoteSourceModule.getInstance().getRemoteSource();
        WikipediaAdapter wikipediaAdapter=new WikipediaAdapter(remoteSource);
        Repository repository = new Repository(localSource, wikipediaAdapter);
        articleModel = new ArticleModelImp(repository);
    }

    public static ArticleModelModule getInstance() {
        if (instance == null) {
            instance = new ArticleModelModule();
        }
        return instance;
    }

    public ArticleModel getArticleModel() {
        return articleModel;
    }

}
