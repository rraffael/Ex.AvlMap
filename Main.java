/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExAvlMap;

import javax.swing.JOptionPane;

/**
 *
 * @author rraffael
 */
public class Main {
    public static void main(String[] args){
        ProcuraCombustivel app = new ProcuraCombustivel();
         int opcao;
         boolean loop = true;
         while(loop = true){
             opcao = Integer.parseInt(JOptionPane.showInputDialog("0 - Encerrar" + "\n1 - Cadastrar Posto" + "\n2 - Remover Posto" + 
                 "\n3 - Informar disponibilidade de Combustivel, tempo e preco" + "\n4 - Consultar Postos"));
             switch(opcao){
                 case 1: app.CadastrarPosto(JOptionPane.showInputDialog("Nome"), JOptionPane.showInputDialog("Endereco"), 
                         JOptionPane.showInputDialog("Cidade"), JOptionPane.showInputDialog("Estado"), 
                         Double.valueOf(JOptionPane.showInputDialog("Latitude")), 
                         Double.valueOf(JOptionPane.showInputDialog("Longitude")), 
                         Boolean.valueOf(JOptionPane.showInputDialog("Disponibilidade")),
                         Double.valueOf(JOptionPane.showInputDialog("Preço")),
                         Integer.valueOf(JOptionPane.showInputDialog("Tempo de espera em minutos")));
                    break;
                 case 2: app.RemoverPosto(JOptionPane.showInputDialog("Nome"));
                    break;
                 case 3: app.disponibilidadeCombustivel(JOptionPane.showInputDialog("Estado"), 
                         JOptionPane.showInputDialog("Cidade"), JOptionPane.showInputDialog("Nome"));
                    break;
                 case 4: app.consultarPostos(JOptionPane.showInputDialog("Estado"));
                    break;
                 case 0: loop = false;
                     break;
             }
             
         }
         
                
    }
    
}
