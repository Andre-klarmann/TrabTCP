package com.example.todoquest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TarefaCulturaTest {

    @Test
    void testTarefaCulturaInitialization() {
        TarefaCultura tarefa = new TarefaCultura(30, "Visitar Museu", 2);
        assertEquals("Cultura", tarefa.getTipo());
        assertEquals(30, tarefa.getPontos());
        assertEquals("Visitar Museu", tarefa.getDescricao());
        assertEquals(2, tarefa.getBonus());
    }
}
