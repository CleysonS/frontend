//importação das bibliotecas

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Classe que herda de JFrame para criar a janela principal com menus
public class MenuFrame extends JFrame 
{
   // Array de cores que podem ser selecionadas
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};   
   
   // Itens de menu para cores, fontes e estilos
   private final JRadioButtonMenuItem[] colorItems; 
   private final JRadioButtonMenuItem[] fonts; 
   private final JCheckBoxMenuItem[] styleItems; 
   private final JLabel displayJLabel; // JLabel para exibir texto
   private final ButtonGroup fontButtonGroup; // Gerencia itens de menu de fonte
   private final ButtonGroup colorButtonGroup; // Gerencia itens de menu de cor
   private int style; // Usado para definir o estilo da fonte

   // Construtor sem argumentos para configurar a GUI
   public MenuFrame()
   {
      super("Using JMenus");     

      // Criação do menu "File"
      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic('F'); // Define a tecla de atalho 'F'

      // Criação do item de menu "About..."
      JMenuItem aboutItem = new JMenuItem("About...");
      aboutItem.setMnemonic('A'); // Define a tecla de atalho 'A'
      fileMenu.add(aboutItem); // Adiciona o item ao menu
      // Adiciona ActionListener para o item "About..."
      aboutItem.addActionListener(new ActionListener() 
      {  
         @Override
         public void actionPerformed(ActionEvent event)
         {
            // Exibe uma caixa de diálogo com informações sobre o aplicativo
            JOptionPane.showMessageDialog(MenuFrame.this,
               "This is an example\nof using menus",
               "About", JOptionPane.PLAIN_MESSAGE);
         } 
      }); 

      // Criação do item de menu "Exit"
      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic('x'); // Define a tecla de atalho 'x'
      fileMenu.add(exitItem); // Adiciona o item ao menu
      // Adiciona ActionListener para o item "Exit"
      exitItem.addActionListener(new ActionListener() 
      {  
         @Override
         public void actionPerformed(ActionEvent event)
         {
            System.exit(0); // Encerra a aplicação
         } 
      }); 

      // Criação da barra de menus e adição do menu "File"
      JMenuBar bar = new JMenuBar(); 
      setJMenuBar(bar); 
      bar.add(fileMenu); 

      // Criação do menu "Format"
      JMenu formatMenu = new JMenu("Format");
      formatMenu.setMnemonic('r'); // Define a tecla de atalho 'r'

      // Lista de cores
      String[] colors = {"Black", "Blue", "Red", "Green"};

      // Criação do submenu "Color"
      JMenu colorMenu = new JMenu("Color");
      colorMenu.setMnemonic('C'); // Define a tecla de atalho 'C'

      // Criação dos itens de menu de botão de rádio para cores
      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); // Gerencia as cores
      ItemHandler itemHandler = new ItemHandler(); // Manipulador para cores

      // Adiciona itens de cor ao submenu
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = new JRadioButtonMenuItem(colors[count]);
         colorMenu.add(colorItems[count]);
         colorButtonGroup.add(colorItems[count]); // Adiciona ao grupo
         colorItems[count].addActionListener(itemHandler); // Adiciona manipulador
      }

      colorItems[0].setSelected(true); // Seleciona a primeira cor

      formatMenu.add(colorMenu); // Adiciona o menu de cores ao menu de formato
      formatMenu.addSeparator(); // Adiciona um separador

      // Lista de nomes de fontes
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Font");
      fontMenu.setMnemonic('n'); // Define a tecla de atalho 'n'

      // Criação dos itens de menu de botão de rádio para fontes
      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup(); // Gerencia as fontes

      // Adiciona itens de fonte ao submenu
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]);
         fontButtonGroup.add(fonts[count]); // Adiciona ao grupo
         fonts[count].addActionListener(itemHandler); // Adiciona manipulador
      } 

      fonts[0].setSelected(true); // Seleciona a primeira fonte
      fontMenu.addSeparator(); // Adiciona um separador

      // Lista de nomes de estilos
      String[] styleNames = {"Bold", "Italic"};
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); // Manipulador de estilo

      // Adiciona itens de estilo ao submenu de fonte
      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);
         fontMenu.add(styleItems[count]);
         styleItems[count].addItemListener(styleHandler); // Adiciona manipulador
      }

      formatMenu.add(fontMenu); // Adiciona o menu de fontes ao menu de formato
      bar.add(formatMenu); // Adiciona o menu de formato à barra de menus
     
      // Configura o JLabel para exibir texto
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]); // Cor inicial
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72)); // Fonte inicial

      getContentPane().setBackground(Color.CYAN); // Define a cor de fundo
      add(displayJLabel, BorderLayout.CENTER); // Adiciona o JLabel ao centro da janela
   } // end MenuFrame constructor

   // Classe interna para lidar com eventos de ação dos itens do menu
   private class ItemHandler implements ActionListener 
   {
      // Processa seleções de cor e fonte
      @Override
      public void actionPerformed(ActionEvent event)
      {
         // Processa seleção de cor
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]); // Atualiza a cor do texto
               break;
            } 
         } 

         // Processa seleção de fonte
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72)); // Atualiza a fonte
            }
         }

         repaint(); // Redesenha a aplicação
      } 
   } // end class ItemHandler

   // Classe interna para lidar com eventos de itens dos checkboxes
   private class StyleHandler implements ItemListener 
   {
      // Processa seleções de estilo de fonte
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); // Fonte atual
         Font font; // Nova fonte baseada nas seleções do usuário

         // Determina quais checkboxes estão selecionados e cria a nova fonte
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font); // Atualiza a fonte do JLabel
         repaint(); // Redesenha a aplicação
      } 
   } // fim do bloco de codigo da classe StyleHandler
} // fim do bloco de codigo da classe MenuFrame


