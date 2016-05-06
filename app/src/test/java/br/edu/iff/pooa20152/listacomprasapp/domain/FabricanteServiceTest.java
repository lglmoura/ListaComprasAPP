package br.edu.iff.pooa20152.listacomprasapp.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lglmoura on 05/05/16.
 */
public class FabricanteServiceTest {
    private FabricanteService fs;
    private String  durl;
    private List<Fabricante> jf;

    @Before
    public void setUp() throws Exception {
        durl = "http://listacompras-pooa20162.herokuapp.com/fabricantes";
        //durl = "http://localhost:3000/fabricantes";
        durl+=".json";
        FabricanteService fs = new FabricanteService();
        Fabricante fab = new Fabricante();

        jf = fs.getAll(durl,fab);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {

        assertEquals(26,jf.size());


    }


}