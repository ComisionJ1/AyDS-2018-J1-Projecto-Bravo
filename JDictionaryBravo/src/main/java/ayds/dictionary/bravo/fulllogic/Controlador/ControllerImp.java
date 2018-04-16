package ayds.dictionary.bravo.fulllogic.Controlador;

import ayds.dictionary.bravo.fulllogic.Modelo.*;
import ayds.dictionary.bravo.fulllogic.Vista.View;

public class ControllerImp implements Controller{

    private ArticleModel articleModel;
    private View view;

    public ControllerImp(ArticleModel articleModel){
        this.articleModel=articleModel;
    }

    public void setView(View view) {
        this.view=view;
    }

    @Override
    public void onEventUpdate(String term) {
        new Thread(new Runnable() {
            @Override public void run() {
                 articleModel.updateArticle(term);
            }
        }).start();
    }

}
