/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroprodutos.model;

/**
 *
 * @author joão pedro
 */
public class Produto {
    private int codigo;
    private String nome;
    private float preco;
    private Especificacao especificacao;

    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public Especificacao getEspecificacao() {
        return especificacao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setEspecificacao(Especificacao especificacao) {
        this.especificacao = especificacao;
    }
    public String toString(){
        StringBuilder sb= new StringBuilder();
        
        sb.append(codigo)
                .append(" - ")
                .append(nome)
                .append(" - ")
                .append(preco)
                .append(" - ")
                .append(especificacao);
         return sb.toString();
    }
    
}
