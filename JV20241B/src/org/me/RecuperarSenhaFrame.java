package org.me;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecuperarSenhaFrame extends JFrame {

    private JTextField txtEmail;
    private JButton btnEnviar;

    public RecuperarSenhaFrame() {
        super("Recuperar Senha");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("E-mail:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtEmail = new JTextField(20);
        add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RecuperarSenhaFrame.this, "Solicitação de recuperação de senha enviada para " + txtEmail.getText(), "Recuperar Senha", JOptionPane.INFORMATION_MESSAGE);
                dispose(); 
            }
        });
        add(btnEnviar, gbc);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
