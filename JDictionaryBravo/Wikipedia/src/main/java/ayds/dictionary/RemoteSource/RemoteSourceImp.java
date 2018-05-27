package ayds.dictionary.RemoteSource;import org.w3c.dom.Node;import retrofit2.Response;import retrofit2.Retrofit;import retrofit2.converter.scalars.ScalarsConverterFactory;import java.io.IOException;class RemoteSourceImp implements RemoteSource {    private static final String URL = "https://en.wikipedia.org/w/";    private ResponseFormatParser parser;    private WikipediaAPI wikiAPI;    RemoteSourceImp(ResponseFormatParser parser) {        Retrofit retrofit = new Retrofit.Builder()                .baseUrl(URL)                .addConverterFactory(ScalarsConverterFactory.create())                .build();        wikiAPI = retrofit.create(WikipediaAPI.class);        this.parser = parser;    }    public String getMeaning(String term) throws IOException {        Response<String> callResponse;        String text = null;        callResponse = wikiAPI.getTerm(term).execute();        Node extract = parser.parse(callResponse);        if (extract != null) {            text = extract.getTextContent().replace("\\n", "\n");            text = text.replace("'", "`");        }        return text;    }}