import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TeladeCadastro  extends JFrame {
    

private final JLabel lblNome;
private final JTextField txtNome;

public final JLabel lblEmail;
public final JTextField txtEmail;

public final JLabel lblSenha;
public final JPasswordField txtSenha;

public final JButton btnCadastrar;
public final JButton btnCancelar;

public final JLabel lblNotificacoes;

public TeladeCadastro() 
{
    
    super("Tela de Cadastro");
    setLayout(new GridLayout(5,1,5,5));
    
    JPanel linhaNome = new JPanel(new GridLayout(1,2));
    lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
    txtNome = new JTextField(10);
    
    linhaNome.add(lblNome);
    linhaNome.add(txtNome);

    add(linhaNome);

    JPanel linhaEmail = new JPanel(new GridLayout(1,2));
    lblEmail = new JLabel("E-mail:",SwingConstants.RIGHT);
    txtEmail = new JTextField(10);

    linhaEmail.add(lblEmail);
    linhaEmail.add(txtEmail);

    add(linhaEmail);


    JPanel linhaSenha = new JPanel(new GridLayout(1,2));
    lblSenha = new JLabel("Senha:",SwingConstants.RIGHT);
    txtSenha = new JPasswordField(10);
    
    linhaSenha.add(lblSenha);
    linhaSenha.add(txtSenha);
    
    add(linhaSenha);

    JPanel linhaBotao = new JPanel(new GridLayout(1,2));
    btnCadastrar = new JButton("Cadastrar");
    btnCancelar = new JButton("Cancelar");

    linhaBotao.add(btnCadastrar);
    linhaBotao.add(btnCancelar);

    add(linhaBotao);

    JPanel linhaNotificacao = new JPanel(new GridLayout(1,2));
    lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
    
    linhaNotificacao.add(lblNotificacoes);
    add(linhaNotificacao);

    btnCadastrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (txtNome.getText().trim().length() == 0) {
                lblNotificacoes.setText("É necessario digitar alguma coisa no campo Nome. Por favor, digite um caracter valido no campo");
                txtNome.requestFocus(null);
                return;
                
            }

            if (txtEmail.getText().trim().length() == 0) {
                lblNotificacoes.setText("É necessario digitar alguma coisa no campo E-mail. Por favor, digite um caracter valido no campo");
                txtEmail.requestFocus(null);
                return;
                
            }

            if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) {
                lblNotificacoes.setText("É necessario digitar alguma coisa no campo Senha. Por favor, digite um caracter valido no campo");
                txtSenha.requestFocus(null);
                return;
                
            }

                String strSQlCadastrar = "insert into db_senac `db_senac`, `tbl_senac`(`nome`,`email`,`senha`) values ' "+ txtNome.getText() + "','" 
                + txtEmail.getText() + "','" + String.valueOf(txtSenha.getPassword()) + "')";
                try{
                Connection conexao = MySQLConnector.conectar();
                Statement stmSqlCadastrar  = conexao.createStatement();
                stmSqlCadastrar.addBatch(strSQlCadastrar);
                stmSqlCadastrar.executeBatch();
                lblNotificacoes.setText("Cadastro realizado com sucesso!");
                } catch(Exception e) {
                    lblNotificacoes.setText("Ops! ocorreu um problema e não será possível cadastrar nesse momento. Por favor, tente novamente mais tarde");
                    System.err.println("Erro:" + e);

                }


        }
    }
    
    );

    setSize(300,300);
    setVisible(true);


}

public static void main(String[] args){
    TeladeCadastro appTeladeCadastro = new TeladeCadastro();
    appTeladeCadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);

}

}
