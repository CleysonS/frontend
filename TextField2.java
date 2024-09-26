import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextField2 extends JFrame  // declaração da classe TextFielFrame esta herdando do JFrame
{ // inicio do bloco de codigo da classe TExtFielFrame
  
   private final JTextField textField2; // text field with text
  

   // construtor
   public TextField2()
   {//inicio do bloco de codigo do construtor TextFielFrame
      super("Testing JTextField and JPasswordField");// definição do titulo da janela 
      setLayout(new FlowLayout());

 

      // construtor textfield definido o texto
      textField2 = new JTextField("Enter text here");
      add(textField2); // add textField2 to JFrame

 

      // manipulador dos campos de texto 
      TextFieldHandler handler = new TextFieldHandler(); //declaração de variaveis é construtor TextFieldHandler
    
      textField2.addActionListener(handler);

   } // fim do bloco de codigo do construtor TextFieldFrame

   
   private class TextFieldHandler implements ActionListener 
   {
      // New ActionListerner, injetar ou implantar o ActionListener
      @Override // sobreescreve  e altera o codigo 
      public void actionPerformed(ActionEvent event)// sobrescrever o objeto o metodo actioPerformed
      {
         String string = ""; // variavel string com o tipo String atribuido um texto vazio
         
         // user pressed Enter in JTextField textField2
          if (event.getSource() == textField2)
            string = String.format("textField2: %s",
               event.getActionCommand());

     

         // Apresentação a mensagem 
         JOptionPane.showMessageDialog(null, string); 
      } 
   } // fim do bloco de codigo da classe privada 

   public static void main(String[] args)
   { //inicio do bloco de codigo do metodo
      // declarando um novo objeto.
      TextFieldFrame textField2 = new TextFieldFrame(); 
      textField2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// invocando a JFrame a operação de fechamento padrão.
      textField2.setSize(350, 100); //definido o tamanho e lagura
      textField2.setVisible(true); // visibilidade verdadeira
   } // fim do bloco de codigo do metodo
} // fim do bloco de codigo da classe
