package ayds.dictionary.bravo.fulllogic.Vista;

import ayds.dictionary.bravo.fulllogic.Controlador.Controller;
import ayds.dictionary.bravo.fulllogic.Modelo.ArticleModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewImp implements View{
  private Controller controller;
  private ArticleModel articleModel;

  private JTextField textField1;
  private JButton goButton;
  protected JPanel contentPane;
  private JTextPane textPane1;

  public ViewImp(Controller controller, ArticleModel articleModel){

    this.controller=controller;


    textPane1.setContentType("text/html");
    goButton.addActionListener(new ActionListener() {
                                 @Override public void actionPerformed(ActionEvent e) {
                                   controller.getArticle(textField1.getText());
                                 }
                               }
    );

    JFrame frame = new JFrame("Online Dictionary");
    frame.setContentPane(contentPane);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);


  }

  public void showArticle(ArticleModel article){
    TextConverter textConverter = new TextConvertImp();
    String innerText = textConverter.textToHtml(article.getTerm(),article.getMeaning());
    if (controller.isInLocalSource()) {
      textPane1.setText("[*]"+innerText);
    } else {
      textPane1.setText(innerText);
    }
  }



}

