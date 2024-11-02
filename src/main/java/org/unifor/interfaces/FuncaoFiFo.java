package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.FiFoList;
import org.unifor.dto.PaginaDTO;

import java.util.concurrent.atomic.AtomicInteger;

public class FuncaoFiFo implements AlgoritmoInterface<PaginaDTO, AlgoritmosForm>{


    @Override
    public PaginaDTO processa(AlgoritmosForm form) {
        FiFoList<Integer> fifo = new FiFoList<Integer>(form.getListaElementos(), form.getTamanhoMaximo());
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

        return new PaginaDTO("teste", countFalta.get());
    }

    public void adicionarElementoLista() {

    }

}
