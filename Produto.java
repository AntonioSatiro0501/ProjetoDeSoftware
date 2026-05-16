public class Produto{

    private int id;
    private String nome;
    private float peso;
    private String categoria;

    public Produto(int id, String nome, float peso, String categoria){
        this.id = id;
        this.peso = peso;
        this.categoria = categoria;
        this.nome = nome;
    }

    public String getCategoria(){
        return categoria;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void printProduto(){
        System.out.println(id + ". " + nome  + "\nPeso: " + peso+ "\nCategoria: " + categoria + "\n\n");
    }
}