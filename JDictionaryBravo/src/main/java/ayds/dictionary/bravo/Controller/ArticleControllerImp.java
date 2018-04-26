package ayds.dictionary.bravo.Controller;

import ayds.dictionary.bravo.Model.ArticleModel;
import ayds.dictionary.bravo.View.ArticleView;

class ArticleControllerImp implements ArticleController {

    private ArticleModel articleModel;
    private ArticleView articleView;

    ArticleControllerImp(ArticleModel articleModel) {
        this.articleModel = articleModel;
    }

    public void setArticleView(ArticleView articleView) {
        this.articleView = articleView;
    }

    @Override
    public void onEventUpdate(String term) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                articleModel.searchArticle(term);
            }
        }).start();
    }

}
