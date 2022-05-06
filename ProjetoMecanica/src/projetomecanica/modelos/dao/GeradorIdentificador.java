/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomecanica.modelos.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author eugeniojulio"
 */
public class GeradorIdentificador {
   
    public static int getID()throws FileNotFoundException, IOException{
        String nomeDoArquivo ="idGerado.txt";
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br  = new BufferedReader(fr);
        String linha = br.readLine();
        int id = Integer.parseInt(linha);
        br.close();
        id++;
        //cria o arquivo
        FileWriter fw = new FileWriter(nomeDoArquivo, false);
        //Criar o buffer do arquivo
        BufferedWriter bw =new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = id+"";
        bw.write(saida);
        //fecha o arquivo
        bw.close();	
        return id;
    }
    /*public void finalize() throws IOException{
         //cria o arquivo
         FileWriter fw = new FileWriter(nomeDoArquivo,false);
         //Criar o buffer do arquivo
         BufferedWriter bw =new BufferedWriter(fw);
         //Escreve no arquivo
         String saida = id+"";
         bw.write(saida);
         //fecha o arquivo
         bw.close();		
    }*/
    
}
