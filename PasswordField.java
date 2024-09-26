
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class PasswordField extends JFrame  // declaração da classe TextFielFrame esta herdando do JFrame
{ // inicio do bloco de codigo da classe TExtFielFrame

   private final JPasswordField passwordField; // password field with text

   // construtor
   public PasswordField()
   {//inicio do bloco de codigo do construtor TextFielFrame
      super("Testing JTextField and JPasswordField");// definição do titulo da janela 
      setLayout(new FlowLayout());

     

      // construtor passwordfield  e forma de bolinhas parametro de texto em mascara de senha 
      passwordField = new JPasswordField("Hidden text");
      add(passwordField); // adiciona passwordField do JFrame

      // manipulador dos campos de texto 
      TextFieldHandler handler = new TextFieldHandler(); //declaração de variaveis é construtor TextFieldHandler
      passwordField.addActionListener(handler);
   } // fim do bloco de codigo do construtor TextFieldFrame

   
   private class TextFieldHandler implements ActionListener 
   {
      // New ActionListerner, injetar ou implantar o ActionListener
      @Override // sobreescreve  e altera o codigo 
      public void actionPerformed(ActionEvent event)// sobrescrever o objeto o metodo actioPerformed
      {
         String string = ""; // variavel string com o tipo String atribuido um texto vazio
       
         
         if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         // Apresentação a mensagem 
         JOptionPane.showMessageDialog(null, string); 
      } 
   } // fim do bloco de codigo da classe privada 
   
   public static void main(String[] args)
   { //inicio do bloco de codigo do metodo
      // declarando um novo objeto.
      TextFieldFrame passwordField = new TextFieldFrame(); 
      passwordField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// invocando a JFrame a operação de fechamento padrão.
      passwordField.setSize(350, 100); //definido o tamanho e lagura
      passwordField.setVisible(true); // visibilidade verdadeira
   }

} // fim do bloco de codigo da classe

