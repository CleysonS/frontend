
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextField1 extends JFrame  // declaração da classe TextFielFrame esta herdando do JFrame
{ // inicio do bloco de codigo da classe TExtFielFrame
   private final JTextField textField1; // private nao pode usar, final nao pode modificar
   

   // construtor
   public TextField1()
   {//inicio do bloco de codigo do construtor TextFielFrame
      super("JTextField1");// definição do titulo da janela 
      setLayout(new FlowLayout());

      // construtor esta criando 10 colunas
      textField1 = new JTextField(10); 
      add(textField1); // adicionando a variavel textFiel1
 



      // manipulador dos campos de texto 
      TextFieldHandler handler = new TextFieldHandler(); //declaração de variaveis é construtor TextFieldHandler
      textField1.addActionListener(handler);// adicionar escutador de ação , o parametro é o proprio handler
   
 
   } // fim do bloco de codigo do construtor TextFieldFrame

   
   private class TextFieldHandler implements ActionListener 
   {
      // New ActionListerner, injetar ou implantar o ActionListener
      @Override // sobreescreve  e altera o codigo 
      public void actionPerformed(ActionEvent event)// sobrescrever o objeto o metodo actioPerformed
      {
         String string = ""; // variavel string com o tipo String atribuido um texto vazio
         // user pressed Enter in JTextField textField1
         if (event.getSource() == textField1) // comparador dos dados  se então expressão regular  quando o evento for igual o textfiel1 a é executando o comando abaixo, utilizando o metodo
         // format, vai formatar o texto e vai ser apresentado textfield1 %¨.
            string = String.format("textField1: %s",
               event.getActionCommand());// pegar o texto que estiver dentro do lemento que é a variavel.

        

         // Apresentação a mensagem 
         JOptionPane.showMessageDialog(null, string); 
      } 
   } 


   public static void main(String[] args)
{ //inicio do bloco de codigo do metodo
   // declarando um novo objeto.
   TextField1 textField1 = new TextField1(); 
   textField1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// invocando a JFrame a operação de fechamento padrão.
   textField1.setSize(350, 100); //definido o tamanho e lagura
   textField1.setVisible(true); // visibilidade verdadeira
} 
}

