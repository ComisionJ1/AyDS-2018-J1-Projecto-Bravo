package ayds.dictionary.bravo.fulllogic.Modelo;

public class ArticleModelImp implements ArticleModel{
    private String term;
    private String meaning;

    public ArticleModelImp(String term, String meaning){
        this.term=term;
        this.meaning=meaning;
    }

    public String getTerm(){
        return term;
    }

    public String getMeaning(){
        return meaning;
    }

}
