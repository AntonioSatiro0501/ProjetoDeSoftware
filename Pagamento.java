import java.util.Random;
import java.util.Hashtable;
import java.util.Collection;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pagamento{

    private Random geraId = new Random();
    private int id = geraId.nextInt(999999);
    private String metodo;
    private double valor;
    private String dataTransacao = "-";
    private Cartao cartao = null;
    private String status = "Esperando cartao";

    public Pagamento(double valor, String metodo){
        this.valor = valor;
        this.metodo = metodo;
    }

    // registra cartao e inicia pagamento se ele for valido 
    public boolean registraCartao(String validade, String cvv, String numero, String titular, String agencia){
        cartao = new Cartao(validade, cvv, numero, titular, agencia);
        if(cartao.validaCartao()){
            status = "Aguardando Aprovacao";
            return processarPagamento();
        } else {
            status = "Cartao Invalido";
            return false;
        }
    }

    // realiza o pagamento
    public boolean processarPagamento(){
        Operadora operadora = new Operadora();
        if(operadora.realizarPagamento(cartao)){
            status = "Aprovado";
            dataTransacao = "23/04";
            registrarPagamento();
            return true;
        } else {
            status = "Recusado";
            return false;
        }
    }

    // registra pagamento 
    public void registrarPagamento(){
        try{

            FileWriter pagamentos = new FileWriter("Pagamentos.txt" , true);
            BufferedWriter escreverPagamento = new BufferedWriter(pagamentos);

            escreverPagamento.newLine();
            escreverPagamento.write(id + "_" + metodo + "_" + valor + "_" + dataTransacao + "_" + status);

            escreverPagamento.close();
            pagamentos.close();

        } catch(IOException e){
            System.err.printf(e.getMessage());
        }
    }
}