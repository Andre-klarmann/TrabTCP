package com.example.todoquest;

public class TarefaCultura extends Tarefa{
    private int bonusCultura;

    TarefaCultura(int pontos, String descricao, int bonus){
        super("Cultura", pontos, descricao);
        this.bonusCultura = bonus;
    }

    public int getBonus(){
        return this.bonusCultura;
    }
}