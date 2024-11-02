package org.unifor.dto;

import org.unifor.entity.Pagina;

import java.util.List;

public class AlgoritmosForm {
    private List<PaginaDTO> memoriaAtual;
    private List<String> listaElementos;
    private List<PaginaDTO> listaPaginasASeremCarregadas;
    private int tamanhoPagina;
    private int tamanhoMaximo;
    private int tamanhoMemoria;
    private int tamanhoFilaDePaginas;

    public AlgoritmosForm(List<PaginaDTO> memoriaAtual, int tamanhoFila, int tamanhoMemoria, int tamanhoMaximo, int tamanhoPagina, List<PaginaDTO> listaASerCarregada, List<String> listaElementos) {
        this.memoriaAtual = memoriaAtual;
        this.tamanhoFilaDePaginas = tamanhoFila;
        this.tamanhoMemoria = tamanhoMemoria;
        this.tamanhoMaximo = tamanhoMaximo;
        this.tamanhoPagina = tamanhoPagina;
        this.listaPaginasASeremCarregadas = listaASerCarregada;
        this.listaElementos = listaElementos;
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

    public int getTamanhoMaximo() {
        return tamanhoMaximo;
    }

    public void setTamanhoMaximo(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public List<PaginaDTO> getListaASerCarregada() {
        return listaPaginasASeremCarregadas;
    }

    public void setListaASerCarregada(List<PaginaDTO> listaASerCarregada) {
        this.listaPaginasASeremCarregadas = listaASerCarregada;
    }

    public int getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(int tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }

    public List<String> getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(List<String> listaElementos) {
        this.listaElementos = listaElementos;
    }
}
