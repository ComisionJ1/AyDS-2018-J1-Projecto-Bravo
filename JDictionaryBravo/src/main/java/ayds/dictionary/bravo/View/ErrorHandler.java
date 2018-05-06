package ayds.dictionary.bravo.View;

import javax.swing.JOptionPane;

public class ErrorHandler {

    public static void showAllowedCharacters() {
        JOptionPane.showMessageDialog(null, "El término ingresado está en un formato incorrecto. Sólo se permiten letras de a-Z.", "Formato Incorrecto", JOptionPane.ERROR_MESSAGE);
    }

    public static void showConnectionLost() {
        JOptionPane.showMessageDialog(null, "No hay conexión a internet disponible.", "Conexión Inexistente.", JOptionPane.ERROR_MESSAGE);
    }

    public static void showConnectionWithDatabaseLost() {
        JOptionPane.showMessageDialog(null, "No hay conexión disponible con la base de datos local.", "Conexión con base de datos inexistente.", JOptionPane.ERROR_MESSAGE);
    }

    public static void showErrorGettingArticleFromDatabase() {
        JOptionPane.showMessageDialog(null, "Ocurrió un error obteniendo el artículo de la base de datos local.", "Error al obtener articulo.", JOptionPane.ERROR_MESSAGE);
    }

}
