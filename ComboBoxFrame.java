
//import java.awt.FlowLayout; // Importa o layout de fluxo
//import java.awt.event.ItemListener; // Importa o listener de eventos para itens
//import java.awt.event.ItemEvent; // Importa a classe de eventos de itens
//import javax.swing.JFrame; // Importa a classe para criar uma janela
//import javax.swing.JLabel; // Importa a classe para criar um rótulo
//import javax.swing.JComboBox; // Importa a classe para criar uma combo box
//import javax.swing.Icon; // Importa a interface para ícones
//import javax.swing.ImageIcon; // Importa a classe para ícones de imagem
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // Cria uma combo box para os nomes das imagens
   private final JLabel label; // Cria um rótulo para exibir o ícone selecionado

   // Nomes dos arquivos de imagem
   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};

   // Cria um array de ícones a partir dos arquivos de imagem
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   // Construtor da classe ComboBoxFrame que adiciona a JComboBox à JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout da janela como fluxo

      // Inicializa a JComboBox com os nomes das imagens
      imagesJComboBox = new JComboBox<String>(names); 
      imagesJComboBox.setMaximumRowCount(3); // Limita a exibição a três itens

      // Adiciona um listener para detectar mudanças de seleção na JComboBox
      imagesJComboBox.addItemListener(
         new ItemListener() // Classe anônima que implementa ItemListener
         {
            // Método que trata o evento da JComboBox
            @Override
            public void itemStateChanged(ItemEvent event)
            {
               // Verifica se um item foi selecionado
               if (event.getStateChange() == ItemEvent.SELECTED)
                  // Define o ícone do rótulo com base no índice selecionado
                  label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
            } 
         } // Fim da classe anônima
      ); // Fim da chamada para addItemListener

      add(imagesJComboBox); // Adiciona a JComboBox à JFrame
      label = new JLabel(icons[0]); // Cria um rótulo com o primeiro ícone
      add(label); // Adiciona o rótulo à JFrame
   }
} // Fim da classe ComboBoxFrame

