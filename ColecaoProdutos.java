import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Collection;

public class ColecaoProdutos {

    public Hashtable<Integer, Produto> hash = new Hashtable<>();

    public ColecaoProdutos(){

        // fetch dos produtos
        try{
            FileReader produtos = new FileReader("Produtos.txt");
            BufferedReader lerProdutos = new BufferedReader(produtos);
            String linha = lerProdutos.readLine();
            while (linha != null) {
            
                String[] atriProduto = linha.split("_");
                Produto produto = new Produto(Integer.parseInt(atriProduto[0]), atriProduto[1], Float.parseFloat(atriProduto[2]), atriProduto[3]);
                hash.put(Integer.parseInt(atriProduto[0]), produto);
                linha = lerProdutos.readLine();
            }

            produtos.close();
        } catch(IOException e){
            System.err.printf(e.getMessage());
        }
    }

    // retorna um produto pelo id se existir
    public Produto getProduto(int id){
        return hash.get(id);
    }

    // realiza print de todos os produtos de certa categoria
    public void printPorCategoria(String categoria){
        Collection<Produto> produtos = hash.values();
        for(Produto produto : produtos){
            if(produto.getCategoria().equals(categoria)){
                produto.printProduto();
            }
        }
    }
}