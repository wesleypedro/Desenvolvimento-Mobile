package br.ufc.quixada.dsdm.trabalho02.model;

public class Modelo {
    private int id;
    private String item;
    private String descricao;

    public Modelo(int id, String item, String descricao) {
        this.id = id;
        this.item = item;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
