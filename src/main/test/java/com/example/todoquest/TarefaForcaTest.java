package com.example.todoquest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TarefaForcaTest {

    @Test
    void testTarefaForcaInitialization() {
        TarefaForca tarefa = new TarefaForca(50, "Treino de Peito", 5);
        assertEquals("Força", tarefa.getTipo());
        assertEquals(50, tarefa.getPontos());
        assertEquals("Treino de Peito", tarefa.getDescricao());
        assertEquals(5, tarefa.getBonus());
    }
}
