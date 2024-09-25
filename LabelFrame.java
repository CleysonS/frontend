// linhas abaixo está importando um componente de cada modulo  bibliotecas do java.

import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images

//esta declarando a classe LabelFrame esta herdando do componente JFrame
public class LabelFrame extends JFrame 
// inciando o bloco de codigo da classe JFrame
{
   // declaração de variaveis , variaveis privadas , private nao exporta a variavel, todas ela são utilizadas somente para essa classe.
   private final JLabel label1; // final é utilizado somente leitura, Jalbel é tipo da variavel, label1 é a variavel criada 
   private final JLabel label2; // JLabel constructed with text and icon
   private final JLabel label3; // JLabel with added text and icon

   // LabelFrame construtor adicionando  JLabels e JFrame, nao poder ser privado e protegido. mesmo nome da classe e nome do arquivo
   public LabelFrame()
   //inicio do bloco de codigo do construtor
   {
      // é um metodo super significa o titulo da janela , quer dizer o superior da tela. dentro do paramentro com texto string com aspas duplas 
      super("Testing JLabel");
      setLayout(new FlowLayout()); // vai definir o desenho do layout, a saida das camadas.

      // label1 esta recebendo o objeto Jlabel injetando o parametro incluindo um texto entre aspas duplas.
      label1 = new JLabel("Label with text");
      //  invocando e definido um texto da dica, quando colocar o mouse em cima vai aparecer o texto.
      label1.setToolTipText("This is label1");
      // adicionado e mostrar na saida do layout.
      add(label1); 

      // declarando variavel bug , tipo icon esta recebendo um novo objeto com imagem icon, esta sendo enviando uma parametro, vai coletar uma e apropria a classe LabelFrame vamos coletar o recurso, bug1.png
      // consegue enviar para dentro da imagem,
      Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
      // esta declarando uma variavel,o texto dentro da declaração de paramentroa , virgula serve como separador de parametro. 
      label2 = new JLabel("Label with text and icon", bug, 
      // SwingConstants formação de alinhamento   
      SwingConstants.LEFT);
      label2.setToolTipText("This is label2");
      add(label2); // add label2 to JFrame

      label3 = new JLabel(); // Declaração de variaveis 
      label3.setText("Label with icon and text at bottom");
      label3.setIcon(bug); // estou enviando o bug 
      label3.setHorizontalTextPosition(SwingConstants.CENTER);// definido formação do alinhamento ao centro
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);// definiddo a formação e criando um botão 
      label3.setToolTipText("This is label3");//  definido a dica do texto
      add(label3); // adicionando  label3 para JFrame
      //fim do bloco de codigo do metodo da classe
   } 
} // fim do bloco de codigo da classe LabelFrame

