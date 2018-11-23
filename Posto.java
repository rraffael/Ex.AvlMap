/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExAvlMap;

/**
 *
 * @author 1171190899
 */
public class Posto {
    
    private String nome, endereco, Cidade, Estado;
    private double latitude, longitude, preco;
    private boolean disponibilidade;
    private int tempoFila;
    
    
    
    public Posto(){}
    
    public Posto(String nome, String endereco, String Cidade, String Estado, double latitude, double longitude){
        this.nome = nome;
        this.endereco = endereco;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    
    
}
