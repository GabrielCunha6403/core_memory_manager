package org.unifor.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.enums.TipoAlgoritmo;
import org.unifor.util.EnumUtil;

@ApplicationScoped
public class AlgoritmosService {

    public void compilarAlgoritmos(AlgoritmosForm algoritmosForm) {
        ResultAlgoritmoDTO paginaDTO = EnumUtil.getEnumByField(TipoAlgoritmo.class,"tipo", "nfuz").getFuncao().processa(algoritmosForm);
        System.out.println(paginaDTO.getQtdFalta());
    }


}
