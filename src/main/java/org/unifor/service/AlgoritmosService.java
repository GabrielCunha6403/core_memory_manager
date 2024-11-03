package org.unifor.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.PaginaDTO;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.enums.TipoAlgoritmo;
import org.unifor.util.EnumUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class AlgoritmosService {

    public List<ResultAlgoritmoDTO> compilarAlgoritmos(AlgoritmosForm algoritmosForm) {
        List<ResultAlgoritmoDTO> result = new ArrayList<>();
        algoritmosForm.getTiposAlgoritmo().forEach(tipos -> {
            System.out.println(tipos);
            ResultAlgoritmoDTO paginaDTO = Objects.requireNonNull(EnumUtil.getEnumByField(TipoAlgoritmo.class, "tipo", tipos)).getFuncao().processa(algoritmosForm);
            result.add(paginaDTO);
            System.out.println(paginaDTO.getQtdFalta());
        });
        return result;
    }
}
