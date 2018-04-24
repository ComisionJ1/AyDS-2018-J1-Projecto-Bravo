package ayds.dictionary.bravo.View;

import ayds.dictionary.bravo.Controller.ArticleController;
import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.ArticleModel;
import ayds.dictionary.bravo.Model.ArticleModelListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ArticleViewImp implements ArticleView {
    private ArticleController articleController;
    private ArticleModel articleModel;
    private JTextField termTextField;
    private JButton goButton;
    protected JPanel contentPane;
    private JTextPane meaningTextPane;

    ArticleViewImp(ArticleController articleController, ArticleModel articleModel) {
        this.articleController = articleController;
        this.articleModel = articleModel;

        meaningTextPane.setContentType("text/html");

        initListeners();
    }

    private void initListeners() {

        initGoButtonListener();

        initArticleModelListener();
    }

    private void initGoButtonListener() {
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TermValidator.isValidTerm(termTextField.getText())) {
                    articleController.onEventUpdate(termTextField.getText().trim());
                } else {
                    showAllowedCharacters();
                }
            }
        });
    }

    private void showAllowedCharacters() {
        JOptionPane.showMessageDialog(null, "El término ingresado está en un formato incorrecto. Sólo se permiten letras de a-Z.", "Formato Incorrecto", JOptionPane.ERROR_MESSAGE);
    }


    private void initArticleModelListener() {
        articleModel.setListener(new ArticleModelListener() {
            @Override
            public void didUpdateArticle() {
                updateMeaningTextPane();
            }
        });
    }

    private void updateMeaningTextPane() {
        Article article = articleModel.getArticle();

        if (article.hasMeaning()) {
            String meaningText = TextConverter.textToHtml(article.getTerm(), article.getMeaning());
            meaningTextPane.setText(meaningText);
        } else {
            meaningTextPane.setText("No results.");
        }
    }

}

