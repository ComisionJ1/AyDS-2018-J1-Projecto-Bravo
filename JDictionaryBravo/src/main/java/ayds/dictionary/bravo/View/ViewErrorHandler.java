package ayds.dictionary.bravo.View;

import javax.swing.*;

public class ViewErrorHandler {

    public static void showError(String message) {

        JOptionPane.showMessageDialog(null,
                message,
                "Ocurrio un error.", JOptionPane.ERROR_MESSAGE);

    }

}
