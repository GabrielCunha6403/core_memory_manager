package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.entity.FiFoList;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.enums.TipoAlgoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class FuncaoFIFO implements AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm>{


    @Override
    public ResultAlgoritmoDTO processa(AlgoritmosForm form) {
        List<PaginaDTO> pages = new ArrayList<>(form.getMemoriaAtual());
        FiFoList<PaginaDTO> fifo = new FiFoList<PaginaDTO>(pages, form.getTamanhoMemoria());
        AtomicInteger countFalta = new AtomicInteger();
        form.getListaASerCarregada().forEach(items -> {
            Optional<PaginaDTO> p = fifo.getListElements().stream().filter(item -> item.getValue().equals(items.getValue())).findFirst();
            if(p.isEmpty()) {
                if(fifo.listaCheia()) {
                    fifo.remover();
                }
                fifo.adicionarElementoList(items);
                countFalta.getAndIncrement();
            }
        });

        return new ResultAlgoritmoDTO(countFalta.get(), TipoAlgoritmo.FIFO, form.getListaASerCarregada().size(), form.getListaASerCarregada().stream().map(PaginaDTO::getValue).toList());
    }

}
