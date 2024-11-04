package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.enums.TipoAlgoritmo;
import org.unifor.util.ListaUtil;

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
        List<Integer> memoriasAcessadas = ListaUtil.mapearParaListaDeIndex(memoria);
        ListaUtil.inverterList(memoriasAcessadas);
        AtomicInteger faltas = new AtomicInteger();

        for (PaginaDTO p : form.getListaASerCarregada()) {
            Optional<PaginaDTO> pagina = memoria.stream().filter(x -> x.getValue().equals(p.getValue())).findFirst();
            if (pagina.isEmpty()) {
                if(memoria.size() == form.getTamanhoMemoria()) {
                    memoria.set(memoriasAcessadas.getFirst(), p);
                } else {
                    memoria.add(p);
                }
                memoriasAcessadas = ListaUtil.mapearParaListaDeIndex(memoria);
                ListaUtil.inverterList(memoriasAcessadas);
                faltas.getAndIncrement();
            }
        }

        return new ResultAlgoritmoDTO(faltas.get(), TipoAlgoritmo.LRU, form.getListaASerCarregada().size(), form.getListaASerCarregada().stream().map(PaginaDTO:: getValue).toList());
    }

}
