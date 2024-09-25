
// importando a biblioteca JFrame
import javax.swing.JFrame;

public class TextFieldTest
{// inicio do bloco de codigo da classe
   public static void main(String[] args)
   { //inicio do bloco de codigo do metodo
      // declarando um novo objeto.
      TextFieldFrame textFieldFrame = new TextFieldFrame(); 
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// invocando a JFrame a operação de fechamento padrão.
      textFieldFrame.setSize(350, 100); //definido o tamanho e lagura
      textFieldFrame.setVisible(true); // visibilidade verdadeira
   } // fim do bloco de codigo do metodo
}// fim do bloco de codigo da classe

