package org.me;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.me.Main;

public class LoginFrame extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private JButton btnRecuperarSenha;
    private JButton btnRegistrar;

    public LoginFrame() {
        super("Login");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Rótulo e campo de usuário
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Usuário:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtUsuario = new JTextField(20);
        add(txtUsuario, gbc);

        // Rótulo e campo de senha
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSenha = new JPasswordField(20);
        add(txtSenha, gbc);

        // Botão Login
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });
        add(btnLogin, gbc);

        // Botão Recuperar Senha
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        btnRecuperarSenha = new JButton("Recuperar Senha");
        btnRecuperarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirRecuperarSenha();
            }
        });
        add(btnRecuperarSenha, gbc);

        // Botão Registrar
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirRegistro();
            }
        });
        add(btnRegistrar, gbc);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250); // Aumentei a altura para caber os novos botões
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void validarLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Usuário e senha não podem estar vazios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } else if (usuario.equals("admin") && senha.equals("adm123")) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!", "Login", JOptionPane.INFORMATION_MESSAGE);
            abrirMain();
            dispose(); // Fecha a janela de login após o login bem-sucedido
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirMain() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

    private void abrirRecuperarSenha() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RecuperarSenhaFrame();
            }
        });
    }

    private void abrirRegistro() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuarioFrame();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame();
            }
        });
    }
}
