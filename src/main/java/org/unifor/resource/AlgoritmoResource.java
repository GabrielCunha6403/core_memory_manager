package org.unifor.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.unifor.dto.AlgoritmosForm;
import org.unifor.service.AlgoritmosService;

@Path("/processar")
public class AlgoritmoResource {

    private final AlgoritmosService algoritmosService;

    public AlgoritmoResource(AlgoritmosService algoritmosService) {
        this.algoritmosService = algoritmosService;
    }

    @POST
    @Path("/processa")
    public void teste(AlgoritmosForm algoritmosForm) {
        algoritmosService.compilarAlgoritmos(algoritmosForm);
    }


}
