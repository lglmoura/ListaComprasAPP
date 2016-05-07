package br.edu.iff.pooa20152.listacomprasapp.domain;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import br.edu.iff.pooa20152.listacomprasapp.helper.RestFullHelper;

import static junit.framework.Assert.assertEquals;

/**
 * Created by lglmoura on 05/05/16.
 */
public class FabricanteServiceTest {

    private FabricanteService fabricanteService;
    private String  durl;
    private List<Fabricante> listaFabricante;
    private Fabricante fabricante;
    RestFullHelper http;
    JSONObject json;
    String id;

    @Before
    public void setUp() throws Exception {
        //durl = "http://listacompras-pooa20162.herokuapp.com/fabricantes";
        durl = "http://localhost:3000/fabricantes";

        fabricanteService = new FabricanteService();
        http = new RestFullHelper();

        json = http.doPost(durl + ".json", getParams());
        id = Integer.toString(json.getInt("id")).trim();

    }

    @After
    public void tearDown() throws Exception {
       fabricanteService.doDelete(durl + "/" + id + ".json");

    }

    @Test
    public void testgoGet() throws Exception{

        fabricante = fabricanteService.doGet(durl+ "/" + id + ".json");

        assertEquals("Aula",fabricante.getNome());
    }

    @Test
    public void doDelete() throws Exception {
        JSONObject jsond = http.doPost(durl + ".json", getParams());
        String idd = Integer.toString(jsond.getInt("id")).trim();

        fabricante = fabricanteService.doDelete(durl + "/" + idd + ".json");

        Assert.assertEquals(null, fabricante);
    }

    @Test
    public void testGetAll() throws Exception {

        listaFabricante = fabricanteService.getAll(durl+".json");

        assertEquals(11,listaFabricante.size());


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