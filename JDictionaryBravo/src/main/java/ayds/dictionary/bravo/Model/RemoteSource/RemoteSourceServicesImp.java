package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.Source;

import java.util.ArrayList;
import java.util.List;

class RemoteSourceServicesImp implements RemoteSourceServices {

    private final RemoteSourceFactory serviceFactory;

    RemoteSourceServicesImp(RemoteSourceFactory serviceFactory){
        this.serviceFactory=serviceFactory;
    }

    @Override
    public List<Source> getSources(){
        List<Source> sources = new ArrayList<>();
        sources.addAll(serviceFactory.getServicies().keySet());
        return sources;
    }

    @Override
    public Article getArticle(Source source, String term) throws Exception{
        RemoteSource remoteSource = serviceFactory.getServicies().get(source);
        return remoteSource.getArticle(term);
    }
}
