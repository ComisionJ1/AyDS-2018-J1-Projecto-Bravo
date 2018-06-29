package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.bravo.Model.Source;

import java.util.Map;

interface RemoteSourceFactory {

    Map<Source, RemoteSource> getServicies();

}
