public class ProcessadorPix extends ProcessadorPagamento {
    public ProcessadorPix(Cliente cliente, Pedido pedido) {
        super(cliente, pedido);
    }

    @Override
    protected boolean validarDadosEspecificos() {
        //Alguma lógica para validar
        return true;
    }

    @Override
    protected boolean realizarDebito(double valor) {
        //Alguma lógica para fazer débito usando pix
        return true;
    }
}