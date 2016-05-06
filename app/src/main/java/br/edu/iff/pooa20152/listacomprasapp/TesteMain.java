package br.edu.iff.pooa20152.listacomprasapp;

import java.lang.reflect.Field;

import br.edu.iff.pooa20152.listacomprasapp.domain.Fabricante;

/**
 * Created by lglmoura on 03/05/16.
 */
public class TesteMain {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        String durl = "http://localhost:3000/fabricantes";
        durl += ".json";

        Fabricante fab = new Fabricante();
        String nome = fab.getClass().getSimpleName().toLowerCase();
        System.out.println(Fabricante.class.toString() + fab.getClass().toString());

/*

        FabricanteService fs = new FabricanteService();
        List<Fabricante> jf = fs.getWebService(durl,Fabricante.class);
        System.out.println(jf);
*/

        Fabricante ft = new Fabricante();


        Field fe[] = ft.getClass().getDeclaredFields();
        for (Field f : fe) {
            f.setAccessible(true);
            f.set(ft,"aaaaaa");
            System.out.println(f.getName() + " - " + f.get(ft));

        }






    }

}
