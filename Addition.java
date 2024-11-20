// Na linha abaixo está importando a biblioteca (pacote) javax, o modulo swing e o componente JOptionPane

import javax.swing.JOptionPane; 
// Na linha 
public class Addition 
{
   // Na linha abaixo esta executando metodo main 
   public static void main(String[] args)
   {
      // Nessa linhas esta sendo declarados a varialvel firsNumber o tipo string, aonde tem operador de atribuição tem  indicador de variaveis.
      // JOptionPane estou invocando ele dentro dele existe o metodo showInputDialog invocado uma caixa de dialogo. 
    
      String firstNumber = 
         JOptionPane.showInputDialog("Digite o primeiro numero inteiro: ");
      String secondNumber =
         JOptionPane.showInputDialog("Digite o segundo numero inteiro: ");

      // Vai converter o texto de String em valores interios para uso em um cálculo
      int number1 = Integer.parseInt(firstNumber); 
      int number2 = Integer.parseInt(secondNumber);
       // somatorio de dois variaveis numero 1 e numero 2.
      int sum = number1 + number2; // add numbers

      // Vai exibir o resultado em uma caixa de diálogo de mensagem JOptionPane
      JOptionPane.showMessageDialog(null, "A soma e: " + sum, 
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
   } 
} 


