package br.com.mercado.view;

import br.com.mercado.controller.LoginController;
import br.com.mercado.model.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtUsuario = new JTextField(20);
    private JPasswordField txtSenha = new JPasswordField(20);
    private JButton btnLogin = new JButton("Login");
    private LoginController loginController;

    public LoginView(){
        setTitle("Login - DuPovo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        add(new JLabel("Usuário"));
        add(txtUsuario);
        add(new JLabel());
        add(txtSenha);
        add(btnLogin);
        setVisible(true);

        btnLogin.addActionListener(e -> {
            String login = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());
            LoginController controller = new LoginController();
            Usuario usuarioLogado = controller.autenticar(login, senha);
            if (usuarioLogado != null) {
                String mensagem = "Bem Vindo - Nexus ERP - DuPovo " + usuarioLogado.getNome() + " (" + usuarioLogado.getCargo() + ")!";
                
                // Corrigido aqui para usar 'mensagem' em português
                JOptionPane.showMessageDialog(null, mensagem);
                
                // Fecha a tela de login
                this.dispose();
                
                // Abre a TelaPrincipal
                br.com.nexus.dupovo.erp.view.TelaPrincipal telaPrincipal = new br.com.nexus.dupovo.erp.view.TelaPrincipal();
                telaPrincipal.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Login inválido. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}