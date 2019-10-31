/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroprodutos.view;

import br.com.cadastroprodutos.dao.produtoDao;
import br.com.cadastroprodutos.model.Especificacao;
import br.com.cadastroprodutos.model.Produto;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joão pedro
 */
public class CadastroProdutos {
        public static void main(String[] args) throws ParseException, Exception{
                Scanner input = new Scanner(System.in);
                String escolha;
                produtoDao dao = new produtoDao();
                Produto p;
                
                do{
                        System.out.println("1 - Cadastrar produto");
                        System.out.println("2 - editar produto");
                        System.out.println("3 - remover produto");
                        System.out.println("4 - Mostrar todos produtos");
                        System.out.println("5 - Pesquisar produto");
                        System.out.println("0 - Sair");
                        escolha = input.nextLine();
                        System.out.println("\nOpção "+escolha+" selecionada\n");

                        if(escolha.equals("1")){
                                System.out.println("\tCADASTRAR\t");
                                
                                p= new Produto();
                                
                                System.out.println("Nome:");
                                p.setNome(input.nextLine());
                                
                                p.setEspecificacao(new Especificacao());
                                System.out.println("Fabricante");
                                p.getEspecificacao().setFabricante(input.nextLine());
                                System.out.println("Cor:");
                                p.getEspecificacao().setCor(input.nextLine());
                                System.out.println("Sistema: ");
                                p.getEspecificacao().setSistema(input.nextLine());
                                System.out.println("Detalhes: ");
                                p.getEspecificacao().setDetalhes(input.nextLine());
                                System.out.println("Preço:");
                                p.setPreco(input.nextFloat());
                                
                                dao.inserir(p);
                                System.out.println("PRODUTO CADASTRADO !!!");
                                
                        }else if (escolha.equals("2")){
                            System.out.println("\tEDITAR\t");
                            
                            System.out.println("Digite o codigo do produto:");
                            int cod= Integer.parseInt(input.nextLine());
                            p=dao.buscar(cod);
                            
                            if(p!=null){
                                System.out.println("Atuais dados: "+p);
                                System.out.println("Digite os novos dados: ");
                                System.out.println("Nome: ");
                                String novoNome = input.nextLine();
                                p.setNome(novoNome.equals("")? p.getNome() : novoNome);
                                System.out.println("Preco ");
                                float novoPreco = input.nextFloat();
                                p.setPreco(novoPreco == 0 ? p.getPreco() : novoPreco);
                                
                                dao.editar(p);
                                
                                System.out.println("PRODUTO ATUALIZADO\n");
                            }else{
                                System.out.println("\nproduto nao encontrado\n");
                            }
                            
                        }else if(escolha.equals("3")){
                                System.out.println("\tREMOVER PRODUTO\t");
                                System.out.println("Digite o codigo: ");
                                int cod = Integer.parseInt(input.nextLine());
                                p= dao.buscar(cod);
                                
                                if(p!=null){
                                    dao.remover(p);
                                    System.out.println("PRODUTO REMOVIDO");
                                }else{
                                    System.out.println("Produto nao encontrado!");
                                }
                        }else if(escolha.equals("4")){
                            System.out.println("\tPRODUTOS CADASTRADOS\t");
                            
                            List<Produto> produtos = dao.listar();
                            for(Produto pr : produtos){
                                System.out.println(pr);
                            }
                            
                        }else if(escolha.equals("5")){
                            System.out.println("Digite o codigo do produto:");
                            int cod = Integer.parseInt(input.nextLine());
                            p = dao.buscar(cod);
                            if(p!=null){
                                System.out.println(p);
                            }else{
                                System.out.println("PRODUTO NAO ENCONTRADO!!!");
                            }
                        }else if(escolha.equals("0")){
                            escolha="0";
                       }
                }while(!escolha.equals("0"));
        }
}
