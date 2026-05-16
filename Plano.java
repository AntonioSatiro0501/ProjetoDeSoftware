public class Plano {

    private int id;
    private String nome;
    private double preco;
    private int qFrutas;
    private int qVerduras;
    private int qLegumes;

    public Plano(int id, String nome, double preco, int qFrutas, int qVerduras, int qLegumes){

        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qFrutas = qFrutas;
        this.qVerduras = qVerduras;
        this.qLegumes = qLegumes;

    }

    public int getId(){
        return id;
    }

    public double getPreco(){
        return preco;
    }

    public String getNome(){
        return nome;
    }

    public int getLimite(String categoria){
        
        switch(categoria){
            case("fruta"):
                return qFrutas;
            case("verdura"):
                return qVerduras;
            case("legume"):
                return qLegumes;
            default:
                return 0;
        }
    }

    public void printPlano(){
        System.out.println(id + ". " + nome + "\nPreco: " + preco + "\nQuantidade Frutas: " + qFrutas+ "\nQuantidade Verduras: " + qVerduras + "\nQuantidade Legumes: " + qLegumes + "\n\n");
    }

}