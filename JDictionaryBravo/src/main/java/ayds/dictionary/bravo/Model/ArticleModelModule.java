package ayds.dictionary.bravo.Model;

import ayds.dictionary.bravo.Model.LocalSource.LocalSource;
import ayds.dictionary.bravo.Model.LocalSource.LocalSourceModule;
import ayds.dictionary.bravo.Model.RemoteSource.RemoteSource;
import ayds.dictionary.bravo.Model.RemoteSource.RemoteSourceModule;

public class ArticleModelModule {

    private static ArticleModelModule instance;
    private ArticleModel articleModel;

    private ArticleModelModule() {
        LocalSource localSource = LocalSourceModule.getInstance().getLocalSource();
        RemoteSource remoteSource = RemoteSourceModule.getInstance().getRemoteSource();
        ErrorHandler errorHandler = ErrorHandlerModule.getInstance().getErrorHandler();
        Repository repository = new Repository(localSource, remoteSource, errorHandler);
        articleModel = new ArticleModelImp(repository, errorHandler);
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
