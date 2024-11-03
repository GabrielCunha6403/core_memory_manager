package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.enums.TipoAlgoritmo;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FuncaoClock implements AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> {

    @Override
    public ResultAlgoritmoDTO processa(AlgoritmosForm form) {
        List<PaginaDTO> memoria = form.getMemoriaAtual();
        AtomicInteger countFalta = new AtomicInteger();

        form.getListaASerCarregada().forEach(item -> {
            if(!verificarSeOElementoEstaNalista(memoria, item)) {
                if(memoria.size() == form.getTamanhoMemoria()) {
                    memoria.set(memoria.indexOf(retornarPaginaComBitDiferente0(memoria)), item);
                } else {
                    memoria.add(item);
                }
                countFalta.getAndIncrement();
            }
        });


        return new ResultAlgoritmoDTO(countFalta.get(), TipoAlgoritmo.CLK);
    }

    public PaginaDTO retornarPaginaComBitDiferente0(List<PaginaDTO> lista) {
        PaginaDTO pagina = lista.getFirst();
        for(PaginaDTO p : lista) {
            if(p.getQtdAcesso() < pagina.getQtdAcesso()) {
                pagina = p;
            }
        }
        lista.forEach(x -> x.setQtdAcesso(0));
        return pagina;
    }

    public Boolean verificarSeOElementoEstaNalista(List<PaginaDTO> lista, PaginaDTO pg) {
        for (PaginaDTO p : lista) {
            if(p.getValue().equalsIgnoreCase(pg.getValue())) {
                p.setQtdAcesso(1);
                return true;
            }
        }
        return false;
    }
}
