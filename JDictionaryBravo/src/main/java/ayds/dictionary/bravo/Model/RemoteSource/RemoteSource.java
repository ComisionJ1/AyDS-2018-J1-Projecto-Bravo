package ayds.dictionary.bravo.Model.RemoteSource;import ayds.dictionary.bravo.Model.Article;import java.io.IOException;public interface RemoteSource {    Article getMeaning(String term) throws IOException;}