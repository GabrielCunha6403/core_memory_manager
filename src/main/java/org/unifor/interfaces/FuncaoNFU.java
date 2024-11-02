package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FuncaoNFU implements AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> {

    @Override
    public ResultAlgoritmoDTO processa(AlgoritmosForm form) {
        AtomicInteger countFalta = new AtomicInteger();
        form.getListaASerCarregada().forEach(elemento -> {
                if(form.getMemoriaAtual().contains(elemento)) {
                    form.getMemoriaAtual().get(form.getMemoriaAtual().indexOf(elemento)).acessar();
                } else {
                    if(form.getTamanhoMemoria() <= form.getMemoriaAtual().size()) {
                        int id = form.getMemoriaAtual().indexOf(buscaPaginaMenosAcessada(form.getMemoriaAtual()));
                        form.getMemoriaAtual().remove(id);
                        form.getMemoriaAtual().add(id,elemento);
                    } else {
                        form.getMemoriaAtual().add(elemento);
                    }
                    countFalta.getAndIncrement();
                }

        });

        return new ResultAlgoritmoDTO(countFalta.get());
    }

    public PaginaDTO buscaPaginaMenosAcessada(List<PaginaDTO> memoria) {
        PaginaDTO p  = memoria.getFirst();
        for(PaginaDTO dto : memoria) {
           p = dto.getQtdAcesso() > p.getQtdAcesso() ? p : dto;
        }
        return p;
    }
}
