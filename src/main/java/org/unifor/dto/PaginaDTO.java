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

    public PaginaDTO(int qtdFaltas, String tipo, int qtdAcesso, String value) {
        this.qtdFaltas = qtdFaltas;
        this.tipo = tipo;
        this.qtdAcesso = qtdAcesso;
        this.value = value;
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
        qtdAcesso++;
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
