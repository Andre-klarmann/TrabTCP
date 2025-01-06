package com.example.todoquest;

public class TarefaCultura extends Tarefa{
    private int bonusCultura;

    TarefaCultura(int pontos, String descricao, int bonus){
        super("Cultura", pontos, descricao);
        this.bonusCultura = 0;
    }

    public int getBonus(){
        return this.bonusCultura;
    }
}