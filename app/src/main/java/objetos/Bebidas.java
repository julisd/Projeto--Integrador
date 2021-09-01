package objetos;

import java.util.ArrayList;

public class Bebidas {
    private String nome;
    private double preco;
    private String descricaoBebida;
    private ArrayList ingredientes;
    private int id;

    public Bebidas() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricaoBebida() {
        return descricaoBebida;
    }

    public void setDescricaoBebida(String descricaoBebida) {
        this.descricaoBebida = descricaoBebida;
    }

    public int getId() {
        return id;
    }

    public void seIdBebida( int idBebida) {
        id=idBebida;
    }
}
