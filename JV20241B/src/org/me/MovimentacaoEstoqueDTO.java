package org.me;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimentacaoEstoqueDTO {

    public void inserir(MovimentacaoEstoque movimentacaoEstoque) {
        String sql = "INSERT INTO movimentacao_estoque (id_produto, quantidade, tipo, data_hora) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, movimentacaoEstoque.getProduto().getId());
            stmt.setInt(2, movimentacaoEstoque.getQuantidade());
            stmt.setString(3, movimentacaoEstoque.getTipo().name());
            stmt.setTimestamp(4, new Timestamp(movimentacaoEstoque.getDataHora().getTime()));

            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                movimentacaoEstoque.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
    }

    public MovimentacaoEstoque buscarPorId(int id) {
        String sql = "SELECT * FROM movimentacao_estoque WHERE id=?";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return new MovimentacaoEstoque(
                        rs.getInt("id"),
                        buscarProdutoPorId(rs.getInt("id_produto")),
                        rs.getInt("quantidade"),
                        MovimentacaoEstoque.TipoMovimentacao.valueOf(rs.getString("tipo")),
                        new Date(rs.getTimestamp("data_hora").getTime())
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return null;
    }

    public List<MovimentacaoEstoque> buscarTodos() {
        List<MovimentacaoEstoque> movimentacoes = new ArrayList<MovimentacaoEstoque>();
        String sql = "SELECT * FROM movimentacao_estoque";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Connect.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                MovimentacaoEstoque movimentacao = new MovimentacaoEstoque(
                        rs.getInt("id"),
                        buscarProdutoPorId(rs.getInt("id_produto")),
                        rs.getInt("quantidade"),
                        MovimentacaoEstoque.TipoMovimentacao.valueOf(rs.getString("tipo")),
                        new Date(rs.getTimestamp("data_hora").getTime())
                );
                movimentacoes.add(movimentacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return movimentacoes;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM movimentacao_estoque WHERE id=?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    private Produto buscarProdutoPorId(int idProduto) {
        String sql = "SELECT * FROM produto WHERE id=?";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade_estoque"),
                        new FornecedorDTO().buscarPorId(rs.getInt("id_fornecedor"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return null;
    }

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
