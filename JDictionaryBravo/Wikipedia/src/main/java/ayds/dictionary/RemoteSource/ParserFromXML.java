package ayds.dictionary.RemoteSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import retrofit2.Response;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

class ParserFromXML implements ResponseFormatParser {

    @Override
    public Node parse(Response<String> callResponse) {
        Node extract = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new java.io.StringReader(callResponse.body())));

            NodeList nodes = doc.getDocumentElement().getElementsByTagName("extract");
            extract = nodes.item(0);
        } catch (ParserConfigurationException | IOException | SAXException exception) {
        }
        return extract;
    }
}
