package ayds.dictionary.bravo.fulllogic.Controlador;

import ayds.dictionary.bravo.fulllogic.Vista.*;
import ayds.dictionary.bravo.fulllogic.Modelo.*;

public class ControllerModule {

    private static ControllerModule instance;

    private ControllerModule() {}

    public static ControllerModule getInstance() {
        if (instance==null) {
            instance=new ControllerModule();
        }
        return instance;
    }

    void startApplication () {

        Controller controller = getController();
        View view = openWindowAndGetView(controller);
        controller.setView(view);

    }

    private Controller getController () {
        return new ControllerImp(ArticleModelModule.getInstance().getArticleModel());
    }

    private View openWindowAndGetView(Controller controller){

        return ViewModule.getInstance().openWindow(controller);
    }

}
