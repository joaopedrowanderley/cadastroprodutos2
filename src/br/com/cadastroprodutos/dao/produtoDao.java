/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroprodutos.dao;

import br.com.cadastroprodutos.model.Especificacao;
import br.com.cadastroprodutos.model.Produto;
import br.com.cadastroprodutos.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joão pedro
 */
public class produtoDao {
            private Connection con;
            private String sql;
            private PreparedStatement st;
            private ResultSet rs;
            
            public void inserir(Produto produto) throws SQLException{
                con = ConnectionFactory.getConnection();
                
                sql = "insert into especificacao (fabricante, cor,sistema,detalhes) values (?,?,?,?)";
        
       
                 st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
                st.setString(1, produto.getEspecificacao().getFabricante());
                st.setString(2, produto.getEspecificacao().getCor());
                st.setString(3, produto.getEspecificacao().getSistema());
                st.setString(4, produto.getEspecificacao().getDetalhes());
        
                st.executeUpdate();
        
                rs = st.getGeneratedKeys();
        
                int codigoEspecificacao = 0;
        
                if(rs.next()){
                    codigoEspecificacao = rs.getInt(1);
                }
        
        
                sql = "insert into produtos (nome, preco,codigo_especificacao) values (?,?,?)";
        
                st = con.prepareStatement(sql);
        
                st.setString(1, produto.getNome());
                st.setFloat(2, produto.getPreco());
                st.setInt(3, codigoEspecificacao);
        
                st.executeUpdate();
        
                con.close();
          }
          
            public void editar(Produto produto) throws SQLException{
                 con = ConnectionFactory.getConnection();
                 
                 sql = "update produtos set nome = ?, preco = ? where codigo = ?";
                 
                 st= con.prepareStatement(sql);
                 
                 st.setString(1,produto.getNome());
                 st.setFloat(2, produto.getPreco());
                 st.setInt(3, produto.getCodigo());
                 
                 st.executeUpdate();
                 
                 con.close();
            }
          
            public void remover(Produto produto) throws SQLException{
                 con = ConnectionFactory.getConnection();
                 
                 sql = "delete from produtos where codigo = ?";
                 
                 st=con.prepareStatement(sql);
                 
                 st.setInt(1,produto.getCodigo());
                 
                 st.executeUpdate();
                 
                 con.close();
            }
            
            public List<Produto> listar() throws SQLException{
                List<Produto> produtos = new ArrayList<>();
                con = ConnectionFactory.getConnection();
                sql = "select p.*, e.* from produtos p, especificacao e where p.codigo_especificacao = e.codigo";
                st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                 while(rs.next()){
                        int codigo = rs.getInt(1);
                        String nome = rs.getString("nome");
                        float preco = rs.getFloat("preco");
                       String fabricante = rs.getString("fabricante");
                       String cor = rs.getString("cor");
                       String sistema = rs.getString("sistema");
                       String detalhes = rs.getString("detalhes");
                       int codigoEspecificacao = rs.getInt("codigo_especificacao");
            
                        Produto p = new Produto();
                        p.setEspecificacao(new Especificacao());
            
                        p.setCodigo(codigo);
                        p.setNome(nome);
                        p.setPreco(preco);
                        p.getEspecificacao().setCodigo(codigoEspecificacao);
                        p.getEspecificacao().setFabricante(fabricante);
                        p.getEspecificacao().setCor(cor);
                        p.getEspecificacao().setSistema(sistema);
                        p.getEspecificacao().setDetalhes(detalhes);
            
                        produtos.add(p);
                  }
                 con.close();
                return produtos;
            }
            public Produto buscar(int codigo) throws SQLException{
                Produto p= null;
                con = ConnectionFactory.getConnection();
                sql = "select p.*, e.* from produtos p, especificacao e where p.codigo = ? and p.codigo_especificacao = e.codigo ";
                st = con.prepareStatement(sql);
                st.setInt(1, codigo);
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    String nome = rs.getString("nome");
                    float preco = rs.getFloat("preco");
                    p = new Produto();
                    p.setCodigo(codigo);
                    p.setNome(nome);
                    p.setPreco(preco);
                }
                con.close();
                return p;
            }
}
