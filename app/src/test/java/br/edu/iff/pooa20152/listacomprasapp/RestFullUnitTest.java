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
    String durl = "http://doml-pooa20152.herokuapp.com/empregadors";


    @Before
    public void setUp() throws Exception {
        http = new RestFullHelper();
        json = http.doPost(durl + ".json", getParams());
        id = Integer.toString(json.getInt("id")).trim();

    }

    @After
    public void tearDown() throws Exception {


    }


    @Test
    public void doget() throws Exception {

        json = http.doGet(durl + "/" + id + ".json");

        assertEquals("4000", json.getString("numero"));
        //http.doDelete(durl+"/"+id+".json");
    }


    @Test
    public void doPost() throws Exception {

        assertEquals("luiz", json.getString("nome"));
        //http.doDelete(durl+"/"+id+".json");

    }

    private JSONObject getParams() {
        JSONObject params = new JSONObject();
        try {
            params.put("nome", "luiz");
            params.put("endereco", "AV PV");
            params.put("numero", "4000");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return params;
    }

}