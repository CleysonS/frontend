// Fig. 12.19: RadioButtonFrame.java
// Creating radio buttons using ButtonGroup and JRadioButton.
//import java.awt.FlowLayout; // Importa o layout que organiza componentes em uma linha.
//import java.awt.Font; // Importa a classe Font para manipulação de fontes.
import java.awt.*;

//import java.awt.event.ItemListener; // Importa a interface para ouvir eventos de itens.
//import java.awt.event.ItemEvent; // Importa a classe para eventos de itens.
import java.awt.event.*;


//import javax.swing.JFrame; // Importa a classe JFrame para criar a janela.
//import javax.swing.JTextField; // Importa a classe JTextField para campo de texto.
//import javax.swing.JRadioButton; // Importa a classe JRadioButton para botões de rádio.
//import javax.swing.ButtonGroup; // Importa a classe ButtonGroup para agrupar botões de rádio.
import javax.swing.*;

public class RadioButtonFrame extends JFrame 
{ // inicio do bloco de codigo
   private JTextField textField; // Campo de texto para exibir as alterações de fonte.
   private Font plainFont; // Fonte para texto normal.
   private Font boldFont; // Fonte para texto em negrito.
   private Font italicFont; // Fonte para texto em itálico.
   private Font boldItalicFont; // Fonte para texto em negrito e itálico.
   private JRadioButton plainJRadioButton; // Botão de rádio para texto normal.
   private JRadioButton boldJRadioButton; // Botão de rádio para texto em negrito.
   private JRadioButton italicJRadioButton; // Botão de rádio para texto em itálico.
   private JRadioButton boldItalicJRadioButton; // Botão de rádio para texto em negrito e itálico.
   private ButtonGroup radioGroup; // Grupo para gerenciar os botões de rádio.

   // Construtor da classe RadioButtonFrame que adiciona os JRadioButtons ao JFrame
   public RadioButtonFrame()
   {
      super("RadioButton Test"); // Define o título da janela.
      setLayout(new FlowLayout()); // Definida a saida do layout da janela como FlowLayout.

      textField = new JTextField("Watch the font style change", 25); // Cria um campo de texto com uma mensagem inicial.
      add(textField); // Adiciona o campo de texto à janela.

      // Criação dos botões de rádio
      plainJRadioButton = new JRadioButton("Plain", true); // Botão para texto normal (selecionado por padrão).
      boldJRadioButton = new JRadioButton("Bold", false); // Botão para texto em negrito.
      italicJRadioButton = new JRadioButton("Italic", false); // Botão para texto em itálico.
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false); // Botão para texto em negrito e itálico.
      add(plainJRadioButton); // Adiciona o botão de texto normal à janela.
      add(boldJRadioButton); // Adiciona o botão de texto em negrito à janela.
      add(italicJRadioButton); // Adiciona o botão de texto em itálico à janela.
      add(boldItalicJRadioButton); // Adiciona o botão de texto em negrito e itálico à janela.

      // Criação de uma relação lógica entre os JRadioButtons
      radioGroup = new ButtonGroup(); // Cria um grupo de botões.
      radioGroup.add(plainJRadioButton); // Adiciona o botão normal ao grupo.
      radioGroup.add(boldJRadioButton); // Adiciona o botão em negrito ao grupo.
      radioGroup.add(italicJRadioButton); // Adiciona o botão em itálico ao grupo.
      radioGroup.add(boldItalicJRadioButton); // Adiciona o botão em negrito e itálico ao grupo.

      // Criação de objetos Font para diferentes estilos
      plainFont = new Font("Serif", Font.PLAIN, 14); // Fonte normal.
      boldFont = new Font("Serif", Font.BOLD, 14); // Fonte em negrito.
      italicFont = new Font("Serif", Font.ITALIC, 14); // Fonte em itálico.
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Fonte em negrito e itálico.
      textField.setFont(plainFont); // Define a fonte padrão do campo de texto.

      // Registro de eventos para os JRadioButtons
      plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont)); // Adiciona um listener para o botão normal.
      boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont)); // Adiciona um listener para o botão em negrito.
      italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont)); // Adiciona um listener para o botão em itálico.
      boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont)); // Adiciona um listener para o botão em negrito e itálico.
   } 

   // Classe interna privada para lidar com eventos dos botões de rádio
   private class RadioButtonHandler implements ItemListener 
   {
      private Font font; // Fonte associada a este listener.

      public RadioButtonHandler(Font f) // Construtor que recebe a fonte.
      {
         font = f; // Atribui a fonte ao atributo.
      } 
   
      // Método que lida com eventos de seleção de botão
      @Override
      public void itemStateChanged(ItemEvent event) // Método chamado quando o estado do item muda.
      {
         textField.setFont(font); // Altera a fonte do campo de texto para a fonte associada.
      } 
   } 
} // Fim do bloco de codigo da  classe RadioButtonFrame 
