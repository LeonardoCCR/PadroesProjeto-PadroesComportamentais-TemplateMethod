public abstract class ProcessadorPagamento {
    protected Pedido pedido;
    protected Cliente cliente;

    public ProcessadorPagamento(Cliente cliente, Pedido pedido) {
        this.cliente = cliente;
        this.pedido = pedido;
    }

    public final String processarFluxo() {
        double valorTotal = pedido.calcularValor();

        if (valorTotal <= 0) return "ERRO: Pedido sem valor.";


        if (!validarDadosEspecificos()) {
            return "FALHA: Dados de pagamento inválidos.";
        }

        double taxa = calcularTaxaAdicional(valorTotal);
        double valorFinal = valorTotal + taxa;

        if (realizarDebito(valorFinal)) {
            return "SUCESSO: " + gerarRecibo(valorFinal);
        }

        return "FALHA: Margem insuficiente ou erro na transação.";
    }


    protected abstract boolean validarDadosEspecificos();
    protected abstract boolean realizarDebito(double valor);


    protected double calcularTaxaAdicional(double valor) {
        return 0.0;
    }

    private String gerarRecibo(double valor) {
        return "Pagamento de R$ " + valor + " confirmado para " + cliente.getNome();
    }
}