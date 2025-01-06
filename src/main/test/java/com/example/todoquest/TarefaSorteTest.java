package com.example.todoquest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TarefaSorteTest {

    @Test
    void testTarefaSorteInitialization() {
        TarefaSorte tarefa = new TarefaSorte(25, "Jogar Loteria", 1);
        assertEquals("Sorte", tarefa.getTipo());
        assertEquals(25, tarefa.getPontos());
        assertEquals("Jogar Loteria", tarefa.getDescricao());
        assertEquals(1, tarefa.getBonus());
    }
}
