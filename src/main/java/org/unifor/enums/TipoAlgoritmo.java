package org.unifor.enums;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.interfaces.*;

public enum TipoAlgoritmo {

    FIFO("fifo", new FuncaoFIFO()),
    NFU("nfu", new FuncaoNFU()),
    CLOCK("clk", new FuncaoClock()),
    AGING("ag", new FuncaoAging()),
    LRU("lru", new FuncaoLRU());

    private String tipo;
    private AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> funcao;

    TipoAlgoritmo(String tipo, AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> funcao) {
        this.tipo = tipo;
        this.funcao = funcao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> getFuncao() {
        return funcao;
    }

    public void setFuncao(AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> funcao) {
        this.funcao = funcao;
    }
}
