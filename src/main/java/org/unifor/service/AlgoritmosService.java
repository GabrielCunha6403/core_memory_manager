package org.unifor.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.enums.TipoAlgoritmo;
import org.unifor.util.EnumUtil;

@ApplicationScoped
public class AlgoritmosService {

    public void compilarAlgoritmos(AlgoritmosForm algoritmosForm) {
        PaginaDTO paginaDTO = EnumUtil.getEnumByField(TipoAlgoritmo.class,"tipo", "fifo").getFuncao().processa(algoritmosForm);
        System.out.println(paginaDTO.getQtdFaltas());
    }


}
