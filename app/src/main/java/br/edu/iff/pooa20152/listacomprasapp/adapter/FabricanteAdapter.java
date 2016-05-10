package br.edu.iff.pooa20152.listacomprasapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.edu.iff.pooa20152.listacomprasapp.R;
import br.edu.iff.pooa20152.listacomprasapp.domain.Fabricante;
import br.edu.iff.pooa20152.listacomprasapp.domain.FabricanteService;

/**
 * Created by lglmoura on 09/05/16.
 */
public class FabricanteAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Fabricante> itens;
    private FabricanteService fabricanteService;

    public FabricanteAdapter(Context context, List<Fabricante> itens) {
        this.itens = itens;
        mInflater =LayoutInflater.from(context);
        fabricanteService = new FabricanteService();
    }

    public int getCount() {
        return itens.size();
    }
    public Fabricante getItem(int position) {
        return itens.get(position);
    }
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            view = mInflater.inflate(R.layout.item_fabricante, null);

            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new ItemSuporte();
            itemHolder.txtNome = ((TextView) view.findViewById(R.id.nomeIF));
            itemHolder.txtCnpj = ((TextView) view.findViewById(R.id.cnpjIF));
            ((Button) view.findViewById(R.id.btnDeleteIF)).setTag(position);
            //((Button) view.findViewById(R.id.btnEditIF)).setTag(position);


            //define os itens na view;
            view.setTag(itemHolder);
        } else {
            //se a view já existe pega os itens.
            itemHolder = (ItemSuporte) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        Fabricante item = itens.get(position);
        itemHolder.txtNome.setText(item.getNome());
        itemHolder.txtCnpj.setText(item.getId().toString());


        //retorna a view com as informações
        return view;
    }
    private class ItemSuporte {

        TextView txtNome;
        TextView txtCnpj;

    }

    public void removeItem(int positionToRemove,String url){

        fabricanteService.doDelete(url+"/fabricantes",itens.get(positionToRemove).getId().toString());
        itens.remove(positionToRemove);
        notifyDataSetChanged();
    }
}
