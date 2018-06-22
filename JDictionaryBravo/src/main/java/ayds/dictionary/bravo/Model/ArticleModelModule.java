package ayds.dictionary.bravo.Model;

import ayds.dictionary.bravo.Model.ErrorHandler.ErrorHandler;
import ayds.dictionary.bravo.Model.ErrorHandler.ErrorHandlerModule;
import ayds.dictionary.bravo.Model.LocalSource.LocalSource;
import ayds.dictionary.bravo.Model.LocalSource.LocalSourceModule;
import ayds.dictionary.bravo.Model.RemoteSource.RemoteSourceModule;
import ayds.dictionary.bravo.Model.RemoteSource.RemoteSourceServices;

public class ArticleModelModule {

    private static ArticleModelModule instance;
    private ArticleModel articleModel;

    private ArticleModelModule() {
        ErrorHandler errorHandler = ErrorHandlerModule.getInstance().getErrorHandler();

        LocalSource localSource = LocalSourceModule.getInstance().getLocalSource();
        RemoteSourceServices remoteSourceServices = RemoteSourceModule.getInstance().getRemoteSourceServices();

        Repository repository = new Repository(localSource, errorHandler, remoteSourceServices);
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
