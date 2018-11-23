/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExAvlMap;

import java.util.ArrayList;
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
    
    public Posto CadastrarPosto(String nome, String endereco, String Cidade, String Estado, double latitude, double longitude){
        Posto p1 = new Posto(nome, endereco, Cidade, Estado, latitude, longitude);
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
    
    public String RemoverPosto(String nome){
        if(this.arvorePostos.containsKey(nome)){
            if(this.arvorePostos.get(nome).size() > 1){
                for(int i = 0; i < this.arvorePostos.size(); i++){
                    JOptionPane.showMessageDialog(null, i + " = " + this.arvorePostos.get(nome).get(i).getEndereco());
                }
               int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do endereco"));
               this.arvorePostoEstado.get(this.arvorePostos.get(nome).get(id).getEstado()).remove(id);
               this.arvorePostos.get(nome).remove(id);
               return nome;
            }
            
            //this.arvorePostoEstado.get(this.arvorePostos.get(nome).get(id).getEstado()).remove(id);
            this.arvorePostos.remove(nome);
            return nome;
        }
        return null;
    }
    
    public void informacaoPosto(){
        
    }
    
    public void consultarPostos(String estado){
        String opcao = JOptionPane.showInputDialog("Deseja filtrar por cidade?");
        if(opcao.toLowerCase().equals("sim")){
           // this.arvorePostos.gz
        }
        
        opcao = JOptionPane.showInputDialog("Deseja filtrar por disponibilidade de combustivel?");
        if(opcao.toLowerCase().equals("sim")){
            String nome = JOptionPane.showInputDialog("Insira o nome do posto");
            
        }
    }
    
    
    
}
