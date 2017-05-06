package object;

public class Produto {
	private String codigo;
	private Integer quantidade;
	private Double valor;
	private String descrição;
	private Double peso;
	private Integer emEstoque;
	private Integer minEmEstoque;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Integer getEmEstoque() {
		return emEstoque;
	}
	public void setEmEstoque(Integer emEstoque) {
		this.emEstoque = emEstoque;
	}
	public Integer getMinEmEstoque() {
		return minEmEstoque;
	}
	public void setMinEmEstoque(Integer minEmEstoque) {
		this.minEmEstoque = minEmEstoque;
	}
}
