import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class TeladeMenu extends JFrame {
    private final JMenu cadastroMenu;
    private final JLabel lblnomeDaTela;
    private final JMenuBar menuBar;
    private final JMenuItem novoItem;
    private final JMenuItem pesquisarItem;
    private final JMenuItem atualizarItem;
    private final JMenuItem removerItem;

    

    public TeladeMenu(){
        super("Tela de Menu");

        cadastroMenu = new JMenu("Cadastro");        
        lblnomeDaTela = new JLabel("Tela de Menu ", SwingConstants.CENTER);
        menuBar = new JMenuBar();

        novoItem = new JMenuItem("Novo");
        pesquisarItem = new JMenuItem("Pesquisar Cadastro");
        atualizarItem = new JMenuItem("Atualizar Cadastro");
        removerItem = new JMenuItem("Remover Cadastro");

      cadastroMenu.add(novoItem);
      cadastroMenu.add(pesquisarItem);
      cadastroMenu.add(atualizarItem);
      cadastroMenu.add(removerItem);

      menuBar.add(cadastroMenu);
     

      setJMenuBar(menuBar);
   

      add(lblnomeDaTela, BorderLayout.CENTER);

      novoItem.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null,"Voce clicou no menu: " + event.getActionCommand());
        }
      });
   

      pesquisarItem.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null,"Voce clicou no menu: " + event.getActionCommand());
        }
      });

      atualizarItem.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null,"Voce clicou no menu: " + event.getActionCommand());
        }
      });
   
   
      removerItem.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null,"Voce clicou no menu: " + event.getActionCommand());
        }
      });
   
    }

    public static void main(String[] args){
        TeladeMenu appTeladeMenu = new TeladeMenu();
        appTeladeMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        appTeladeMenu.setSize(200,200);
        appTeladeMenu.setVisible(true);
    }
}
