package org.me;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private ListaProdutos listaProdutos;
    private FormProduto formProduto;

    public Main() {
        super("Sistema de Gerenciamento de Estoque");

        listaProdutos = new ListaProdutos();
        formProduto = new FormProduto();

        add(listaProdutos, BorderLayout.WEST);
        add(formProduto, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public ListaProdutos getListaProdutos() {
        return listaProdutos;
    }
}
