package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FuncaoLRU implements AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> {


    @Override
    public ResultAlgoritmoDTO processa(AlgoritmosForm form) {
        List<PaginaDTO> memoria = new ArrayList<>(form.getMemoriaAtual());
        List<Integer> memoriasAcessadas = new ArrayList<>();
        AtomicInteger faltas = new AtomicInteger();

        for (PaginaDTO p : form.getListaASerCarregada()) {
            Optional<PaginaDTO> pagina = memoria.stream().filter(x -> x.getValue().equals(p.getValue())).findFirst();
            if (pagina.isEmpty()) {
                if(memoria.size() == form.getTamanhoMemoria()) {
                    memoria.set(memoriasAcessadas.getFirst(), p);
                } else {
                    memoria.add(p);
                }
                memoriasAcessadas = mapearParaListaDeIndex(memoria);
                inverterList(memoriasAcessadas);
                faltas.getAndIncrement();
            }
        }

        return new ResultAlgoritmoDTO(faltas.get());
    }

    public void inverterList(List<Integer> list) {
        int ponteiroEsquerda = 0;
        int ponteiroDireita = list.size() - 1;

        while (ponteiroDireita > ponteiroEsquerda) {
            Integer value = list.get(ponteiroEsquerda);
            list.set(ponteiroEsquerda, list.get(ponteiroDireita));
            list.set(ponteiroDireita, value);
            ponteiroEsquerda++;
            ponteiroDireita--;
        }
    }

    public List<Integer> mapearParaListaDeIndex(List<PaginaDTO> lista) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < lista.size(); i++) {
            list.add(i);
        }
        return list;
    }
}
