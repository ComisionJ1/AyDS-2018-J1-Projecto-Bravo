package ayds.dictionary.bravo.Model.RemoteSource;

import ayds.dictionary.bravo.Model.RemoteSource.RemoteSource;
import ayds.dictionary.bravo.Model.Source;

import java.util.Map;

public interface RemoteSourceFactory {

    Map<Source, RemoteSource> getServicies();

}
