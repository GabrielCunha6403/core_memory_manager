package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.enums.TipoAlgoritmo;

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
                    memoria.set(id,elemento);
                } else {
                    memoria.add(elemento);
                }
                countFalta.getAndIncrement();
            }

        });

        return new ResultAlgoritmoDTO(countFalta.get(), TipoAlgoritmo.NFU);
    }

    boolean fazerAcessoDeElementosMemoria(List<PaginaDTO> list, PaginaDTO paginaDTO) {
        for(PaginaDTO x : list) {
            if(x.getValue().trim().equalsIgnoreCase(paginaDTO.getValue().trim())) {
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
