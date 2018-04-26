package ayds.dictionary.bravo.Controller;

import ayds.dictionary.bravo.View.ArticleView;

public interface ArticleController {

    void onEventUpdate(String term);

    void setArticleView(ArticleView articleView);

}
