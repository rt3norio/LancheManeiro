package object;

import java.util.ArrayList;

public class Venda {
	private ArrayList<Produto> produtos = new ArrayList<>();
	private Double valorTotal;
	private Double pesoTotal;
	private Integer quantidadeDeItens = 0;
	private String formaDePagamento;
	private Boolean utilizouEmbalagem;

	void adicionaProduto(Produto produtoAAdicionar){
		produtos.add(produtoAAdicionar);
		valorTotal += produtoAAdicionar.getValor();
		pesoTotal += produtoAAdicionar.getPeso();
		quantidadeDeItens ++;
	}
	
	Venda pagar(String formaDePag, Boolean embalagem){
		formaDePagamento = formaDePag;
		utilizouEmbalagem = embalagem;
		return this;
		
	}
	
	void removeProduto(Integer produtoARemover){
		Produto aRemover = produtos.get(produtoARemover);
		produtos.remove(produtoARemover);
		valorTotal -= aRemover.getValor();
		pesoTotal -= aRemover.getPeso();
		quantidadeDeItens --;
	}


}
