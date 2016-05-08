package br.edu.iff.pooa20152.listacomprasapp.domain;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by lglmoura on 03/05/16.
 */
public class FabricanteService extends GenericService {

    public FabricanteService(String url, String id, String method, JSONObject params) {
        super(url, id, method, params,new Fabricante());
    }
    public FabricanteService(){
        super();
    }

    public List<Fabricante> getAll(String url) {

        List<Fabricante> listaFabricantes = super.getAll(url,new Fabricante());


        return listaFabricantes;

    }



    public Fabricante doGet(String url,String id){

        return (Fabricante) super.doGet(url,id,new Fabricante());
    }

    public Fabricante doDelete(String url,String id){

        return (Fabricante) super.doDelete(url,id);
    }

    public Fabricante doPut(String url, JSONObject params){
        return (Fabricante) super.doPut(url,params,new Fabricante());
    }

    public Fabricante doPost(String url, JSONObject params){
        return (Fabricante) super.doPost(url,params,new Fabricante());
    }

    public Fabricante execute(){
      return (Fabricante) super.execute();
    }

}
