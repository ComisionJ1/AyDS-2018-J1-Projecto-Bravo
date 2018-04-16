package ayds.dictionary.bravo.fulllogic.Controlador;

import ayds.dictionary.bravo.fulllogic.Vista.View;

public interface Controller {

    void onEventUpdate(String term);

    void setView(View view);

}
