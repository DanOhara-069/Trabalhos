package model;

public class Cliente {
	private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        setCpf(cpf);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {
        if (cpf != null && cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido! Deve conter exatamente 11 dígitos numéricos.");
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }
}
