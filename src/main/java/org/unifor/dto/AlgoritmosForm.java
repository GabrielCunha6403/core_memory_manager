package org.unifor.dto;

import java.util.List;

public class AlgoritmosForm {

    private List<Integer> listaElementos;
    private List<Integer> listaASerCarregada;
    private int tamanhoPagina;
    private int tamanhoMaximo;


    public AlgoritmosForm(List<Integer> listaElementos, List<Integer> listaASerCarregada, int tamanhoPagina, int tamanhoMaximo) {
        this.listaElementos = listaElementos;
        this.listaASerCarregada = listaASerCarregada;
        this.tamanhoPagina = tamanhoPagina;
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public int getTamanhoMaximo() {
        return tamanhoMaximo;
    }

    public void setTamanhoMaximo(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public List<Integer> getListaASerCarregada() {
        return listaASerCarregada;
    }

    public void setListaASerCarregada(List<Integer> listaASerCarregada) {
        this.listaASerCarregada = listaASerCarregada;
    }

    public int getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(int tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }

    public List<Integer> getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(List<Integer> listaElementos) {
        this.listaElementos = listaElementos;
    }
}
