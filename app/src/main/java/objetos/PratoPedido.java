package objetos;

public class PratoPedido {

    private int qtPratoPedido;
    private float subTotal;
    private Pratos prato;
    private String obs;
    private int id;

    public PratoPedido() {
    }

    public int getQtPratoPedido() {
        return qtPratoPedido;
    }

    public void setQtPratoPedido(int qtPratoPedido) {
        this.qtPratoPedido = qtPratoPedido;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public void alterarPratoPedido(){

    }
    public void setPrato(Pratos prato) {
         this.prato=prato;
    }

    public void setObs(String obs) {

        this.obs=obs;
    }
    public void setObs(int id) {

        this.id=id;
    }

    public Pratos getPrato() {
        return prato;
    }

    public String getObservacao() {
        return obs;
    }

    public int getIdPedidoPrato() {
        return id;
    }
}
