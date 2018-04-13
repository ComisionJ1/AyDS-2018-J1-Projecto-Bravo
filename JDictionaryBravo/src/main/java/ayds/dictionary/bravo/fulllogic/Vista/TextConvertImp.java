package ayds.dictionary.bravo.fulllogic.Vista;

public class TextConvertImp implements TextConverter{

    public String textToHtml(String term, String text) {

        StringBuilder builder = new StringBuilder();

        builder.append("<font face=\"arial\">");

        String textWithBold = text
                .replace("'", "`")
                .replaceAll("(?i)" + term, "<b>" + term +"</b>");

        builder.append(textWithBold);

        builder.append("</font>");

        return builder.toString();
    }

}