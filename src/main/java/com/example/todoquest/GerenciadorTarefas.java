package com.example.todoquest;

import java.util.ArrayList;

public class GerenciadorTarefas {
    private ArrayList<TarefaForca> tarefasForca;
    private ArrayList<TarefaInteligencia> tarefasInteligencia;
    private ArrayList<TarefaSorte> tarefasSorte;
    private ArrayList<TarefaCultura> tarefasCultura;

    public GerenciadorTarefas() {
        this.tarefasForca = new ArrayList<>();
        this.tarefasInteligencia = new ArrayList<>();
        this.tarefasSorte = new ArrayList<>();
        this.tarefasCultura = new ArrayList<>();
    }
    // Existing constructor and methods...

    public ArrayList<TarefaForca> getTarefasForca() {
        return tarefasForca;
    }

    public ArrayList<TarefaInteligencia> getTarefasInteligencia() {
        return tarefasInteligencia;
    }

    public ArrayList<TarefaSorte> getTarefasSorte() {
        return tarefasSorte;
    }

    public ArrayList<TarefaCultura> getTarefasCultura() {
        return tarefasCultura;
    }
    //Adiciona uma nova tarefa ao arraylist apropriado.

    public void criaTarefa(String tipo, int pontos, String descricao, int bonus) {
        switch (tipo.toLowerCase()) {
            case "forca":
                tarefasForca.add(new TarefaForca(pontos, descricao, bonus));
                break;
            case "inteligencia":
                tarefasInteligencia.add(new TarefaInteligencia(pontos, descricao, bonus));
                break;
            case "sorte":
                tarefasSorte.add(new TarefaSorte(pontos, descricao, bonus));
                break;
            case "cultura":
                tarefasCultura.add(new TarefaCultura(pontos, descricao, bonus));
                break;
            default:
                System.out.println("Tipo de tarefa desconhecido: " + tipo);
        }
    }


    //Remove uma tarefa do arraylist apropriado pelo índice.
    //Retorna true se a tarefa foi removida com sucesso, false caso contrário.
    public boolean deletaTarefa(String tipo, int indice) {
        switch (tipo.toLowerCase()) {
            case "forca":
                if (indice >= 0 && indice < tarefasForca.size()) {
                    tarefasForca.remove(indice);
                    return true;
                }
                break;
            case "inteligencia":
                if (indice >= 0 && indice < tarefasInteligencia.size()) {
                    tarefasInteligencia.remove(indice);
                    return true;
                }
                break;
            case "sorte":
                if (indice >= 0 && indice < tarefasSorte.size()) {
                    tarefasSorte.remove(indice);
                    return true;
                }
                break;
            case "cultura":
                if (indice >= 0 && indice < tarefasCultura.size()) {
                    tarefasCultura.remove(indice);
                    return true;
                }
                break;
            default:
                System.out.println("Tipo de tarefa desconhecido: " + tipo);
        }
        return false;
    }
}
