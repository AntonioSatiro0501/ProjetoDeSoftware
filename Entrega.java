import java.util.Date;

public class Entrega{

    private Endereco endereco;
    private String dataDeEntrega = "24/07";
    private String statusEntrega = "Aguardando Pagamento";
    
    public Entrega(Endereco endereco){
        this.endereco = endereco;
    }

    // retorna endereco
    public Endereco getEndereco(){
        return endereco;
    }

    // altera status de entrega
    public void mudaStatus(){
        statusEntrega = "Pagamento aprovado";
    }

    // print dados entrega
    public void printDados(){
        System.out.println("----------------- Informacoes entrega -----------------\n");
        System.out.println("Data de entrega: " + dataDeEntrega);
        System.out.println("Status: " + statusEntrega);
        endereco.printEndereco();
    }
}