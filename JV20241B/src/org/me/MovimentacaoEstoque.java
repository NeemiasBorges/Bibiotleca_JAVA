package org.me;

import java.util.Date;

public class MovimentacaoEstoque {
    private int id;
    private Produto produto;
    private int quantidade;
    private TipoMovimentacao tipo;
    private Date dataHora;

    public MovimentacaoEstoque(int id, Produto produto, int quantidade, TipoMovimentacao tipo, Date dataHora) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }


    @Override
    public String toString() {
        return "MovimentacaoEstoque{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", tipo=" + tipo +
                ", dataHora=" + dataHora +
                '}';
    }
    
    public enum TipoMovimentacao {
        ENTRADA, SAIDA
    }

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public TipoMovimentacao getTipo() {
		return tipo;
	}


	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}


	public Date getDataHora() {
		return dataHora;
	}


	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
}
