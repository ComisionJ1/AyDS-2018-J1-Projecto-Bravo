package ayds.dictionary.bravo.fulllogic.Vista;

import ayds.dictionary.bravo.fulllogic.Controlador.Controller;
import ayds.dictionary.bravo.fulllogic.Modelo.ArticleModelModule;

import javax.swing.*;

public class ViewModule {

    private static ViewModule instance;

    private ViewModule() {}

    public static ViewModule getInstance() {
        if (instance==null) instance = new ViewModule();
        return instance;
    }

    public View openWindow (Controller controller) {
        ViewImp view = new ViewImp(controller,ArticleModelModule.getInstance().getArticleModel());


        JFrame frame = new JFrame("Online Dictionary");
        frame.setContentPane(view.contentPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        return view;
    }


}
