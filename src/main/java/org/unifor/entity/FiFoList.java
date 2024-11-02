package org.unifor.entity;

import java.util.List;

public class FiFoList<T> {

    private List<T> listElements;
    private int fim;
    private int inicio;
    private int maxSize;

    public List<T> getListElements() {
        return listElements;
    }

    public int getFim() {
        return fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void setListElements(List<T> listElements) {
        this.listElements = listElements;
    }

    public void adicionarElementoList(T valor){
        if(this.maxSize == this.listElements.size()) {
            throw new IllegalStateException("Fila cheia");
        }
        this.listElements.add(this.fim, valor);
        this.fim = (this.fim + 1) % maxSize;
    }

    public void remover() {
        if(this.listElements.isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        this.listElements.remove(this.inicio);
        this.inicio = (this.inicio + 1) % maxSize;
    }

    public boolean listaCheia() {
        return this.listElements.size() == maxSize;
    }


    public FiFoList(List<T> listElements, int maxSize) {
        this.listElements = listElements;
        this.fim = 0;
        this.inicio = 0;
        this.maxSize = maxSize;
    }
}
