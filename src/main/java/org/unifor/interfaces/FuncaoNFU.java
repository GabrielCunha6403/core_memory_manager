package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class FuncaoNFU implements AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> {

    @Override
    public ResultAlgoritmoDTO processa(AlgoritmosForm form) {
        AtomicInteger countFalta = new AtomicInteger();
        List<PaginaDTO> memoria = new ArrayList<>(form.getMemoriaAtual());

        form.getListaASerCarregada().forEach((elemento) -> {

            Optional<PaginaDTO> p =  memoria.stream().filter(x -> x.getValue().equals(elemento.getValue())).findFirst();

            if(p.isPresent()) {
                memoria.get(memoria.indexOf(p.get())).acessar();
            } else {
                if(form.getTamanhoMemoria() == memoria.size()) {
                    int id = memoria.indexOf(buscaPaginaMenosAcessada(memoria));
                    memoria.remove(id);
                    memoria.add(id,elemento);
                } else {
                    memoria.add(elemento);
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
