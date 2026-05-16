public class Operadora{

    public Operadora(){}

    // como não utilizamos uma api ou algum sistema de validacao de tranzações, todos os métodos de operadora retornam verdadeiro
    public boolean validaCartao(String validade, String cvv, String numero, String titular, String agencia){
        return true;
    }

    public boolean realizarPagamento(Cartao cartao){
        return true;
    }
}