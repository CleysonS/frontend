import javax.swing.*; // Importa todas as classes do pacote javax.swing
public class MultipleSelectionTest
{
   public static void main(String[] args)
   { // início do bloco de código da classe MultipleSelectionTest
      // Cria uma instância de MultipleSelectionFrame estanciando o obejto 
      MultipleSelectionFrame multipleSelectionFrame =
         new MultipleSelectionFrame(); 
         
      // Define o comportamento padrão ao fechar a janela: sair da aplicação
      multipleSelectionFrame.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE);
         
      // Define o tamanho da janela (largura, altura)
      multipleSelectionFrame.setSize(500, 250); 
      
      // Torna a janela visível para o usuário
      multipleSelectionFrame.setVisible(true); 
   } 
} // fim do bloco de código da classe MultipleSelectionTest
