package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.entity.FiFoList;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;

import java.util.concurrent.atomic.AtomicInteger;

public class FuncaoFiFo implements AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm>{


    @Override
    public ResultAlgoritmoDTO processa(AlgoritmosForm form) {
        FiFoList<PaginaDTO> fifo = new FiFoList<PaginaDTO>(form.getMemoriaAtual(), form.getTamanhoMaximo());
        AtomicInteger countFalta = new AtomicInteger();
        form.getListaASerCarregada().forEach(items -> {
            if(!(fifo.getListElements().contains(items))) {
                if(fifo.listaCheia()) {
                    fifo.remover();
                }
                fifo.adicionarElementoList(items);
                countFalta.getAndIncrement();
            }
        });

        return new ResultAlgoritmoDTO(countFalta.get());
    }

}
