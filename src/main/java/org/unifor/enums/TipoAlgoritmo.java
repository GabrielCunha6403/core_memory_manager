package org.unifor.enums;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.interfaces.AlgoritmoInterface;
import org.unifor.interfaces.FuncaoFiFo;

public enum TipoAlgoritmo {

    FIFO("fifo", new FuncaoFiFo());

    private String tipo;
    private AlgoritmoInterface<PaginaDTO, AlgoritmosForm> funcao;

    TipoAlgoritmo(String tipo, AlgoritmoInterface<PaginaDTO, AlgoritmosForm> funcao) {
        this.tipo = tipo;
        this.funcao = funcao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public AlgoritmoInterface<PaginaDTO, AlgoritmosForm> getFuncao() {
        return funcao;
    }

    public void setFuncao(AlgoritmoInterface<PaginaDTO, AlgoritmosForm> funcao) {
        this.funcao = funcao;
    }
}
