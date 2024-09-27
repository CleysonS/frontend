// importação da biblioteca javax do componente swing e Jframe
import javax.swing.JFrame;
//declarando a classe ButtonTest
public class ButtonTest  
{// inicio do bloco de codigo da classe
// declaração do metodo main
   public static void main(String[] args)
   { //inicio do bloco de codigo do metodo
      //declaração um tipo do arquivo um variavel um novo objeto. 
      ButtonFrame buttonFrame = new ButtonFrame();
      // invocano a operação de fechamento padrão 
      buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // invocando a operação do tamanho do botoes
      buttonFrame.setSize(275, 110); 
      // invocando a visibilidade do botão
      buttonFrame.setVisible(true); 
   } //fim do bloco de codigo do metodo
} //fim do bloco de codigo do classe

