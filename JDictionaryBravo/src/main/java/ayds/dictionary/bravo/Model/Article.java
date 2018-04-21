package ayds.dictionary.bravo.Model;

public class Article {

    private static final String prefix = "[*]";

    private String term;
    private String meaning;

    public Article(String term, String meaning) {
        this.term = term;
        this.meaning = meaning;
    }

    public String getTerm() {
        return term;
    }

    public String getMeaning() {
        return meaning;
    }

    public void addPrefix() {
        meaning = prefix + " " + meaning;
    }

    public boolean hasMeaning() {
        return getMeaning() != null && !getMeaning().trim().equals("");
    }
}
