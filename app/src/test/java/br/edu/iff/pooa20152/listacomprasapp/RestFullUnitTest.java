package br.edu.iff.pooa20152.listacomprasapp;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.edu.iff.pooa20152.listacomprasapp.helper.RestFullHelper;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class RestFullUnitTest {

    RestFullHelper http;
    JSONObject json;
    String id;

    String durl = "http://listacompras-pooa20162.herokuapp.com/fabricantes";
    //String  durl = "http://localhost:3000/fabricantes";


    @Before
    public void setUp() throws Exception {
        http = new RestFullHelper();
        json = http.doPost(durl + ".json", getParams());
        id = Integer.toString(json.getInt("id")).trim();

    }

    @After
    public void tearDown() throws Exception {
        http.doDelete(durl + "/" + id + ".json");
    }

    @Test
    public void findALL() throws Exception {

        json = http.doGet(durl + ".json");

        assertEquals(26, json.getJSONArray("fabricante").length());

    }

    @Test
    public void doget() throws Exception {

        json = http.doGet(durl + "/" + id + ".json");
        assertEquals("4000", json.getString("numero"));

    }


    @Test
    public void doDelete() throws Exception {
        JSONObject jsond = http.doPost(durl + ".json", getParams());
        String idd = Integer.toString(jsond.getInt("id")).trim();

        jsond = http.doDelete(durl + "/" + idd + ".json");

        assertEquals(null, jsond);
    }

    @Test
    public void doPost() throws Exception {

        assertEquals("Aula", json.getString("nome"));


    }

    @Test
    public void doPut() throws Exception {

        JSONObject oPut = new JSONObject();
        oPut.put("nome", "Gustavo:" + id);
        oPut.put("endereco", "Av Presidente:" + id);
        oPut.put("numero", "400:" + id);
        oPut.put("cnpj", "4010:" + id);

        json = http.doPut(durl + "/" + id + ".json", oPut);

        assertEquals("Gustavo:" + id, json.getString("nome"));


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