package org.unifor.util;

import org.unifor.dto.PaginaDTO;

import java.util.ArrayList;
import java.util.List;

public class ListaUtil {

    public static <T> void inverterList(List<T> list) {
        int ponteiroEsquerda = 0;
        int ponteiroDireita = list.size() - 1;

        while (ponteiroDireita > ponteiroEsquerda) {
            T value = list.get(ponteiroEsquerda);
            list.set(ponteiroEsquerda, list.get(ponteiroDireita));
            list.set(ponteiroDireita, value);
            ponteiroEsquerda++;
            ponteiroDireita--;
        }
    }

    public static <T> List<Integer> mapearParaListaDeIndex(List<T> lista) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < lista.size(); i++) {
            list.add(i);
        }
        return list;
    }

}
