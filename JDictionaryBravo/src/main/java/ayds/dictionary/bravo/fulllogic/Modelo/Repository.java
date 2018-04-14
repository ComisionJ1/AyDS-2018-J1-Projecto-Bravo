package ayds.dictionary.bravo.fulllogic.Modelo;public class Repository {    private final LocalSource localSource;    private final RemoteSource remoteSource;    public Repository(LocalSource localSource,RemoteSource remoteSource){        this.localSource=localSource;        this.remoteSource=remoteSource;    }    public Article getArticle(String term){        Article article=localSource.getMeaning(term);        if(article==null) {            article = remoteSource.getMeaning(term);            localSource.saveArticle(article);        }        return article;    }}