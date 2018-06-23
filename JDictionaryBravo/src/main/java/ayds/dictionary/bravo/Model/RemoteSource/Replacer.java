package ayds.dictionary.bravo.Model.RemoteSource;

public class Replacer {

    public static String replace(String sentence){

        if(sentence!=null) {
            sentence = sentence.replace("\\n", "\n");
            sentence = sentence.replace("'", "`");
        }
        return sentence;
    }

}
