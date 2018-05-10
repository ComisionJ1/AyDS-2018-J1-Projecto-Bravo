package ayds.dictionary.bravo.View;

import ayds.dictionary.bravo.Controller.ArticleController;
import ayds.dictionary.bravo.Model.*;
import ayds.dictionary.bravo.Model.Exception.UnallowedCharacterException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ArticleViewImp implements ArticleView {
    private ArticleController articleController;
    private ArticleModel articleModel;
    private ErrorHandler errorHandler;
    private JTextField termTextField;
    private JButton goButton;
    protected JPanel contentPane;
    private JTextPane meaningTextPane;
    private JLabel sourceLabel;
    private JLabel loadingBarLabel;

    ArticleViewImp(ArticleController articleController, ArticleModel articleModel) {
        this.articleController = articleController;
        this.articleModel = articleModel;
        errorHandler = ErrorHandlerModule.getInstance().getErrorHandler();
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
            public void actionPerformed(ActionEvent e) {
                try {
                    if (TermValidator.isTermValid(termTextField.getText())) {
                        disableSearch();
                        articleController.onEventUpdate(termTextField.getText().trim());
                    }
                } catch (UnallowedCharacterException e1) {
                    articleModel.getErrorHandler().hasError(e1);
                }
            }
        });
    }

    private void disableSearch() {
        goButton.setEnabled(false);
        meaningTextPane.setText("");
        loadingBarLabel.setVisible(true);
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
            sourceLabel.setText(article.getSource().toString());
        } else {
            meaningTextPane.setText("No results.");
            sourceLabel.setText("");
        }
        enableSearch();
    }

    private void enableSearch() {
        goButton.setEnabled(true);
        loadingBarLabel.setVisible(false);
    }

    private void initErrorHandlerListener() {
        articleModel.getErrorHandler().setErrorListener(new ErrorHandlerListener() {
            @Override
            public void errorEvent(Exception e) {
                ViewErrorHandler.showError(e.getMessage());
            }
        });

    }

}

