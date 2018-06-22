package ayds.dictionary.bravo.View;

import ayds.dictionary.bravo.Controller.ArticleController;
import ayds.dictionary.bravo.Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class ArticleViewImp implements ArticleView {
    private ArticleController articleController;
    private ArticleModel articleModel;
    private JTextField termTextField;
    private JButton goButton;
    protected JPanel contentPane;
    private JTextPane meaningTextPane;
    private JLabel sourceLabel;
    private JLabel loadingBarLabel;

    ArticleViewImp(ArticleController articleController, ArticleModel articleModel) {
        this.articleController = articleController;
        this.articleModel = articleModel;
        meaningTextPane.setContentType("text/html");
        loadingBarLabel.setVisible(false);

        initListeners();
    }

    private void initListeners() {
        initGoButtonListener();
        initArticleModelListener();
        initErrorHandlerListener();
    }

    private void initGoButtonListener() {
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    if (TermValidator.isTermValid(termTextField.getText())) {
                        disableSearch();
                        articleController.onEventUpdate(termTextField.getText().trim());
                    }
                } catch (UnallowedCharacterException e) {
                    showError(e);
                }
            }
        });
    }

    private void disableSearch() {
        goButton.setEnabled(false);
        meaningTextPane.setText("");
        loadingBarLabel.setVisible(true);
    }

    private void showError(Exception e) {
        ViewErrorHandler.showError(e.getMessage());
    }

    private void initArticleModelListener() {
        articleModel.setListener(new ArticleModelListener() {
            @Override
            public void didUpdateArticles() {
                updateMeaningTextPane();
            }
        });
    }

    private void updateMeaningTextPane() {
        List<Article> articles = articleModel.getArticles();

        String result="";

        for (Article article: articles) {
            if (article.hasMeaning()) {
                String meaningText = TextConverter.textToHtml(article.getTerm(), article.getMeaning());
                result=result+meaningText+"<br> SOURCE: "+article.getSource().toString()+"<br><br>";
                //meaningTextPane.setText(meaningText);
                //sourceLabel.setText(article.getSource().toString());
            } else {
                //meaningTextPane.setText("No results.");
                result=result+"No results.<br> SOURCE: "+article.getSource().toString()+"<br><br>";
            }
        }
        meaningTextPane.setText(result);
        enableSearch();
    }

    private void enableSearch() {
        goButton.setEnabled(true);
        loadingBarLabel.setVisible(false);
    }

    private void initErrorHandlerListener() {
        articleModel.setErrorListener(new ErrorHandlerListener() {
            @Override
            public void errorEvent(Exception e) {
                showError(e);
            }
        });
    }

}

