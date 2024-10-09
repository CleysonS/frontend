import java.awt.*; // Importa o layout de fluxo para organizar componentes na janela
import javax.swing.event.*; // Importa o listener para eventos de seleção de lista
import javax.swing.* ;// Importa a classe para gerenciamento de seleção

public class ListFrame extends JFrame 
{
   private final JList<String> colorJList; // Declara uma lista para exibir nomes de cores


   private static final String[] colorNames = {"Black", "Blue", "Cyan",
   "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
   "Orange", "Pink", "Red", "White", "Yellow"}; // Array vetores de nomes de cores
private static final Color[] colors = {Color.BLACK, Color.BLUE,
   Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
   Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
   Color.RED, Color.WHITE, Color.YELLOW}; // Array de cores correspondentes

   private final JList<String> sizeJList;
   private static final String[] sizeNames = {"Small","Medium", "Big"};



   // Construtor ListFrame adiciona um JScrollPane contendo JList à JFrame
   public ListFrame()
   {
      super("List Test"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout

      colorJList = new JList<String>(colorNames); // Cria uma JList com os nomes das cores
      colorJList.setVisibleRowCount(5); // Define que cinco linhas devem ser visíveis de cada vez
      
      // Não permite seleções múltiplas na lista
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Adiciona um JScrollPane que contém a JList à janela
      add(new JScrollPane(colorJList));

      // Adiciona um listener para eventos de seleção na lista
      colorJList.addListSelectionListener(
         new ListSelectionListener() // Classe interna anônima
         {   
            // Manipula eventos de seleção da lista
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               // Altera a cor de fundo da janela com base no item selecionado
               getContentPane().setBackground(
                  colors[colorJList.getSelectedIndex()]);
            } 
         } 
      ); 

      sizeJList = new JList<String>(sizeNames);
      sizeJList.setVisibleRowCount(3);
      sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      add(new JScrollPane(sizeJList));

      sizeJList.addListSelectionListener(
         new ListSelectionListener()
         {
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               switch (sizeJList.getSelectedIndex()) {
                  case 0:
                     setSize(350, 150);
                     break;

                  case 1:
                     setSize(550, 350);
                     break;

                  case 2:
                     setSize(750, 550);
                     break;

                  default:
                     setSize(350,150);
                     break;
               }
            } 
         } 
      ); 
   } 
} // Fim do bloco de codigo da  classe ListFrame



