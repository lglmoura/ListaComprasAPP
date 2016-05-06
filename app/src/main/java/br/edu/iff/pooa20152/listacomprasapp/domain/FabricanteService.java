package br.edu.iff.pooa20152.listacomprasapp.domain;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lglmoura on 03/05/16.
 */
public class FabricanteService extends GenericService {

    public List<Fabricante> getAll(String url, Fabricante domain) {

        List<Fabricante> listaFabricantes = super.getAll(url, domain);

       /*

       for(Fabricante fab : listaFabricantes){
           System.out.println("id "+ fab.getId()+" Nome: "+fab.getNome());
       }

*/

        return listaFabricantes;

    }

    public List<Fabricante> listaFabricante(JSONObject json, Fabricante domain) {
        List<Fabricante> lfab = new ArrayList<Fabricante>();

        lfab = super.parserJSON(json, domain);

        return lfab;
    }
}
