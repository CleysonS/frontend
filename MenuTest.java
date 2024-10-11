import javax.swing.*; // Importa a biblioteca Swing para criar interfaces gráficas

public class MenuTest { // Início do bloco da classe MenuTest
   public static void main(String[] args) { // Método principal, ponto de entrada do programa
      MenuFrame menuFrame = new MenuFrame(); // Cria uma instância da classe MenuFrame
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela (sair do aplicativo)
      menuFrame.setSize(500, 200); // Define o tamanho da janela (largura de 500 pixels e altura de 200 pixels)
      menuFrame.setVisible(true); // Torna a janela visível
   } 
} // Fim do bloco de codigo da  classe MenuTest
