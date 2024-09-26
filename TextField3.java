
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextField3 extends JFrame  // declaração da classe TextFielFrame esta herdando do JFrame
{ // inicio do bloco de codigo da classe TExtFielFrame

   private final JTextField textField3; // text field with text and size
 

   // construtor
   public TextField3()
   {//inicio do bloco de codigo do construtor TextFielFrame
      super(" JTextField3");// definição do titulo da janela 
      setLayout(new FlowLayout());

    

      textField3 = new JTextField("Uneditable text field", 21);
      textField3.setEditable(false); // disable editing
      add(textField3); // add textField3 to JFrame

  

      // manipulador dos campos de texto 
      TextFieldHandler handler = new TextFieldHandler(); //declaração de variaveis é construtor TextFieldHandler
    
      textField3.addActionListener(handler);

   } 

   
   private class TextFieldHandler implements ActionListener 
   {
      // New ActionListerner, injetar ou implantar o ActionListener
      @Override // sobreescreve  e altera o codigo 
      public void actionPerformed(ActionEvent event)// sobrescrever o objeto o metodo actioPerformed
      {
         String string = ""; // variavel string com o tipo String atribuido um texto vazio


         // user pressed Enter in JTextField textField3
        if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());



         // Apresentação a mensagem 
         JOptionPane.showMessageDialog(null, string); 
      } 
   } // fim do bloco de codigo da classe privada 

   public static void main(String[] args)
   { //inicio do bloco de codigo do metodo
      // declarando um novo objeto.
      TextFieldFrame textField3 = new TextFieldFrame(); 
      textField3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// invocando a JFrame a operação de fechamento padrão.
      textField3.setSize(350, 100); //definido o tamanho e lagura
      textField3.setVisible(true); // visibilidade verdadeira
   }
} // fim do bloco de codigo da classe

