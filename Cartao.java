public class Cartao{

    private String validade;
    private String cvv;
    private String numero;
    private String titular;
    private String agencia;

    public Cartao(String validade, String cvv, String numero, String titular, String agencia){
        this.validade = validade;
        this.cvv = cvv;
        this.numero = numero;
        this.titular = titular;
        this.agencia = agencia;
    }

    public boolean validaCartao(){
        Operadora operadora = new Operadora();
        return operadora.validaCartao(validade, cvv, numero, titular, agencia);
    }
}