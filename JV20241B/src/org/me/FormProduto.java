package org.me;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormProduto extends JPanel {

    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JButton btnSalvar;
    private JButton btnCadastrarDeposito;
    private JButton btnCadastrarFornecedor;
    private Produto produtoEditavel;

    public FormProduto() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtNome = new JTextField(20);
        txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
        add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        add(new JLabel("Descrição:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtDescricao = new JTextField(20);
        txtDescricao.setFont(new Font("Arial", Font.PLAIN, 14));
        add(txtDescricao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        add(new JLabel("Preço:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtPreco = new JTextField(20);
        txtPreco.setFont(new Font("Arial", Font.PLAIN, 14));
        add(txtPreco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        add(new JLabel("Quantidade:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtQuantidade = new JTextField(20);
        txtQuantidade.setFont(new Font("Arial", Font.PLAIN, 14));
        add(txtQuantidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 16));
        btnSalvar.setBackground(new Color(0, 128, 0));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarProduto();
            }
        });
        add(btnSalvar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        btnCadastrarDeposito = new JButton("<html>Cadastrar<br>Depósito</html>");
        btnCadastrarDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCadastroDeposito();
            }
        });
        add(btnCadastrarDeposito, gbc);

        gbc.gridx = 2;
        btnCadastrarFornecedor = new JButton("<html>Cadastrar<br>Fornecedor</html>");
        btnCadastrarFornecedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCadastroFornecedor();
            }
        });
        add(btnCadastrarFornecedor, gbc);

        txtNome.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtDescricao.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtPreco.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtQuantidade.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        revalidate();
    }

    public void editarProduto(Produto produto) {
        produtoEditavel = produto;
        txtNome.setText(produto.getNome());
        txtDescricao.setText(produto.getDescricao());
        txtPreco.setText(String.valueOf(produto.getPreco()));
        txtQuantidade.setText(String.valueOf(produto.getQuantidadeEstoque()));
    }

    public void limparFormulario() {
        produtoEditavel = null;
        txtNome.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
    }

    private void salvarProduto() {
        String nome = txtNome.getText();
        String descricao = txtDescricao.getText();
        String precoText = txtPreco.getText();
        String quantidadeText = txtQuantidade.getText();

        if (nome.isEmpty() || nome.length() > 100) {
            JOptionPane.showMessageDialog(this, "Nome deve ter entre 1 e 100 caracteres.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (descricao.isEmpty() || descricao.length() > 100) {
            JOptionPane.showMessageDialog(this, "Descrição deve ter entre 1 e 100 caracteres.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço deve ser um número válido.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantidade;
        try {
            quantidade = Integer.parseInt(quantidadeText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade deve ser um número inteiro válido.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ProdutoDTO produtoDTO = new ProdutoDTO();

        if (produtoEditavel == null) {
            Fornecedor fornecedorPadrao = new Fornecedor(1, "Fornecedor Padrão", "", "");
            Produto novoProduto = new Produto(0, nome, descricao, preco, quantidade, fornecedorPadrao);
            produtoDTO.inserir(novoProduto);
        } else {
            produtoEditavel.setNome(nome);
            produtoEditavel.setDescricao(descricao);
            produtoEditavel.setPreco(preco);
            produtoEditavel.setQuantidadeEstoque(quantidade);
            produtoDTO.atualizar(produtoEditavel);
        }

        limparFormulario();

        Component parent = SwingUtilities.getAncestorOfClass(Main.class, this);
        if (parent instanceof Main) {
            Main mainFrame = (Main) parent;
            mainFrame.getListaProdutos().atualizarTabela();
        }
    }

    private void abrirCadastroDeposito() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CadastroDeposito cadastroDeposito = new CadastroDeposito();
                cadastroDeposito.setVisible(true);
            }
        });
    }

    private void abrirCadastroFornecedor() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CadastroFornecedor cadastroFornecedor = new CadastroFornecedor();
                cadastroFornecedor.setVisible(true);
            }
        });
    }
}
