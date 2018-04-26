package ayds.dictionary.bravo.Model.RemoteSource;

import retrofit2.Response;
import org.w3c.dom.Node;

public interface ResponseFormatParser {

    Node parse(Response<String> callResponse);

}
