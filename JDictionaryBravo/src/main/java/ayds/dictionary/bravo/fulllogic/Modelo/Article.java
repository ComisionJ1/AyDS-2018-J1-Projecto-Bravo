package ayds.dictionary.bravo.fulllogic.Modelo;

public class Article{
    private String term;
    private String meaning;

    public Article(String term, String meaning){
        this.term=term;
        this.meaning=meaning;
    }

    public String getTerm(){
        return term;
    }

    public String getMeaning(){
        return meaning;
    }

    public void addPrefix(){
        meaning="[*] "+meaning;
    }
}
