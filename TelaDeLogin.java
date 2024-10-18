import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class TelaDeLogin extends JFrame
{
    private final JLabel lblLogin;
    private final JTextField txtLogin;
    private final JLabel lblSenha;
    private final JPasswordField txtSenha;


    private final JButton btnLogar;
    private final JLabel lblNotificacoes;

 public TelaDeLogin()
 {
    super("Tela de Login");
    setLayout(new FlowLayout());

    lblLogin = new JLabel("Login: ");
    add(lblLogin);

    txtLogin = new JTextField(10);
    add(txtLogin);
    
    lblSenha = new JLabel("Senha:");
    add(lblSenha);

    txtSenha = new JPasswordField(10);
    add(txtSenha);

    btnLogar = new JButton("Login");
    add(btnLogar);

     lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);


 }

     private class ButtonHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent event ){
         try{
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + 
            txtLogin.getText() + "'and `senha` = '" + String.valueOf(txtSenha.getPassword()) + "';";
            Statement stmSqllogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqllogin.executeQuery(strSqlLogin);
            if(rstSqlLogin.next()) {
               //aqui vamos notificar o usuario que o login e senha foi encontrado
               //lblNotificacoes.setText(("conectado com sucesso!"));

            }else {
               //lblNotificacoes.setText(("Login e/ou senha não encontrado! Por favor, verifique e tente novamente."));
            }

         }catch (Exception e){
           
            System.err.println("Ops! Deu ruim, se liga no erros" + e);
         } 

      }

     }
 public static void main(String[] args){
   
   TelaDeLogin appTelaDeLogin = new TelaDeLogin();
   appTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   appTelaDeLogin.setSize(200,140);
   appTelaDeLogin.setVisible(true);

   
  }


    

}