package br.edu.iff.pooa20152.listacomprasapp.domain;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.pooa20152.listacomprasapp.helper.RestFullHelper;

/**
 * Created by lglmoura on 03/05/16.
 */
public abstract class GenericService {

    private static String TAG = "GenericService";
    public boolean LOG_ON = false;

    /////Context context,
    public <T> List<T> getAll(String url, Object domain) {

        RestFullHelper http = new RestFullHelper();

        JSONObject json = http.doGet(url);

        if (LOG_ON) {
            Log.d(TAG, "URL -> " + url);

        }
        /* context, */
        List<T> lista = null;

        lista = parserJSON(json, domain);


        return lista;
    }

    ///private static , Context context,
    public <T> List<T> parserJSON(JSONObject obj, Object domain) {
        List<T> listas = new ArrayList<T>();

        try {

            JSONArray AjsonDomain = obj.getJSONArray(domain.getClass().getSimpleName().toLowerCase());
            // Insere cada carro na lista
            for (int i = 0; i < AjsonDomain.length(); i++) {
                JSONObject jsonDomain = AjsonDomain.getJSONObject(i);

                listas.add((T) instanceObject(jsonDomain, domain));


            }
            if (LOG_ON) {
                Log.d(TAG, " encontrados.");
            }
        } catch (JSONException e) {
            try {
                throw new IOException(e.getMessage(), e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        return listas;
    }


    private Object instanceObject(JSONObject jsonDomain, Object domain) {
        Object oClass = null;
        try {
            oClass = domain.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field fe[] = oClass.getClass().getDeclaredFields();

        for (Field f : fe) {
            f.setAccessible(true);

            try {
                f.set(oClass, jsonDomain.get(f.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return oClass;
    }


}
