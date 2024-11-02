package org.unifor.dto;

public class PaginaDTO {

    private int qtdFaltas;

    public PaginaDTO(String tipo, int qtdFaltas) {
        this.tipo = tipo;
        this.qtdFaltas = qtdFaltas;
    }

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQtdFaltas() {
        return qtdFaltas;
    }

    public void setQtdFaltas(int qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }
}
