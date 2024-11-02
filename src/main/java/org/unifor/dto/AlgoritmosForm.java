package org.unifor.dto;

import org.unifor.entity.Pagina;

import java.util.List;

public class AlgoritmosForm {
    //memoria atual com ou sem conteudo de paginas dentro
    private List<PaginaDTO> memoriaAtual;
    //ordem em que as paginas estão na lista para serem executadas
    private List<PaginaDTO> listaPaginasASeremCarregadas;
    // quais algoritmos executar
    private List<String> tiposAlgoritmo;
    // tamanho da lista na memoria
    private int tamanhoMemoria;
    private int tamanhoFilaDePaginas;

    public AlgoritmosForm(int tamanhoFilaDePaginas, List<PaginaDTO> memoriaAtual, List<PaginaDTO> listaPaginasASeremCarregadas, List<String> tiposAlgoritmo, int tamanhoMemoria) {
        this.tamanhoFilaDePaginas = tamanhoFilaDePaginas;
        this.memoriaAtual = memoriaAtual;
        this.listaPaginasASeremCarregadas = listaPaginasASeremCarregadas;
        this.tiposAlgoritmo = tiposAlgoritmo;
        this.tamanhoMemoria = tamanhoMemoria;
    }

    public List<String> getTiposAlgoritmo() {
        return tiposAlgoritmo;
    }

    public void setTiposAlgoritmo(List<String> tiposAlgoritmo) {
        this.tiposAlgoritmo = tiposAlgoritmo;
    }

    public int getTamanhoFilaDePaginas() {
        return tamanhoFilaDePaginas;
    }

    public void setTamanhoFilaDePaginas(int tamanhoFilaDePaginas) {
        this.tamanhoFilaDePaginas = tamanhoFilaDePaginas;
    }

    public List<PaginaDTO> getListaPaginasASeremCarregadas() {
        return listaPaginasASeremCarregadas;
    }

    public void setListaPaginasASeremCarregadas(List<PaginaDTO> listaPaginasASeremCarregadas) {
        this.listaPaginasASeremCarregadas = listaPaginasASeremCarregadas;
    }

    public List<PaginaDTO> getMemoriaAtual() {
        return memoriaAtual;
    }

    public void setMemoriaAtual(List<PaginaDTO> memoriaAtual) {
        this.memoriaAtual = memoriaAtual;
    }

    public int getTamanhoMemoria() {
        return tamanhoMemoria;
    }

    public void setTamanhoMemoria(int tamanhoMemoria) {
        this.tamanhoMemoria = tamanhoMemoria;
    }

    public int getTamanhoFila() {
        return tamanhoFilaDePaginas;
    }

    public void setTamanhoFila(int tamanhoFila) {
        this.tamanhoFilaDePaginas = tamanhoFila;
    }

    public List<PaginaDTO> getListaASerCarregada() {
        return listaPaginasASeremCarregadas;
    }

    public void setListaASerCarregada(List<PaginaDTO> listaASerCarregada) {
        this.listaPaginasASeremCarregadas = listaASerCarregada;
    }

}
