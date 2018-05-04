package ayds.dictionary.bravo.Model;

public class Source {

   public static final int WIKIPEDIA = 1;

   public static String getSource(int source){
       switch (source){
           case 1: return "WIKIPEDIA";
       }
       return "emaNoNosMates Aca tiramos excepcion?";
   }
}
