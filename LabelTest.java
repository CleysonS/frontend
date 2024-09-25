
// A linha abaixo importara o componente JFrame do módulo swing da biblioteca (pacote) javax
import javax.swing.JFrame;

//A linha abaixo está declarando a classe LabelTest
public class LabelTest 
// alinha abaixo esta  executando o bloco de classe LabelTest
{
   //linha que abaixo esta declarando o metodo main
   public static void main(String[] args)
   
   { 
      //esta declarando a variavel labelframe  atribuindo um novo objeto
      LabelFrame labelFrame = new LabelFrame(); 
      // esta invocando o metodo operação fechamento padrão
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // definido o tamanho
      labelFrame.setSize(260, 180); 
      // definido a visibilidade verdadeira.
      labelFrame.setVisible(true); 
      
      // encerramento do bloco do metodo
   } 
} // encerramento do bloco de classe.

