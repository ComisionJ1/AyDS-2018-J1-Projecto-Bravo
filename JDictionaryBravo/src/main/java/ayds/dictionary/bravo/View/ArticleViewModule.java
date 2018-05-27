package ayds.dictionary.bravo.View;

import ayds.dictionary.bravo.Controller.ArticleController;
import ayds.dictionary.bravo.Model.ArticleModelModule;

import javax.swing.*;

public class ArticleViewModule {

    private static ArticleViewModule instance;

    private ArticleViewModule() {
    }

    public static ArticleViewModule getInstance() {
        if (instance == null) instance = new ArticleViewModule();
        return instance;
    }

    public ArticleView openWindow(ArticleController articleController) {
        ArticleViewImp view = new ArticleViewImp(articleController, ArticleModelModule.getInstance().getArticleModel());

        JFrame frame = new JFrame("Online Dictionary");
        frame.setContentPane(view.contentPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        return view;
    }

}
