package ayds.dictionary.bravo.Model.RemoteSource;import ayds.dictionary.bravo.Model.Article;import org.w3c.dom.Node;import org.xml.sax.SAXException;import retrofit2.Response;import retrofit2.Retrofit;import retrofit2.converter.scalars.ScalarsConverterFactory;import javax.xml.parsers.ParserConfigurationException;import java.io.IOException;class RemoteSourceImp implements RemoteSource {    private static final String url="https://en.wikipedia.org/w/";    private ResponseFormatParser parser;    private WikipediaAPI wikiAPI;    //aca voy a tener un objeto del parse    RemoteSourceImp(ResponseFormatParser parser){        Retrofit retrofit = new Retrofit.Builder()                .baseUrl(url)                .addConverterFactory(ScalarsConverterFactory.create())                .build();        wikiAPI = retrofit.create(WikipediaAPI.class);        this.parser=parser;    }    public Article getMeaning(String term) {        Response<String> callResponse;        String text = null;        try {            callResponse = wikiAPI.getTerm(term).execute();            Node extract= parser.parse(callResponse);            if (extract!=null) {                text = extract.getTextContent().replace("\\n", "\n");                text = text.replace("'", "`");            }        } catch (IOException e1) {            e1.printStackTrace();        }        return new Article(term, text);    }}