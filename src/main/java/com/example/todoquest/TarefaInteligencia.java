package com.example.todoquest;

public class TarefaInteligencia extends Tarefa{
    private int bonusInteligencia;

    TarefaInteligencia(int pontos, String descricao, int bonus){
        super("Inteligencia", pontos, descricao);
        this.bonusInteligencia = bonus;
    }

    public int getBonus(){
        return this.bonusInteligencia;
    }
}
