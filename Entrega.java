import java.util.Date;

public class Entrega{

    private Endereco endereco;
    private Date dataDeEntrega = null;
    private String statusEntrega = "Aguardando Pagamento";
    
    public Entrega(Endereco endereco){
        this.endereco = endereco;
    }

    public Endereco getEndereco(){
        return endereco;
    }
}