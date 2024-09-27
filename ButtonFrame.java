// Fig. 12.15: ButtonFrame.java
// Command buttons and action events.
import java.awt.FlowLayout;// formadas das camadas dos layout
import java.awt.event.ActionListener; // estrutura da ação do boão
import java.awt.event.ActionEvent;
import javax.swing.JFrame; // fornece a estrutra do layout  alinhamento 
import javax.swing.JButton;// fornece os botões
import javax.swing.Icon;// forneced as imagem com icon da tela
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame 
{
   private final JButton plainJButton; // button with just text
   private final JButton fancyJButton; // botao do icon

   // ButtonFrame adds JButtons to JFrame
   public ButtonFrame()
   {
      super("Teste Botões");
      setLayout(new FlowLayout()); 

      plainJButton = new JButton("Plain Button"); // texto do Botao
      add(plainJButton); // adicionando plainJButton para JFrame

      Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
      Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
      fancyJButton = new JButton("Fancy Button", bug1); // injetando a imagem
      fancyJButton.setRolloverIcon(bug2); // definido a imagem na sobreposicao, quando passando o mouse.
      add(fancyJButton); // adicionando  fancyJButton para  JFrame

      // criacao e declarando uma classe buttonHandler
      ButtonHandler handler = new ButtonHandler();
      fancyJButton.addActionListener(handler);// invocando o operacao actionListener 
      plainJButton.addActionListener(handler);
   }

   // classe interna para manipulação de eventos de botão ActionListener
   private class ButtonHandler implements ActionListener 
   {
      // handle evento do botao
      @Override // sobrescrever o codigo
      public void actionPerformed(ActionEvent event)
      {
         JOptionPane.showMessageDialog(ButtonFrame.this, String.format(// vai apresentar uma mensagem o metodo showMessageDialog
            "You pressed: %s", event.getActionCommand()));// vai apresentar o texto com formatacao, com virgula esta separando o parametro 
      }
   } 
} // fim do bloco de codigo  classe ButtonFrame


