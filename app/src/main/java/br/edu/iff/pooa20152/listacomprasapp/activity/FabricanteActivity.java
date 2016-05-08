package br.edu.iff.pooa20152.listacomprasapp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.iff.pooa20152.listacomprasapp.R;
import br.edu.iff.pooa20152.listacomprasapp.domain.Fabricante;
import br.edu.iff.pooa20152.listacomprasapp.domain.FabricanteService;
import br.edu.iff.pooa20152.listacomprasapp.helper.RestFullHelper;

public class FabricanteActivity extends AppCompatActivity {

    private final String TAG = "MAIN";
    private EditText etCodigo;
    private EditText etNome;
    private EditText etEndereco;
    private EditText etNumero;
    private EditText etCnpj;
    private Button btConsultar;
    private Button btSalvar;
    private Button btLimpar;
    private Button btDeletar;
    private String durl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabricante);


        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etNome = (EditText) findViewById(R.id.etNome);
        etEndereco = (EditText) findViewById(R.id.etEndereco);
        etNumero = (EditText) findViewById(R.id.etNumero);
        etCnpj = (EditText) findViewById(R.id.etCnpj);

        durl = getString(R.string.URL);
        //durl = "http://192.168.0.50:3000";


        btLimpar = (Button) findViewById(R.id.btLimpar);
        btLimpar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                limpar();

            }
        });

        btConsultar = (Button) findViewById(R.id.btConsutar);
        btConsultar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String filtro = etCodigo.getText().toString();
                if (!filtro.equalsIgnoreCase("")) {

                    getInformationtoAPI();

                }
            }

        });

        btSalvar = (Button) findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etCodigo.getText().toString()))

                    postInformationtoAPI();

                else
                    putInformationtoAPI();
            }

        });

        btDeletar = (Button) findViewById(R.id.btDeletar);
        btDeletar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                deletarInformationtoAPI();


            }
        });

    }


    private void limpar() {

        etCodigo.setText("");
        etNome.setText("");
        etEndereco.setText("");
        etNumero.setText("");
        etCnpj.setText("");

    }

    private void deletarInformationtoAPI() {

        Log.i(TAG, "Deletar ORDER");

        JSONObject params = null;

        FabricanteTask bgtDel = new FabricanteTask(
                durl + "/fabricantes",
                       etCodigo.getText().toString(),
                RestFullHelper.DELETAR, params);
        bgtDel.execute();
        limpar();
    }

    private void getInformationtoAPI() {


        JSONObject params = null;

        FabricanteTask bgtGet = new FabricanteTask(
                durl + "/fabricantes",
                       etCodigo.getText().toString(),
                RestFullHelper.GET, params);

        bgtGet.execute();

    }

    private void postInformationtoAPI() {

        Log.d(TAG, "POSTING ORDER");

        JSONObject params = new JSONObject();

        try {
            params.put("nome", etNome.getText().toString());
            params.put("endereco", etEndereco.getText().toString());
            params.put("numero", etNumero.getText().toString());
            params.put("cnpj", etCnpj.getText().toString());

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        FabricanteTask bgtPost = new FabricanteTask(
                durl + "/fabricantes", null, RestFullHelper.POST, params);
        bgtPost.execute();

    }

    private void putInformationtoAPI() {

        Log.i(TAG, "PUT ORDER");

        JSONObject params = new JSONObject();

        try {
            params.put("id", etCodigo.getText().toString());
            params.put("nome", etNome.getText().toString());
            params.put("endereco", etEndereco.getText().toString());
            params.put("numero", etNumero.getText().toString());
            params.put("cnpj", etCnpj.getText().toString());

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        FabricanteTask bgtPut = new FabricanteTask(
                durl + "/fabricantes",etCodigo.getText().toString(),
                RestFullHelper.PUT, params);
        bgtPut.execute();
        limpar();

    }

    private Context getContext() {


        return this;
    }

    private void alert(String s) {

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }


    public class FabricanteTask extends AsyncTask<String, String, Fabricante> {

        String url = null;
        String method = null;
        String id     = null;
        JSONObject params1 = null;

        ProgressDialog dialog;

        public FabricanteTask(String url, String id, String method,  JSONObject params) {
            this.url = url;
            this.method = method;
            this.params1 = params;
            this.id = id;


        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(FabricanteActivity.this);
            dialog.show();
        }

        @Override
        protected void onPostExecute(Fabricante jsonObject) {

            if (jsonObject != null) {


                etCodigo.setText(jsonObject.getId().toString());
                etNome.setText(jsonObject.getNome());
                etEndereco.setText(jsonObject.getEndereco());
                etNumero.setText(jsonObject.getNumero());
                etCnpj.setText(jsonObject.getCnpj());


            }

            dialog.dismiss();
        }

        @Override
        protected Fabricante doInBackground(String... params) {
            FabricanteService fabricanteService = new FabricanteService(url,id,method,params1);

            Fabricante fabricante = fabricanteService.execute();

            return fabricante;//http.getJSON(url, method, params1);

        }
    }
}
