package br.edu.iff.pooa20152.listacomprasapp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import br.edu.iff.pooa20152.listacomprasapp.R;
import br.edu.iff.pooa20152.listacomprasapp.adapter.FabricanteAdapter;
import br.edu.iff.pooa20152.listacomprasapp.domain.Fabricante;
import br.edu.iff.pooa20152.listacomprasapp.domain.FabricanteService;

public class FabricanteListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private FabricanteAdapter fabricanteAdapter;
    private ArrayList<Fabricante> itens;
    private String durl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faabricante_list);
        //Pega a referencia do ListView

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        listView = (ListView) findViewById(R.id.fabricanteList);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);
        this.durl = getString(R.string.URL);

        createListView();
    }

    private void createListView() {
        FabricanteService fabricanteService = new FabricanteService();

        //Criamos nossa lista que preenchera o ListView
        itens = (ArrayList<Fabricante>) fabricanteService.getAll(this.durl + "/fabricantes");

        //Cria o adapter
        this.fabricanteAdapter = new FabricanteAdapter(this, itens);

        //Define o Adapter
        listView.setAdapter(this.fabricanteAdapter);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Fabricante fabricante = (Fabricante) adapterView.getAdapter().getItem(i);

        Intent intent = new Intent(getContext(), FabricanteNewActivity.class);
        //Bundle params = new Bundle();
        //params.put("fabricante", (Parcel) fabricante);

        intent.putExtra("fabricante", (Serializable) fabricante);
        startActivity(intent);

    }

    private Context getContext() {

        return this;
    }

    public void deletaItem(View v) {

        this.fabricanteAdapter.removeItem((Integer) v.getTag(), durl);
    }

    public void editaItem(View v) {

        Fabricante s = (Fabricante) fabricanteAdapter.getItem((Integer) v.getTag());


    }

}
