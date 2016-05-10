package br.edu.iff.pooa20152.listacomprasapp.domain;

import org.parceler.Parcel;

/**
 * Created by lglmoura on 03/05/16.
 */

public class Fabricante implements Serializable{

    private Integer id;
    private String nome;
    private String endereco;
    private String numero;
    private String cnpj;

    public Fabricante(Integer id, String nome, String endereco, String numero, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.cnpj = cnpj;
    }

    public Fabricante() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Fabricante{" +
                "id=" + id +
                '}';
    }
}
