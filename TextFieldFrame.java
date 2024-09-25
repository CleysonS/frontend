
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame  // declaração da classe TextFielFrame esta herdando do JFrame
{ // inicio do bloco de codigo da classe TExtFielFrame
   private final JTextField textField1; // private nao pode usar, final nao pode modificar
   private final JTextField textField2; // text field with text
   private final JTextField textField3; // text field with text and size
   private final JPasswordField passwordField; // password field with text

   // construtor
   public TextFieldFrame()
   {//inicio do bloco de codigo do construtor TextFielFrame
      super("Testing JTextField and JPasswordField");// definição do titulo da janela 
      setLayout(new FlowLayout());

      // construtor esta criando 10 colunas
      textField1 = new JTextField(10); 
      add(textField1); // adicionando a variavel textFiel1

      // construtor textfield definido o texto
      textField2 = new JTextField("Enter text here");
      add(textField2); // add textField2 to JFrame

      // construct textfield with default text and 21 columns
      textField3 = new JTextField("Uneditable text field", 21);
      textField3.setEditable(false); // disable editing
      add(textField3); // add textField3 to JFrame

      // construtor passwordfield  e forma de bolinhas parametro de texto em mascara de senha 
      passwordField = new JPasswordField("Hidden text");
      add(passwordField); // adiciona passwordField do JFrame

      // manipulador dos campos de texto 
      TextFieldHandler handler = new TextFieldHandler(); //declaração de variaveis é construtor TextFieldHandler
      textField1.addActionListener(handler);// adicionar escutador de ação , o parametro é o proprio handler
      textField2.addActionListener(handler);
      textField3.addActionListener(handler);
      passwordField.addActionListener(handler);
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

         // user pressed Enter in JTextField textField2
         else if (event.getSource() == textField2)
            string = String.format("textField2: %s",
               event.getActionCommand());

         // user pressed Enter in JTextField textField3
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         // user pressed Enter in JTextField passwordField
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         // Apresentação a mensagem 
         JOptionPane.showMessageDialog(null, string); 
      } 
   } // fim do bloco de codigo da classe privada 

} // fim do bloco de codigo da classe

