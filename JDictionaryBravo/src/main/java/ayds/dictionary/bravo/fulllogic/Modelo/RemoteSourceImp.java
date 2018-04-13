package ayds.dictionary.bravo.fulllogic.Modelo;import org.w3c.dom.Document;import org.w3c.dom.Node;import org.w3c.dom.NodeList;import org.xml.sax.InputSource;import org.xml.sax.SAXException;import retrofit2.Response;import retrofit2.Retrofit;import retrofit2.*;import retrofit2.converter.scalars.ScalarsConverterFactory;import javax.xml.parsers.DocumentBuilder;import javax.xml.parsers.DocumentBuilderFactory;import javax.xml.parsers.ParserConfigurationException;import java.io.IOException;public class RemoteSourceImp implements RemoteSource {    WikipediaAPI wikiAPI;    public RemoteSourceImp(){        Retrofit retrofit = new Retrofit.Builder()                .baseUrl("https://en.wikipedia.org/w/")                .addConverterFactory(ScalarsConverterFactory.create())                .build();        wikiAPI = retrofit.create(WikipediaAPI.class);    }    public Article getMeaning(String term) {        Response<String> callResponse;        Call<String> call;        String text = null;        try {            callResponse = wikiAPI.getTerm(term).execute();            System.out.println("XML " + callResponse.body());            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();            DocumentBuilder db = dbf.newDocumentBuilder();            Document doc = db.parse(new InputSource(new java.io.StringReader(callResponse.body())));            NodeList nodes = doc.getDocumentElement().getElementsByTagName("extract");            Node extract = nodes.item(0);            if (extract == null) {                text = "No Results";            } else {                text = extract.getTextContent().replace("\\n", "\n");            }        } catch (ParserConfigurationException e1) {            e1.printStackTrace();        } catch (IOException e1) {            e1.printStackTrace();        } catch (SAXException e1) {            e1.printStackTrace();        }        return new Article(term, text);    }}