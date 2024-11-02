package org.unifor.dto;

public class PaginaDTO {

    private int qtdFaltas;
    private String value;
    private int qtdAcesso;
    private String tipo;


    public PaginaDTO(String value) {
        this.qtdFaltas = 0;
        this.value = value;
        this.qtdAcesso = 0;
        this.tipo = "";
    }

    public PaginaDTO(int qtdFaltas, String value, int qtdAcesso, String tipo) {
        this.qtdFaltas = qtdFaltas;
        this.value = value;
        this.qtdAcesso = qtdAcesso;
        this.tipo = tipo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getQtdAcesso() {
        return qtdAcesso;
    }

    public void setQtdAcesso(int qtdAcesso) {
        this.qtdAcesso = qtdAcesso;
    }

    public void acessar() {
        qtdAcesso = qtdAcesso + 1;
    }


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
