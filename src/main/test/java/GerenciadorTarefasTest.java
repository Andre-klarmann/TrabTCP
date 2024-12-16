package com.example.todoquest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GerenciadorTarefasTest {
    private GerenciadorTarefas gerenciador;

    @BeforeEach
    void setUp() {
        gerenciador = new GerenciadorTarefas();
    }


    @Test
    void testDeletaTarefaInvalidIndex() {
        gerenciador.criaTarefa("forca", 50, "Exercício", 5);
        boolean removed = gerenciador.deletaTarefa("forca", 1); // no index 1
        assertFalse(removed);
        assertEquals(1, gerenciador.getTarefasForca().size());
    }

    @Test
    void testDeletaTarefaInvalidTipo() {
        gerenciador.criaTarefa("forca", 50, "Exercício", 5);
        boolean removed = gerenciador.deletaTarefa("invalido", 0);
        assertFalse(removed);
        assertEquals(1, gerenciador.getTarefasForca().size());
    }
}
