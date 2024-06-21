package org.me;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import org.me.Produto;
import org.me.ProdutoDTO;

public class ListaProdutos extends JPanel {
    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabela;

    public ListaProdutos() {
        setLayout(new BorderLayout());

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Descrição");
        modeloTabela.addColumn("Preço");
        modeloTabela.addColumn("Quantidade");

        tabelaProdutos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        add(scrollPane, BorderLayout.CENTER);

        atualizarTabela();
    }

    public void atualizarTabela() {
        modeloTabela.setRowCount(0);

        ProdutoDTO produtoD = new ProdutoDTO();
        List<Produto> produtos = produtoD.buscarTodos();

        for (Produto produto : produtos) {
            Object[] linha = {
                    produto.getId(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco(),
                    produto.getQuantidadeEstoque()
            };
            modeloTabela.addRow(linha);
        }
    }
}
