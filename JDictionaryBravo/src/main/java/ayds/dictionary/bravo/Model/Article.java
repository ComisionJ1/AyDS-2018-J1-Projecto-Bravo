package ayds.dictionary.bravo.Model;

public class Article {

    private static final String prefix = "[*]";

    private String term;
    private String meaning;
    private Source source;

    public Article(String term, String meaning, Source source) {
        this.term = term;
        this.meaning = meaning;
        this.source=source;
    }

    public String getTerm() {
        return term;
    }

    public String getMeaning() {
        return meaning;
    }

    public Source getSource() {
        return source;
    }

    public void addPrefix() {
        meaning = prefix + " " + meaning;
    }

    public boolean hasMeaning() {
        return getMeaning() != null && !getMeaning().trim().equals("");
    }
}
