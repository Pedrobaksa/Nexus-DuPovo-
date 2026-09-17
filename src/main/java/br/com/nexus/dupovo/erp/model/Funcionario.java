package br.com.nexus.dupovo.erp.model;

public class Funcionario {
    private Long id;
    private String nome;
    private String cpf;
    private String cargo;
    private double salario;

    // Construtor Vazio
    public Funcionario() {}

    // Construtor Completo
    public Funcionario(Long id, String nome, String cpf, String cargo, double salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}