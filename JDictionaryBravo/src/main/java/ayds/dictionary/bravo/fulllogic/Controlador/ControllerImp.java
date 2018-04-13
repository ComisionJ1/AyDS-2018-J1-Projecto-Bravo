package ayds.dictionary.bravo.fulllogic.Controlador;

import ayds.dictionary.bravo.fulllogic.Modelo.*;
import ayds.dictionary.bravo.fulllogic.Vista.View;

import java.rmi.Remote;

public class ControllerImp implements Controller{

    private Repository repository;
    private ArticleModel articleModel;
    private View view;
    private boolean isInLocalSource;

    public ControllerImp(ArticleModel articleModel){
        this.articleModel=articleModel;
        LocalSource localSource= new LocalSourceImp();
        RemoteSource remoteSource = new RemoteSourceImp();
        repository=new Repository(localSource, remoteSource);
    }

    public void getArticle(String term) {
        new Thread(new Runnable() {
            @Override public void run() {
                ArticleModel article= repository.getArticle(term);
                isInLocalSource=repository.isInLocalSource();
                view.showArticle(article);
            }
        }).start();
    }

    public boolean isInLocalSource(){
        return isInLocalSource;
    }
    @Override
    public void setArticleView(View view) {
        this.view=view;
    }

}
