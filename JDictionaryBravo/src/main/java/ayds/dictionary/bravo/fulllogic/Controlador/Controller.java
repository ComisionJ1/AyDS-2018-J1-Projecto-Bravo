package ayds.dictionary.bravo.fulllogic.Controlador;

import ayds.dictionary.bravo.fulllogic.Vista.View;

public interface Controller {

    void getArticle(String term);
    void setView(View view);
    boolean isInLocalSource();

}
