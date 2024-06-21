package org.me;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroFornecedor extends JFrame {

    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton btnSalvar;

    public CadastroFornecedor() {
        super("Cadastro de Fornecedor");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Rótulo e campo de nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNome = new JTextField(20);
        add(txtNome, gbc);

        // Rótulo e campo de telefone
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtTelefone = new JTextField(20);
        add(txtTelefone, gbc);

        // Rótulo e campo de e-mail
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("E-mail:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtEmail = new JTextField(20);
        add(txtEmail, gbc);

        // Botão Salvar
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarFornecedor();
            }
        });
        add(btnSalvar, gbc);

        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void salvarFornecedor() {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();

        // Aqui você pode realizar a lógica para salvar o fornecedor
        JOptionPane.showMessageDialog(this, "Fornecedor salvo com sucesso!", "Cadastro de Fornecedor", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
        dispose(); // Fecha a janela após salvar
    }

    private void limparCampos() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
    }
}
