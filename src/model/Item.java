package model;

public class Item {

    private int codigo;
    private Produto produto;
    private int quantidade;

    public Item(int codigo, Produto produto, int quantidade) {
        this.codigo = codigo;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public Item(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public double getSubtotal(){
        return produto.preco*quantidade;
    }

}
