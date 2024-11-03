package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class FuncaoNFU implements AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> {

    @Override
    public ResultAlgoritmoDTO processa(AlgoritmosForm form) {
        AtomicInteger countFalta = new AtomicInteger();
        List<PaginaDTO> memoria = new ArrayList<>(form.getMemoriaAtual());

        form.getListaASerCarregada().forEach((elemento) -> {

            if(fazerAcessoDeElementosMemoria(memoria, elemento)) {
                if(form.getTamanhoMemoria() == memoria.size()) {
                    int id = memoria.indexOf(buscaPaginaMenosAcessada(memoria));
                    elemento.acessar();
                    memoria.set(id,elemento);
                } else {
                    elemento.acessar();
                    memoria.add(elemento);
                }
                countFalta.getAndIncrement();
            }


        });

        return new ResultAlgoritmoDTO(countFalta.get());
    }

    boolean fazerAcessoDeElementosMemoria(List<PaginaDTO> list, PaginaDTO paginaDTO) {
        for(PaginaDTO x : list) {
            if(x.getValue().equals(paginaDTO.getValue())) {
                x.acessar();
                return false;
            };
        }
        return true;
    }

    public PaginaDTO buscaPaginaMenosAcessada(List<PaginaDTO> memoria) {
        return memoria.stream().min(Comparator.comparingInt(PaginaDTO::getQtdAcesso)).orElseThrow();
    }
}
