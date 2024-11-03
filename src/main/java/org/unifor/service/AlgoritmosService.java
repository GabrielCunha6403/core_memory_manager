package org.unifor.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.enums.TipoAlgoritmo;
import org.unifor.util.EnumUtil;

import java.util.Objects;

@ApplicationScoped
public class AlgoritmosService {

    public void compilarAlgoritmos(AlgoritmosForm algoritmosForm) {
        algoritmosForm.getTiposAlgoritmo().forEach(tipos -> {
            System.out.println(tipos);
            ResultAlgoritmoDTO paginaDTO = Objects.requireNonNull(EnumUtil.getEnumByField(TipoAlgoritmo.class, "tipo", tipos)).getFuncao().processa(algoritmosForm);
            System.out.println(paginaDTO.getQtdFalta());
        });
    }
}
