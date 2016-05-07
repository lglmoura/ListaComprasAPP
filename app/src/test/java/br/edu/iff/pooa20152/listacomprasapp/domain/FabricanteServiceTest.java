package br.edu.iff.pooa20152.listacomprasapp.domain;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by lglmoura on 05/05/16.
 */
public class FabricanteServiceTest {

    private FabricanteService fabricanteService;
    private String  durl;
    private List<Fabricante> listaFabricante;
    private Fabricante fabricante;

    JSONObject json;
    String id;

    @Before
    public void setUp() throws Exception {
        durl = "http://listacompras-pooa20162.herokuapp.com/fabricantes";
        //durl = "http://localhost:3000/fabricantes";

        fabricanteService = new FabricanteService();

        fabricante = fabricanteService.doPost(durl, getParams());
        id = Integer.toString(fabricante.getId()).trim();

    }

    @After
    public void tearDown() throws Exception {
       fabricanteService.doDelete(durl + "/" + id + ".json");

    }

    @Test
    public void test_goGet() throws Exception{

        fabricante = fabricanteService.doGet(durl,id);

        assertEquals("Aula",fabricante.getNome());
    }


    @Test
    public void test_doPut() {

        JSONObject oPut = new JSONObject();
        try {
            oPut.put("id",id);
            oPut.put("nome", "Gustavo:" + id);
            oPut.put("endereco", "Av Presidente:" + id);
            oPut.put("numero", "400:" + id);
            oPut.put("cnpj", "4010:" + id);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        fabricante = fabricanteService.doPut(durl , oPut);

        Assert.assertEquals("Gustavo:" + id, fabricante.getNome());


    }

    @Test
    public void test_doPost() {



        Assert.assertEquals("Aula", fabricante.getNome());


    }

    @Test
    public void test_doDelete() throws Exception {
        Fabricante fabricanted = fabricanteService.doPost(durl, getParams());
        String idd = Integer.toString(fabricanted.getId()).trim();

        fabricante = fabricanteService.doDelete(durl + "/" + idd + ".json");

        Assert.assertEquals(null, fabricante);
    }

    @Test
    public void testGetAll() throws Exception {

        listaFabricante = fabricanteService.getAll(durl);

        assertEquals(29,listaFabricante.size());


    }

    private JSONObject getParams() {
        JSONObject params = new JSONObject();
        try {
            params.put("nome", "Aula");
            params.put("endereco", "AV PV");
            params.put("numero", "4000");
            params.put("cnpj", "400:" + id);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return params;
    }



}