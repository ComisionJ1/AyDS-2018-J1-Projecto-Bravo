package ayds.dictionary.bravo.View;

import ayds.dictionary.bravo.Controller.ArticleController;
import ayds.dictionary.bravo.Model.Article;
import ayds.dictionary.bravo.Model.ArticleModel;
import ayds.dictionary.bravo.Model.ArticleModelListener;
import ayds.dictionary.bravo.Model.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ArticleViewImp implements ArticleView {
    private ArticleController articleController;
    private ArticleModel articleModel;
    private JTextField termTextField;
    private JButton goButton;
    protected JPanel contentPane;
    private JTextPane meaningTextPane;
    private JLabel sourceLabel;
    private JProgressBar progressBar;

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
                if (TermValidator.isTermValid(termTextField.getText())) {
                    articleController.onEventUpdate(termTextField.getText().trim());
                } else {
                    ErrorHandler.showAllowedCharacters();
                }
            }
        });
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
            sourceLabel.setText(Source.getSource(article.getSource()));
        } else {
            meaningTextPane.setText("No results.");
            sourceLabel.setText("");
        }

    }

    public void updateProgress(int progress) {
        progressBar.setValue(progress);
    }

}

