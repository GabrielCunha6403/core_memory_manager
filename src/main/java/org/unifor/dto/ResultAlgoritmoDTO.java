package org.unifor.dto;

import org.unifor.enums.TipoAlgoritmo;

import java.util.List;

public class ResultAlgoritmoDTO {

    private int qtdFalta;
    private TipoAlgoritmo tipo;
    private int tamanhoListaCarregada;
    private List<String> values;

    public ResultAlgoritmoDTO(int qtdFalta, TipoAlgoritmo tipo) {
        this.qtdFalta = qtdFalta;
        this.tipo = tipo;
    }

    public ResultAlgoritmoDTO(int qtdFalta, TipoAlgoritmo tipo, int tamanhoListaCarregada, List<String> values) {
        this.qtdFalta = qtdFalta;
        this.tipo = tipo;
        this.tamanhoListaCarregada = tamanhoListaCarregada;
        this.values = values;
    }

    public int getTamanhoListaCarregada() {
        return tamanhoListaCarregada;
    }

    public void setTamanhoListaCarregada(int tamanhoListaCarregada) {
        this.tamanhoListaCarregada = tamanhoListaCarregada;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public TipoAlgoritmo getTipo() {
        return tipo;
    }

    public void setTipo(TipoAlgoritmo tipo) {
        this.tipo = tipo;
    }

    public ResultAlgoritmoDTO(int qtdFalta) {
        this.qtdFalta = qtdFalta;
    }

    public int getQtdFalta() {
        return qtdFalta;
    }

    public void setQtdFalta(int qtdFalta) {
        this.qtdFalta = qtdFalta;
    }


}
