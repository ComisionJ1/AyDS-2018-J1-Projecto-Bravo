package ayds.dictionary.bravo.fulllogic.Modelo;

public class ArticleModelModule {

    private static ArticleModelModule instance;
    private ArticleModel articleModel;

    private ArticleModelModule () {
        articleModel= new ArticleModelImp("dog", "hola");
    }

    public static ArticleModelModule getInstance() {
        if (instance==null) instance= new ArticleModelModule();
        return instance;
    }

    public ArticleModel getArticleModel(){
        return articleModel;
    }

}
