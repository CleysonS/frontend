
import java.awt.*;  // Importa todas as classes do pacote javax.awt
import java.awt.event.*; // Importa todas as classes do pacote java.awt.event
import javax.swing.*;  // Importa todas as classes do pacote javax.swing

public class MultipleSelectionFrame extends JFrame 
{//inicio do bloco de codigo da classe
   // Declaração dos componentes da interface
   private final JList<String> colorJList; // Lista para armazenar nomes de cores
   private final JList<String> copyJList; // Lista para armazenar os nomes copiados
   private final JList<String> fruitJList; 
   private final JList<String> copyJFruits;
   private JButton copyJButton; // Botão para copiar nomes selecionados
   private JButton copyFruitButton; // Botão para copiar nomes de frutas selecionados
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"}; // Nomes das cores
      private static final String[] fruitNames ={"Maça","Banana","Laranja","Morango","Melancia","Uva"};
  
      // Construtor da classe MultipleSelectionFrame
   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout como FlowLayout

      // Criação da lista de cores
      colorJList = new JList<String>(colorNames); // Inicializa a lista com os nomes de cores
      colorJList.setVisibleRowCount(5); // Exibe cinco linhas
      colorJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Permite seleção múltipla
      add(new JScrollPane(colorJList)); // Adiciona a lista em um JScrollPane para rolagem

      // Criação do botão para copiar
      copyJButton = new JButton("Copy >>>"); 
      copyJButton.addActionListener(
         new ActionListener() // Classe interna anônima que escuta o botão
         {  
            // Manipulador de evento do botão
            @Override //sobreescrever
            public void actionPerformed(ActionEvent event)
            {
               // Coloca os valores selecionados na copyJList
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray(
                     new String[0])); // Converte a lista selecionada para um array e define como dados da copyJList
            }
         } 
      ); 

      add(copyJButton); // Adiciona o botão à JFrame

      fruitJList = new JList<String>(fruitNames); 
      fruitJList.setVisibleRowCount(5);
      fruitJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(fruitJList));

      copyFruitButton = new JButton("Copy Fruits >>>");
      copyFruitButton.addActionListener(
         new ActionListener() // Classe interna anônima que escuta o botão
         {  
            // Manipulador de evento do botão
            @Override // Sobrescrever
            public void actionPerformed(ActionEvent event)
            {
               // Coloca os valores selecionados na copyJList
               copyJFruits.setListData(
                  fruitJList.getSelectedValuesList().toArray(
                     new String[0]));

                  }
               } 
            ); 

            add(copyFruitButton);
      
      // Criação da lista para armazenar os nomes copiados
      copyJList = new JList<String>(); // Inicializa a lista de cópias
      copyJList.setVisibleRowCount(5); // Exibe cinco linhas
      copyJList.setFixedCellWidth(100); // Define a largura fixa das células
      copyJList.setFixedCellHeight(15); // Define a altura fixa das células
      copyJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION); // Permite seleção única
      add(new JScrollPane(copyJList)); // Adiciona a copyJList em um JScrollPane para rolagem

      copyJFruits = new JList<String>(); // Inicializa a lista de cópias
      copyJFruits.setVisibleRowCount(5); // Exibe cinco linhas
      copyJFruits.setFixedCellWidth(120); // Define a largura fixa das células
      copyJFruits.setFixedCellHeight(30); // Define a altura fixa das células
      copyJFruits.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION); // Permite seleção única
      add(new JScrollPane(copyJFruits)); // Adiciona a copyJList em um JScrollPane para rolagem
   } 
} // fim da classe MultipleSelectionFrame
