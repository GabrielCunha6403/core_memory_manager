package org.unifor.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.unifor.dto.AlgoritmosForm;
import org.unifor.dto.ResultAlgoritmoDTO;
import org.unifor.service.AlgoritmosService;

import java.util.List;

@Path("/processar")
public class AlgoritmoResource {

    private final AlgoritmosService algoritmosService;

    public AlgoritmoResource(AlgoritmosService algoritmosService) {
        this.algoritmosService = algoritmosService;
    }

    @POST
    @Path("/processa")
    public List<ResultAlgoritmoDTO> teste(AlgoritmosForm algoritmosForm) {
        return algoritmosService.compilarAlgoritmos(algoritmosForm);
    }


}
