public class Assinatura{

    int idProtocolo = null;
    private Cesta cesta;
    private Entrega entrega;
    private Pagamento pagamento = null;
    private String status = "Nao validada";

    public Assinatura(Plano plano){
        this.cesta = new Cesta(plano);
    }

    public boolean adicionarItem(int id, int quantidade){
        return cesta.adicionaItemProduto(id, quantidade);
    }

    public boolean checaLimite(String categoria){
        return cesta.checaLimite(categoria);
    }

    public void defineEntrega(int cep, String cidade, String bairro, String rua, int numeroResidencia, String complemento, Assinante assinante){
        Endereco endereco = new Endereco(cep, cidade, bairro, rua, numeroResidencia, complemento);
        entrega = new Entrega(endereco);
        geraProtocolo(assinante);
    }

    public void geraProtocolo(Assinante assinante){
        GerenciadorProtocolos gerenciador = new GerenciadorProtocolos();
        idProtocolo = gerenciador.armazenaProtocolo(assinante, entrega, cesta);
    }

    public void definePagamento(String metodo){
        double valor = cesta.getPrecoPlano();
        pagamento = new Pagamento(valor, metodo);
    }

    public boolean registraCartao(String validade, String cvv, String numero, String titular, String agencia){
        if(pagamento.registraCartao(validade, cvv, numero, titular, agencia)){
            status = "Aprovado";
            cesta.mudaStatus();
        }
        return false;
    }

    public void printItens(){
        cesta.printItens();
    }
}