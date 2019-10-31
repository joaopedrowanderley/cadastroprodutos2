/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroprodutos.test;

import br.com.cadastroprodutos.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author joão pedro
 */
public class TesteConexao {
        public static void main(String[] args) throws SQLException{
            
         if(ConnectionFactory.getConnection() != null){
            System.out.println("ok!");
        }else{
            System.out.println("ERRO!");
        }
        }
}
