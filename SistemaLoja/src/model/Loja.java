package model;

public class Loja {
	private Cliente[] clientes = new Cliente[100];
    private Produto[] produtos = new Produto[100];
    private Venda[] vendas = new Venda[100];

    private int contadorClientes = 0;
    private int contadorProdutos = 0;
    private int contadorVendas = 0;

    public void adicionarCliente(Cliente c) {
        if (contadorClientes < 100) {
            clientes[contadorClientes++] = c;
        }
    }

    public void adicionarProduto(Produto p) {
        if (contadorProdutos < 100) {
            produtos[contadorProdutos++] = p;
        }
    }

    public void realizarVenda(Cliente c, Produto[] produtos, int qtdProdutos) {
        if (contadorVendas < 100) {
            vendas[contadorVendas++] = new Venda(c, produtos, qtdProdutos);
        }
    }

    public String listarClientes() {
        StringBuilder sb = new StringBuilder("Clientes cadastrados:\n");
        for (int i = 0; i < contadorClientes; i++) {
            sb.append(clientes[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public String listarProdutos() {
        StringBuilder sb = new StringBuilder("Produtos cadastrados:\n");
        for (int i = 0; i < contadorProdutos; i++) {
            sb.append(produtos[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public String listarVendas() {
        StringBuilder sb = new StringBuilder("Vendas realizadas:\n");
        for (int i = 0; i < contadorVendas; i++) {
            sb.append(vendas[i].toString()).append("\n\n");
        }
        return sb.toString();
    }

    public Cliente getCliente(int index) {
        if (index >= 0 && index < contadorClientes) return clientes[index];
        return null;
    }

    public Produto getProduto(int index) {
        if (index >= 0 && index < contadorProdutos) return produtos[index];
        return null;
    }

    public int getTotalClientes() { return contadorClientes; }
    public int getTotalProdutos() { return contadorProdutos; }
}
