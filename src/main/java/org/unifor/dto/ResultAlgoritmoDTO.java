package org.unifor.dto;

import org.unifor.enums.TipoAlgoritmo;

public class ResultAlgoritmoDTO {

    private int qtdFalta;
    private TipoAlgoritmo tipo;

    public ResultAlgoritmoDTO(int qtdFalta, TipoAlgoritmo tipo) {
        this.qtdFalta = qtdFalta;
        this.tipo = tipo;
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
