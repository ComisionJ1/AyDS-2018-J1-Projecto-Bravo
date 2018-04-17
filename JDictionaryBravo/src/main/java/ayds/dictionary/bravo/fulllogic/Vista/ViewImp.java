package ayds.dictionary.bravo.fulllogic.Vista;

import ayds.dictionary.bravo.fulllogic.Controlador.Controller;
import ayds.dictionary.bravo.fulllogic.Modelo.Article;
import ayds.dictionary.bravo.fulllogic.Modelo.ArticleModel;
import ayds.dictionary.bravo.fulllogic.Modelo.ArticleModelListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewImp implements View{
    private Controller controller;
    private ArticleModel articleModel;
    private JTextField termTextField;
    private JButton goButton;
    protected JPanel contentPane;
    private JTextPane meaningTextPane;

    public ViewImp(Controller controller, ArticleModel articleModel){
        this.controller=controller;
        this.articleModel=articleModel;

        meaningTextPane.setContentType("text/html");

        initListeners();
  }

    private void initListeners(){
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isValidTerm(termTextField.getText())) {
                    controller.onEventUpdate(termTextField.getText().trim());
                }
                else {
                    showAllowedCharacters();
                }
            }
        });

        articleModel.setListener(new ArticleModelListener() {
            @Override
            public void didUpdateArticle() {
                updateMeaningTextPane();
            }
        });
  }

    private void showAllowedCharacters(){
        JOptionPane.showMessageDialog(null, "El término ingresado está en un formato incorrecto. Sólo se permiten letras de a-Z.", "Formato Incorrecto", JOptionPane.ERROR_MESSAGE);
    }

    private boolean isValidTerm(String term) {
        boolean isValid = false;

        String termWithoutWhiteSpaces = term.trim().replaceAll("\\s+", " ");

        if (termWithoutWhiteSpaces.matches("([a-zA-Z]+\\s?)+"))
            isValid = true;
        return isValid;
    }

    private void updateMeaningTextPane(){
        Article article=articleModel.getArticle();

        if(!article.isMeaningNull()) {
            String meaningText =TextConverter.textToHtml(article.getTerm(),article.getMeaning());
             meaningTextPane.setText(meaningText);
        }
        else {
            meaningTextPane.setText("No results.");
        }
    }

}

