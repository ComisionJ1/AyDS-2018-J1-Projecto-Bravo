package ayds.dictionary.bravo.Model;public class EmptyArticle extends Article {    public EmptyArticle(String term, Source source) {        super(term,null,source);    }    @Override    public void addPrefix() {    }    @Override    public boolean hasMeaning() {        return false;    }}