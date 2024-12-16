package com.example.todoquest;

import java.util.ArrayList;

public class GerenciadorTarefas {
    private ArrayList<TarefaForca> tarefasForca;
    private ArrayList<TarefaInteligencia> tarefasInteligencia;
    private ArrayList<TarefaSorte> tarefasSorte;
    private ArrayList<TarefaCultura> tarefasCultura;

    private int totalForcaTaskCompleted;
    private int totalInteligenciaTaskCompleted;
    private int totalSorteTaskCompleted;
    private int totalCulturaTaskCompleted;

    private int totalForcaTasks;
    private int totalInteligenciaTasks;
    private int totalSorteTasks;
    private int totalCulturaTasks;

    public GerenciadorTarefas() {
        this.tarefasForca = new ArrayList<>();
        this.tarefasInteligencia = new ArrayList<>();
        this.tarefasSorte = new ArrayList<>();
        this.tarefasCultura = new ArrayList<>();

        this.totalForcaTaskCompleted = 0;
        this.totalInteligenciaTaskCompleted = 0;
        this.totalSorteTaskCompleted = 0;
        this.totalCulturaTaskCompleted = 0;

        this.totalForcaTasks = 0;
        this.totalInteligenciaTasks = 0;
        this.totalSorteTasks = 0;
        this.totalCulturaTasks = 0;
    }

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
                totalForcaTasks++;
                break;
            case "inteligencia":
                tarefasInteligencia.add(new TarefaInteligencia(pontos, descricao, bonus));
                totalInteligenciaTasks++;
                break;
            case "sorte":
                tarefasSorte.add(new TarefaSorte(pontos, descricao, bonus));
                totalSorteTasks++;
                break;
            case "cultura":
                tarefasCultura.add(new TarefaCultura(pontos, descricao, bonus));
                totalCulturaTasks++;
                break;
            default:
                System.out.println("Tipo de tarefa desconhecido: " + tipo);
                break;
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

    public int getTotalForcaTasks() {
        return this.totalForcaTasks;
    }

    public int getTotalInteligenciaTasks() {
        return this.totalInteligenciaTasks;
    }

    public int getTotalSorteTasks() {
        return this.totalSorteTasks;
    }

    public int getTotalCulturaTasks() {
        return this.totalCulturaTasks;
    }

    public void completeForcaTask() {
        totalForcaTaskCompleted++;
    }

    public void completeInteligenciaTask() {
        totalInteligenciaTaskCompleted++;
    }

    public void completeSorteTask() {
        totalSorteTaskCompleted++;
    }

    public void completeCulturaTask() {
        totalCulturaTaskCompleted++;
    }

    public int getTotalForcaTaskCompleted() {
        return totalForcaTaskCompleted;
    }

    public int getTotalInteligenciaTaskCompleted() {
        return totalInteligenciaTaskCompleted;
    }

    public int getTotalSorteTaskCompleted() {
        return totalSorteTaskCompleted;
    }

    public int getTotalCulturaTaskCompleted() {
        return totalCulturaTaskCompleted;
    }


}
