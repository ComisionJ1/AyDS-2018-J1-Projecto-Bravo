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
        articleView.updateProgress(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<=100; i++) {
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    articleView.updateProgress(i);
                }
                articleModel.searchArticle(term);
            }
        }).start();
    }





}
