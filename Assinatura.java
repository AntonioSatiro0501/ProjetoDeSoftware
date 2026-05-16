public class Assinatura{

    private int idProtocolo = 0;
    private Cesta cesta;
    private Entrega entrega;
    private Pagamento pagamento = null;
    private String status = "Nao validada";

    public Assinatura(Plano plano){
        this.cesta = new Cesta(plano);
    }

    // adiciona item na cesta
    public boolean adicionarItem(int id, int quantidade){
        return cesta.adicionaItemProduto(id, quantidade);
    }

    // checa se o limite de itens de certa categoria da cesta foi atingido
    public boolean checaLimite(String categoria){
        return cesta.checaLimite(categoria);
    }

    // cria endereço e entrega e gera o protocolo
    public void defineEntrega(int cep, String cidade, String bairro, String rua, int numeroResidencia, String complemento, Assinante assinante){
        Endereco endereco = new Endereco(cep, cidade, bairro, rua, numeroResidencia, complemento);
        entrega = new Entrega(endereco);
        geraProtocolo(assinante);
    }

    // gera protocolo
    public void geraProtocolo(Assinante assinante){
        GerenciadorProtocolos gerenciador = new GerenciadorProtocolos();
        idProtocolo = gerenciador.armazenaProtocolo(assinante, entrega, cesta);
    }

    // cria o pagamento
    public void definePagamento(String metodo){
        double valor = cesta.getPrecoPlano();
        pagamento = new Pagamento(valor, metodo);
    }

    // registra o cartao, muda status de cesta, entrega e de si e print de dados de entrega e protocolo
    public boolean registraCartao(String validade, String cvv, String numero, String titular, String agencia){
        if(pagamento.registraCartao(validade, cvv, numero, titular, agencia)){
            status = "Aprovado";
            System.out.println("\nPagamento realizado\n");
            cesta.mudaStatus();
            entrega.mudaStatus();
            entrega.printDados();
            System.out.println("\nId protocolo: " + idProtocolo);
            return true;
        }
        return false;
    }

    // print itens da cesta
    public void printItens(){
        cesta.printItens();
    }

    // retorna limites do plano
    public int[] getLimites(){
        return cesta.getLimites();
    }
}