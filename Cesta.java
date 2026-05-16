import java.util.Hashtable;
import java.util.Collection;

public class Cesta {

    private int atualFrutas = 0;
    private int atualVerduras = 0;
    private int atualLegumes = 0;
    private Plano plano;
    private Hashtable<Integer, ItemProduto> items = new Hashtable<>();
    private String status = "Nao validada";

    public Cesta(Plano plano){
        this.plano = plano;
    }

    // valida se quantidade de itens adicionados ou removidos é válido
    public boolean validaQuantidade(String categoria, int quantidade){

        int limite = plano.getLimite(categoria);
        
        switch(categoria){
            case("fruta"):
                return (atualFrutas + quantidade <= limite && atualFrutas + quantidade >= 0);
            case("verdura"):
                return (atualVerduras + quantidade <= limite && atualVerduras + quantidade >= 0);
            case("legume"):
                return (atualLegumes + quantidade <= limite && atualLegumes + quantidade >= 0);
            default:
                return false;
        }
    }

    // metodo para adicionar ou remover itens ou aterar suas quantidades
    public boolean adicionaItemProduto(int idProduto, int quantidade){

        if(quantidade == 0){
            System.out.println("Quantidade igual a 0 nao adiociona");
            return false;
        }

        ColecaoProdutos colecao = new ColecaoProdutos();
        Produto produto = colecao.getProduto(idProduto);
        
        if(produto != null){
            String categoria = produto.getCategoria();
            
            if(validaQuantidade(categoria, quantidade)){

                ItemProduto item = items.get(idProduto);

                if(item == null){
                    if(quantidade > 0){
                        item = new ItemProduto(produto, quantidade);
                        items.put(idProduto, item);
                        adicionaQuantidadeACategoria(categoria, quantidade);
                        return true;
                    }
                    
                    return false;
                }

                if(item.getQuantidade() + quantidade < 0){
                    System.out.println("Nao e possivel reduzir a quantidade de um item para menos de 0");
                    return false;
                } else if(item.getQuantidade() + quantidade == 0){
                    System.out.println("Item removido");
                    items.remove(idProduto);
                    adicionaQuantidadeACategoria(categoria, quantidade);
                    return true;
                } else{
                    item.alteraQuantidade(quantidade);
                    items.put(idProduto, item);
                    adicionaQuantidadeACategoria(categoria, quantidade);
                    return true;
                }

            }
            System.out.println("Quantidade invalida");
            return false;
        } else {return false;}
        
    }

    // metodo para incrementar mudancas de quantidade itens escolhidos ate o momento
    private void adicionaQuantidadeACategoria(String categoria, int quantidade){
        switch(categoria){
            case("fruta"):
                atualFrutas += quantidade;
                break;
            case("verdura"):
                atualVerduras += quantidade;
                break;
            case("legume"):
                atualLegumes += quantidade;
                break;
            default:
                return;
        }
    }

    // checa se quantidade se certa categoria alcançou o limite do plano
    public boolean checaLimite(String categoria){

        int limite = plano.getLimite(categoria);
        
        switch(categoria){
            case("fruta"):
                System.out.println("----------------------------------");
                System.out.println("\nFrutas " + atualFrutas + "/" + limite);
                System.out.println("----------------------------------\n");
                return (atualFrutas == limite);
            case("verdura"):
                System.out.println("----------------------------------");
                System.out.println("\nVerduras " + atualVerduras + "/" + limite);
                System.out.println("----------------------------------\n");
                return (atualVerduras == limite);
            case("legume"):
                System.out.println("----------------------------------");
                System.out.println("\nLegumes " + atualLegumes + "/" + limite);
                System.out.println("----------------------------------\n");
                return (atualLegumes == limite);
            default:
                return false;
        }
    }

    public Hashtable<Integer, ItemProduto> getItems(){
        return items;
    }

    public int getIdPlano(){
        return plano.getId();
    }

    public double getPrecoPlano(){
        return plano.getPreco();
    }

    public void printItens(){
        System.out.println("----------------------------------");
        Collection<ItemProduto> itens = items.values();
        for(ItemProduto item : itens){
            System.out.println(item.getNomeProduto() + " qtd: " + item.getQuantidade());
        }
        System.out.println("----------------------------------\n");
    }

    public void mudaStatus(){
        status = "Aprovado";
    }
}