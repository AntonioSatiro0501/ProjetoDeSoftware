public class ItemProduto {

    private Produto produto;
    private int quantidade;

    public ItemProduto(Produto produto, int quantidade){
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getIdProduto(){
        return produto.getId();
    }

    public int getQuantidade(){
        return quantidade;
    }

    public int alteraQuantidade(int qtd){
        quantidade += qtd;
        return quantidade;
    }

    public String getNomeProduto(){
        return produto.getNome();
    }
}