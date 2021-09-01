package objetos;

public class Pedido {

    private String dtPedido;
    private float valorTotal;
    private int formaDePagamento;
    private Dispositivo dispositivo;
    private BebidaPedido pedidoBebida;
    private PratoPedido pedidoPrato;
    public Pedido() {
    }

    public String getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(String dtPedido) {
        this.dtPedido = dtPedido;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(int formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Dispositivo getDispositivo() {
        return  dispositivo;
    }

    public PratoPedido getPedidoPrato() {
        return pedidoPrato;
    }

    public BebidaPedido getPedidoBebida() {
        return pedidoBebida;
    }
}
