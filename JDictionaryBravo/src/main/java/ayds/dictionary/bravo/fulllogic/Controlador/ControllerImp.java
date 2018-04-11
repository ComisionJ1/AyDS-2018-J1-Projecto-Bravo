package ayds.dictionary.bravo.fulllogic.Controlador;

import ayds.dictionary.bravo.fulllogic.Modelo.Article;
import ayds.dictionary.bravo.fulllogic.Modelo.Repository;
import ayds.dictionary.bravo.fulllogic.Vista.View;

public class ControllerImp implements Controller{

    private Repository repository;
    private View view;

    public ControllerImp(Repository repository, View view){
        this.repository=repository;
        this.view=view;
    }

    public void getArticle(String term) {
        new Thread(new Runnable() {
            @Override public void run() {
                Article article= repository.getArticle(term);
                view.showArticle(article);
            }
        }).start();
    }

}
