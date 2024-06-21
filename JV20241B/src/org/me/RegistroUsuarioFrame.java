package org.me;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroUsuarioFrame extends JFrame {

    private JTextField txtNovoUsuario;
    private JPasswordField txtNovaSenha;
    private JPasswordField txtConfirmarSenha;
    private JButton btnRegistrar;

    public RegistroUsuarioFrame() {
        super("Registrar Novo Usuário");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 
        add(Box.createVerticalStrut(10)); 

        JPanel panelNovoUsuario = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNovoUsuario.add(new JLabel("Novo Usuário:"));
        txtNovoUsuario = new JTextField(30);
        txtNovoUsuario.setMinimumSize(new Dimension(100, 30));
        txtNovoUsuario.setPreferredSize(new Dimension(250, 30));
        panelNovoUsuario.add(txtNovoUsuario);
        add(panelNovoUsuario);

        JPanel panelNovaSenha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNovaSenha.add(new JLabel("Nova Senha:"));
        txtNovaSenha = new JPasswordField(30);
        txtNovaSenha.setMinimumSize(new Dimension(100, 30));
        txtNovaSenha.setPreferredSize(new Dimension(250, 30));
        panelNovaSenha.add(txtNovaSenha);
        add(panelNovaSenha);

        JPanel panelConfirmarSenha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelConfirmarSenha.add(new JLabel("Confirmar Senha:"));
        txtConfirmarSenha = new JPasswordField(30);
        txtConfirmarSenha.setMinimumSize(new Dimension(100, 30));
        txtConfirmarSenha.setPreferredSize(new Dimension(250, 30));
        panelConfirmarSenha.add(txtConfirmarSenha);
        add(panelConfirmarSenha);

        JPanel panelBtnRegistrar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarNovoUsuario();
            }
        });
        panelBtnRegistrar.add(btnRegistrar);
        add(Box.createVerticalStrut(15));
        add(panelBtnRegistrar);

        add(Box.createVerticalStrut(10)); 

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250); 
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registrarNovoUsuario() {
        JOptionPane.showMessageDialog(this, "Usuário registrado com sucesso!", "Registrar Novo Usuário", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
        dispose(); 
    }

    private void limparCampos() {
        txtNovoUsuario.setText("");
        txtNovaSenha.setText("");
        txtConfirmarSenha.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuarioFrame();
            }
        });
    }
}
