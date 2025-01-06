package com.example.todoquest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("TestUser");
    }

    @Test
    void testGetAndSetNome() {
        assertEquals("TestUser", usuario.getNome());
        usuario.setNome("NewName");
        assertEquals("NewName", usuario.getNome());
    }

    @Test
    void testAttributes() {
        usuario.setForca(10);
        usuario.setInteligencia(20);
        usuario.setCultura(15);
        usuario.setSorte(5);
        usuario.setHistorico(2);
        usuario.setNivel(4);

        assertEquals(10, usuario.getForca());
        assertEquals(20, usuario.getInteligencia());
        assertEquals(15, usuario.getCultura());
        assertEquals(5, usuario.getSorte());
        assertEquals(2, usuario.getHistorico());
        assertEquals(4, usuario.getNivel());
    }
}
