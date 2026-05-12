public class ProcessadorCartao extends ProcessadorPagamento {
    public ProcessadorCartao(Cliente cliente, Pedido pedido) {
        super(cliente, pedido);
    }

    @Override
    protected boolean validarDadosEspecificos() {
        // Alguma lógica para validação de CVV e data de expiração
        return true;
    }

    @Override
    protected double calcularTaxaAdicional(double valor) {
        return valor * 0.05; // Taxa aplicada ao cartao 5%
    }

    @Override
    protected boolean realizarDebito(double valor) {
        return valor < 5000.0; // Para impedir compras suspeitas
    }
}