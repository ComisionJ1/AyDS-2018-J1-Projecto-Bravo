package ayds.dictionary.RemoteSource;

import org.w3c.dom.Node;
import retrofit2.Response;

public interface ResponseFormatParser {

    Node parse(Response<String> callResponse);

}
