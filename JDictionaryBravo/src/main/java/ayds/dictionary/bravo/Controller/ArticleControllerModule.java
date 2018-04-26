package ayds.dictionary.bravo.Controller;

import ayds.dictionary.bravo.Model.ArticleModelModule;
import ayds.dictionary.bravo.View.ArticleView;
import ayds.dictionary.bravo.View.ArticleViewModule;

public class ArticleControllerModule {

    private static ArticleControllerModule instance;

    private ArticleControllerModule() {
    }

    public static ArticleControllerModule getInstance() {
        if (instance == null) {
            instance = new ArticleControllerModule();
        }
        return instance;
    }

    void startApplication() {
        ArticleController articleController = getController();
        ArticleView articleView = openWindowAndGetView(articleController);
        articleController.setArticleView(articleView);
    }

    private ArticleController getController() {
        return new ArticleControllerImp(ArticleModelModule.getInstance().getArticleModel());
    }

    private ArticleView openWindowAndGetView(ArticleController articleController) {
        return ArticleViewModule.getInstance().openWindow(articleController);
    }

}
