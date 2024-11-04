package org.unifor.interfaces;

import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.enums.TipoAlgoritmo;

import java.util.ArrayList;
import java.util.List;

public class FuncaoAging implements  AlgoritmoInterface<ResultAlgoritmoDTO, AlgoritmosForm> {
    private static final int MAX_COUNTER_VALUE = 255;

    @Override
    public ResultAlgoritmoDTO processa(AlgoritmosForm form) {
        int pageFaults = 0;
        List<PaginaDTO> memoria = new ArrayList<>(form.getMemoriaAtual());
        List<PaginaDTO> filaPaginas = form.getListaPaginasASeremCarregadas();

        // Inicializa contadores para cada página na memória
        int[] agingCounters = new int[form.getTamanhoMemoria()];

        for (PaginaDTO pagina : filaPaginas) {
            boolean found = false;

            // Verifica se a página já está na memória
            for (int i = 0; i < memoria.size(); i++) {
                if (memoria.get(i).equals(pagina)) {
                    found = true;
                    agingCounters[i] = Math.min((agingCounters[i] >> 1) | MAX_COUNTER_VALUE, MAX_COUNTER_VALUE);
                    break;
                }
            }

            // Se a página não estiver na memória, ocorre uma falta de página
            if (!found) {
                pageFaults++;

                if (memoria.size() < form.getTamanhoMemoria()) {
                    memoria.add(pagina);
                    agingCounters[memoria.size() - 1] = MAX_COUNTER_VALUE;
                } else {
                    // Encontra a página com o menor contador para substituir
                    int minIndex = 0;
                    for (int i = 1; i < agingCounters.length; i++) {
                        if (agingCounters[i] < agingCounters[minIndex]) {
                            minIndex = i;
                        }
                    }
                    // Substitui a página e reseta o contador
                    memoria.set(minIndex, pagina);
                    agingCounters[minIndex] = MAX_COUNTER_VALUE;
                }
            }

            // Atualiza todos os contadores de envelhecimento
            for (int i = 0; i < agingCounters.length; i++) {
                if (memoria.size() > i && !memoria.get(i).equals(pagina)) {
                    agingCounters[i] = agingCounters[i] >> 1;
                }
            }
        }

        return  new ResultAlgoritmoDTO(pageFaults, TipoAlgoritmo.AGING , form.getListaASerCarregada().size(), form.getListaASerCarregada().stream().map(PaginaDTO::getValue).toList());
    }
}

