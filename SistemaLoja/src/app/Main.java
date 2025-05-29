package app;

import javax.swing.*;
import model.*;

public class Main {
	public static void main(String[] args) {
        Loja loja = new Loja();
        int opcao;

        do {
            String menu = """
                    1 - Cadastrar Cliente
                    2 - Cadastrar Produto
                    3 - Realizar Venda
                    4 - Listar Clientes
                    5 - Listar Produtos
                    6 - Listar Vendas
                    0 - Sair
                    """;

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                	try {
                        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
                        String cpf = JOptionPane.showInputDialog("Digite o CPF (11 dígitos):");
                        Cliente cliente = new Cliente(nome, cpf);
                        loja.adicionarCliente(cliente);
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
                    }
                    break;
                case 2:
                	try {
                        String[] opcoes = {"Produto comum", "Livro"};
                        int tipo = JOptionPane.showOptionDialog(null, "Qual tipo de produto deseja cadastrar?",
                                "Tipo de Produto", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                null, opcoes, opcoes[0]);

                        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto:"));
                        String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));

                        if (tipo == 1) {
                            String autor = JOptionPane.showInputDialog("Digite o nome do autor:");
                            Livro livro = new Livro(id, nome, preco, autor);
                            loja.adicionarProduto(livro);
                        } else {
                            Produto produto = new Produto(id, nome, preco);
                            loja.adicionarProduto(produto);
                        }

                        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
                    }
                    break;
                case 3:
                	try {
                        if (loja.getTotalClientes() == 0 || loja.getTotalProdutos() == 0) {
                            JOptionPane.showMessageDialog(null, "É necessário ter pelo menos um cliente e um produto cadastrados.");
                            break;
                        }

                        
                        StringBuilder clientesList = new StringBuilder("Selecione o índice do cliente:\n");
                        for (int i = 0; i < loja.getTotalClientes(); i++) {
                            clientesList.append(i).append(" - ").append(loja.getCliente(i).getNome()).append("\n");
                        }
                        int indiceCliente = Integer.parseInt(JOptionPane.showInputDialog(clientesList.toString()));
                        Cliente clienteSelecionado = loja.getCliente(indiceCliente);

                        
                        StringBuilder produtosList = new StringBuilder("Selecione os índices dos produtos separados por vírgula (ex: 0,1,2):\n");
                        for (int i = 0; i < loja.getTotalProdutos(); i++) {
                            produtosList.append(i).append(" - ").append(loja.getProduto(i).getNome()).append(" (R$").append(loja.getProduto(i).getPreco()).append(")\n");
                        }

                        String inputProdutos = JOptionPane.showInputDialog(produtosList.toString());
                        String[] indices = inputProdutos.split(",");
                        Produto[] produtosSelecionados = new Produto[indices.length];

                        for (int i = 0; i < indices.length; i++) {
                            int idx = Integer.parseInt(indices[i].trim());
                            produtosSelecionados[i] = loja.getProduto(idx);
                        }

                        loja.realizarVenda(clienteSelecionado, produtosSelecionados, produtosSelecionados.length);
                        JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao realizar venda: " + e.getMessage());
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, loja.listarClientes());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, loja.listarProdutos());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, loja.listarVendas());
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opcao != 0);
    }
}
