package br.edu.iff.pooa20152.listacomprasapp.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lglmoura on 03/05/16.
 */
public class FabricanteDomainTest {
    private Fabricante fab;
    @Before
    public void setUp() throws Exception {
        fab = new Fabricante("01","coca","Rau 01","400","1234567890");

    }

    @After
    public void tearDown() throws Exception {
       fab = null;
    }

    @Test
    public void testGetCodigo() throws Exception {
        assertEquals("01", fab.getCodigo());
    }

    @Test
    public void testSetCodigo() throws Exception {
        fab.setCodigo("02");
        assertEquals("02", fab.getCodigo());
    }

    @Test
    public void testGetNome() throws Exception {

        assertEquals("coca", fab.getNome());

    }

    @Test
    public void testSetNome() throws Exception {
        fab.setNome("Fanta");
        assertEquals("Fanta", fab.getNome());
    }

    @Test
    public void testGetEndereco() throws Exception {

        assertEquals("Rau 01", fab.getEndereco());

    }

    @Test
    public void testSetEndereco() throws Exception {
        fab.setEndereco("Rua");
        assertEquals("Rua", fab.getEndereco());

    }

    @Test
    public void testGetNumero() throws Exception {

        assertEquals("400", fab.getNumero());

    }

    @Test
    public void testSetNumero() throws Exception {
        fab.setNumero("02");
        assertEquals("02", fab.getNumero());

    }

    @Test
    public void testGetCnpj() throws Exception {
        assertEquals("1234567890",fab.getCnpj());

    }

    @Test
    public void testSetCnpj() throws Exception {
        fab.setCnpj("02");
        assertEquals("02", fab.getCnpj());

    }

}