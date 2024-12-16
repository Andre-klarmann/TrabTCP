package com.example.todoquest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TarefaInteligenciaTest {

    @Test
    void testTarefaInteligenciaInitialization() {
        TarefaInteligencia tarefa = new TarefaInteligencia(40, "Estudar Matematica", 3);
        assertEquals("Inteligencia", tarefa.getTipo());
        assertEquals(40, tarefa.getPontos());
        assertEquals("Estudar Matematica", tarefa.getDescricao());
        assertEquals(3, tarefa.getBonus());
    }
}
