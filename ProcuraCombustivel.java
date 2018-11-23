/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExAvlMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author 1171190899
 */
public class ProcuraCombustivel {
    
    TreeMap<String, ArrayList<Posto>> arvorePostos;
    TreeMap<String, ArrayList<Posto>> arvorePostoEstado;
    
    public ProcuraCombustivel(){
        this.arvorePostos = new TreeMap<>();
        this.arvorePostoEstado = new TreeMap<>();
    }
    
    public Posto CadastrarPosto(String nome, String endereco, String Cidade, String Estado, double latitude, double longitude, boolean disponibilidade, double preco, float tempoFilaMin){
        Posto p1 = new Posto(nome.toLowerCase(), endereco.toLowerCase(), Cidade.toLowerCase(), Estado.toLowerCase(), latitude, longitude, disponibilidade, preco, tempoFilaMin);
        //Registro arvore por nome
        if(this.arvorePostos.containsKey(p1.getNome())){
            this.arvorePostos.get(p1.getNome()).add(p1);
        }else{
            ArrayList<Posto> listaP1 = new ArrayList<>();
            listaP1.add(p1);
            this.arvorePostos.put(p1.getNome(), listaP1);
        }
        //Registro arvore por estado
        if(this.arvorePostoEstado.containsKey(p1.getEstado())){
            this.arvorePostoEstado.get(p1.getEstado()).add(p1);
        }else{
            ArrayList<Posto> listaP1 = new ArrayList<>();
            listaP1.add(p1);
            this.arvorePostoEstado.put(p1.getEstado(), listaP1);
        }
        return p1;
    }
    
    public void RemoverPosto(String nome){
        //remocao arvore nome
        int id = 0;
        if(this.arvorePostos.containsKey(nome)){
            if(this.arvorePostos.get(nome).size() > 1){
                for(int i = 0; i < this.arvorePostos.get(nome).size(); i++){
                    JOptionPane.showMessageDialog(null, i + " = " + this.arvorePostos.get(nome).get(i).getEndereco());
                }
               id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do endereco"));
               this.arvorePostos.get(nome).remove(id);
            }else{
                this.arvorePostos.remove(nome);
            }
        }
        //remocao arvore estado
        String estado = this.arvorePostos.get(nome).get(id).getEstado();
        if(this.arvorePostoEstado.containsKey(estado)){
            if(this.arvorePostoEstado.get(estado).size() > 1){
                for(int i = 0; i < this.arvorePostoEstado.get(estado).size(); i++){
                    if(this.arvorePostoEstado.get(estado).get(i).getNome().equals(nome)){
                        this.arvorePostoEstado.get(estado).remove(i);
                    }
                }
            }else{
                this.arvorePostoEstado.remove(estado); 
            }
        }
    }
        
    public void consultarPostos(String estado){
        String opcao, cidade = null, ordem;
        boolean disponibilidade = false;
        
        //Faz o registro da cidade se desejar
        opcao = JOptionPane.showInputDialog("Deseja filtrar por cidade?").toLowerCase();
        if(opcao.equals("sim")){
           cidade = JOptionPane.showInputDialog("Digite o nome da cidade").toLowerCase();
           
        }
        //Faz o registro da disponibilidade se existir
        opcao = JOptionPane.showInputDialog("Deseja filtrar por disponibilidade de combustivel?").toLowerCase();
            if(opcao.equals("sim")){
                disponibilidade = true;
            }
        //Faz a escolha de filtro por proximidade ou espera
        ordem = JOptionPane.showInputDialog("Deseja filtrar por 'proximidade' ou menor tempo de 'espera' na fila?").toLowerCase();
        //Adiciona todos os postos de um estado
        ArrayList<Posto> res = this.arvorePostoEstado.get(estado);
        
        //filtra pela cidade (se) escolhida
        if(cidade != null){
            for(int i = 0; i < res.size(); i++){
                if(!res.get(i).getCidade().equals(cidade)){
                    res.remove(i);
                }
            }
        }
        //filtra pela disponibilidade (se) escolhida
        if(disponibilidade = true){
            for(int i = 0; i < res.size(); i++){
                if(res.get(i).isDisponibilidade() == false){
                    res.remove(i);
                }
            }
        }
        //Retornar por ordem de proximidade ou espera
        if(ordem.equals("proximidade")){
            double latitudeAtual =  Integer.parseInt(JOptionPane.showInputDialog("Digite sua latitude atual"));
            double longitudeAtual = Integer.parseInt(JOptionPane.showInputDialog("Digite sua longitude atual"));
            boolean ordenado = false;
            while(ordenado = false){
                ordenado = true;
                for (int i = 0; i < res.size()-1; i++){
                    if(res.get(i).distancia(latitudeAtual, longitudeAtual) > res.get(i+1).distancia(latitudeAtual, longitudeAtual)){
                        Posto temp = res.get(i);
                        res.set(i, res.get(i+1));
                        res.set(i+1, temp);
                        ordenado = false;
                    }
                }
            }
         }else{
            Collections.sort(res, Posto.PostoMediaComparator);
        }
        
        String mensagem = "";
        
        for(int i = 0; i < res.size(); i++){
            mensagem += i + " - " + res.get(i).getNome() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public void disponibilidadeCombustivel(String estado, String cidade, String nome){
       String disponibilidade = "", preco = "", tempo = "";
       
        for(int i = 0; i < this.arvorePostos.get(nome).size(); i++){
            if(this.arvorePostos.get(nome).get(i).getEstado().equals(estado)){
                if(this.arvorePostos.get(nome).get(i).getCidade().equals(cidade)){
                    Posto p1 = this.arvorePostos.get(nome).get(i);
                    disponibilidade = String.valueOf(p1.isDisponibilidade());
                    if(disponibilidade.equals("true")){
                        preco = String.valueOf(p1.getPreco());
                    }
                    tempo = String.valueOf(p1.media10Tempos());
                }
            }
        }
        String mensagem = (disponibilidade + " " + preco + " " + tempo);
        //informar disponibilidade, (se tiver disponivel) preco, tempo
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    
    
    
    
}
