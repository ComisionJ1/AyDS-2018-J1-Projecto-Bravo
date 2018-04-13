package ayds.dictionary.bravo.fulllogic.Controlador;

import ayds.dictionary.bravo.fulllogic.Modelo.*;
import ayds.dictionary.bravo.fulllogic.Vista.View;

import java.rmi.Remote;

public class ControllerImp implements Controller{

    private Repository repository;
    private View view;
    private boolean isInLocalSource;

    public ControllerImp(Repository repository){
        this.repository=repository;
    }

    public void getArticle(String term) {
        new Thread(new Runnable() {
            @Override public void run() {
                Article article= repository.getArticle(term);
                isInLocalSource=repository.isInLocalSource();
                view.showArticle(article);
            }
        }).start();
    }

    public boolean isInLocalSource(){
        return isInLocalSource;
    }

    public void setView(View view) {
        this.view=view;
    }

}
