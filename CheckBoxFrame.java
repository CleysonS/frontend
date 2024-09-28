// Importação das bibliotecas necessárias para a criação da interface gráfica
import java.awt.FlowLayout; // Layout para organizar os componentes em linha
import java.awt.Font; // Classe para manipulação de fontes
import java.awt.event.ItemListener; // Interface para escutar eventos de seleção
import java.awt.event.ItemEvent; // Classe para eventos de seleção
import javax.swing.JFrame; // Classe para criar a janela da aplicação
import javax.swing.JTextField; // Classe para criar campos de texto
import javax.swing.JCheckBox; // Classe para criar caixas de seleção

// Criação da classe CheckBoxFrame que herda de JFrame
public class CheckBoxFrame extends JFrame 
{
   // Declaração dos componentes da interface private.
   private final JTextField textField; // Campo de texto que exibirá o texto com diferentes estilos de fonte quando selecionado 
   private final JCheckBox boldJCheckBox; // checkbox de seleção para escolher o estilo negrito
   private final JCheckBox italicJCheckBox; // checkbox de seleção para escolher o estilo itálico
   private final JCheckBox sublimCheckBox;

   // criando o Construtor da classe CheckBoxFrame
   public CheckBoxFrame()
   {
      super("JCheckBox Test"); // Definido o título da janela
      setLayout(new FlowLayout()); // Definido o layout da janela

      // Configura o JTextField e define sua fonte inicial
      textField = new JTextField("Watch the font style change", 21); // Campo de texto com uma mensagem
      textField.setFont(new Font("Serif", Font.PLAIN, 14)); // Definindo a fonte, estilo normal, tamanho 14
      add(textField); // Adiciona o campo de texto à janela

      // Cria as caixas de seleção para negrito e itálico
      boldJCheckBox = new JCheckBox("Bold"); // Caixa para selecionar o estilo negrito
      italicJCheckBox = new JCheckBox("Italic"); // Caixa para selecionar o estilo itálico
      sublimCheckBox = new JCheckBox("S");
      add(boldJCheckBox); // Adiciona a caixa de seleção de negrito à layout
      add(italicJCheckBox); // Adiciona a caixa de seleção de itálico à layout

      // Registra os ouvintes para as caixas de seleção
      CheckBoxHandler handler = new CheckBoxHandler(); // Cria uma instância do manipulador de eventos
      boldJCheckBox.addItemListener(handler); // Adiciona o ouvinte à caixa de seleção de negrito
      italicJCheckBox.addItemListener(handler); // Adiciona o ouvinte à caixa de seleção de itálico
   } 

   // Classe interna privada para lidar com eventos de seleção de item
   private class CheckBoxHandler implements ItemListener 
   {
      // Método que responde a eventos das caixas de seleção
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         Font font = null; // Variável para armazenar a nova fonte

         // Determina qual combinação de caixas de seleção está marcada e cria a nova fonte
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Fonte negrito e itálico
         else if (boldJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD, 14); // Fonte apenas negrito
         else if (italicJCheckBox.isSelected())
            font = new Font("Serif", Font.ITALIC, 14); // Fonte apenas itálico
         else
            font = new Font("Serif", Font.PLAIN, 14); // Fonte normal

         // Aplica a nova fonte ao campo de texto
         textField.setFont(font); 
      } 
   }
} // Fim da classe CheckBoxFrame
