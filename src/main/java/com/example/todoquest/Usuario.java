package com.example.todoquest;


public class Usuario {
    private String nome;
    private int inteligencia;
    private int forca;
    private int cultura;
    private int sorte;
    private int historico;
    private int nivel;

    Usuario(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getCultura() {
        return cultura;
    }

    public void setCultura(int cultura) {
        this.cultura = cultura;
    }

    public int getSorte() {
        return sorte;
    }

    public void setSorte(int sorte) {
        this.sorte = sorte;
    }

    public int getHistorico() {
        return historico;
    }

    public void setHistorico(int historico) {
        this.historico = historico;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }





}