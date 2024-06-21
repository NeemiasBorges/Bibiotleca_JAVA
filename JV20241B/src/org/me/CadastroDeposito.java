package org.me;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDeposito extends JFrame {

    private JTextField txtNome;
    private JTextField txtLocalizacao;
    private JButton btnSalvar;

    public CadastroDeposito() {
        super("Cadastro de Depósito");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNome = new JTextField(20);
        add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Localização:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtLocalizacao = new JTextField(20);
        add(txtLocalizacao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarDeposito();
            }
        });
        add(btnSalvar, gbc);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void salvarDeposito() {
        String nome = txtNome.getText();
        String localizacao = txtLocalizacao.getText();

        JOptionPane.showMessageDialog(this, "Depósito salvo com sucesso!", "Cadastro de Depósito", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
        dispose(); 
    }

    private void limparCampos() {
        txtNome.setText("");
        txtLocalizacao.setText("");
    }
}
