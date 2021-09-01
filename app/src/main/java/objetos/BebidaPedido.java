package objetos;

public class BebidaPedido {
    private int qtBebidaPedido;
    private float subTotal;
    private Bebidas bebida;
    private int obs;
    private int pedidoId;

    public BebidaPedido() {
    }

    public int getQtBebidaPedido() {
        return qtBebidaPedido;
    }

    public void setQtBebidaPedido(int qtBebidaPedido) {
        this.qtBebidaPedido = qtBebidaPedido;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Bebidas getbebida() {
        return bebida;
    }
    public void setObs(int obs) {

        this.obs=obs;
    }
    public void setBebida(Bebidas bebida) {

        this.bebida=bebida;
    }
    public int getObservacao() {
        return obs;
    }

    public void getIdPedidoBebida(int id) {
        pedidoId=id;
    }
    public int getIdPedidoBebida() {
        return pedidoId;
    }
}
