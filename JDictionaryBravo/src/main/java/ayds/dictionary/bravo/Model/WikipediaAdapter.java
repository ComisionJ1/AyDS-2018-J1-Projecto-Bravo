package ayds.dictionary.bravo.Model;

import ayds.dictionary.RemoteSource.RemoteSource;

class WikipediaAdapter implements Adapter {

    private RemoteSource remoteSource;

    WikipediaAdapter(RemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override
    public Article getArticle(String term) throws Exception {
        String meaning = remoteSource.getMeaning(term);
        return new Article(term, meaning, Source.WIKIPEDIA);
    }
}
