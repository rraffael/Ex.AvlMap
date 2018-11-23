/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExAvlMap;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author 1171190899
 */
public class Posto {
    
    private String nome, endereco, Cidade, Estado;
    private double latitude, longitude, preco;
    private boolean disponibilidade;
    private ArrayList<Float> listaTemposFilas;
    
    public static Comparator<Posto> PostoMediaComparator = new Comparator<Posto>() {

        @Override
	public int compare(Posto s1, Posto s2) {
	   int media1 = s1.media10Tempos();
	   int media2 = s2.media10Tempos();

	   //descending order
           if(media2 > media1){
               return media2;
           }else{
               return media1;
           }
    }};
    
    
    public Posto(){}
    
    public Posto(String nome, String endereco, String Cidade, String Estado, double latitude, double longitude, boolean disponibilidade, double preco, float tempoEspera){
        this.nome = nome;
        this.endereco = endereco;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.latitude = latitude;
        this.longitude = longitude;
        this.disponibilidade = disponibilidade;
        this.preco = preco;
        this.listaTemposFilas = new ArrayList<>();
        this.listaTemposFilas.add(tempoEspera);
    }
    
    public void atualizarPosto(float tempoEspera, double preco, boolean disponibilidade){
        this.disponibilidade = disponibilidade;
        this.preco = preco;
        this.listaTemposFilas.add(tempoEspera);
    }
    
    public int media10Tempos(){
        int media = 0;
        int qtdTempos = this.getListaTemposFilas().size();
        for (int i = 0; i < qtdTempos; i++) {
            //Recebe os 10 primeiros tempos ou até onde existir
            media += this.getListaTemposFilas().get(i);
        }
        media = media/qtdTempos;
        return media;
    }
    
    public double distancia(double latitude, double longitude){
        double distancia = 0;
        distancia = Math.sqrt( Math.pow((latitude - this.latitude), 2) + Math.pow((longitude - this.longitude), 2));
        return distancia;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public ArrayList<Float> getListaTemposFilas() {
        return listaTemposFilas;
    }

    public void setListaTemposFilas(ArrayList<Float> listaTemposFilas) {
        this.listaTemposFilas = listaTemposFilas;
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
