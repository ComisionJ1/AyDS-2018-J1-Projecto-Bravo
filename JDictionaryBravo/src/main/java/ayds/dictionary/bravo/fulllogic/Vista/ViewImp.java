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
                                 @Override public void actionPerformed(ActionEvent e) {
                                   controller.onEventUpdate(termTextField.getText());
                                 }
                               }
    );

    articleModel.setListener(new ArticleModelListener() {
      @Override
      public void didUpdateArticle() {
        updateMeaningTextPane();
      }
    });
  }

  private void updateMeaningTextPane(){
    TextConverter textConverter = new TextConvertImp();
    Article article=articleModel.getArticle();
    String meaningText = textConverter.textToHtml(article.getTerm(),article.getMeaning());
    meaningTextPane.setText(meaningText);
  }

}

