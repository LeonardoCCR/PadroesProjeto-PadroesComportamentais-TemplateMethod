import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class ProcessadorPagamentosTest {
    @Test
    void deveProcessarPagamentoPixComSucesso() {
        Cliente cliente = new Cliente("João");
        Pedido pedido = new Pedido();
        pedido.addItem(new Item(50.0, "Livro"));

        ProcessadorPagamento pix = new ProcessadorPix(cliente, pedido);
        String resultado = pix.processarFluxo();

        // Verifica se a string de retorno começa com SUCESSO
        assertTrue(resultado.contains("SUCESSO"));
        assertTrue(resultado.contains("50.0"));
    }

    @Test
    void deveAplicarTaxaDeCincoPorCentoNoCartao() {
        Cliente cliente = new Cliente("Maria");
        Pedido pedido = new Pedido();
        pedido.addItem(new Item(100.0, "Mouse")); // Valor 100

        ProcessadorPagamento cartao = new ProcessadorCartao(cliente, pedido);
        String resultado = cartao.processarFluxo();

        // 100 + 5% = 105.0
        assertTrue(resultado.contains("105.0"));
    }
}
