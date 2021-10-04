package com.microcadastrocliente.v1.hexagono.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotEmpty
    @Size(max = 60, message = "Tamanho máximo de 60 caracteres excedidos para campo Nome")
    String nome;

    String cpf;

    String cnpj;

    @NotNull
    @NotEmpty
    @Size(max = 120, message = "Tamanho máximo de 256 caracteres excedidos para campo Endereco")
    String endereco;

    @NotNull
    @NotEmpty
    @Size(max = 60, message = "Tamanho máximo de 60 caracteres excedidos para campo Cidade")
    String cidade;

    @NotNull
    @NotEmpty
    @Size(max = 2, message = "Tamanho máximo de 2 caracteres excedidos para campo Estado")
    String estado;

    @NotNull
    @NotEmpty
    String telefone;

    @NotNull
    @NotEmpty
    @Size(max = 60, message = "Tamanho máximo de 60 caracteres excedidos para campo Email")
    String email;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String cnpj, String endereco, String cidade, String estado, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado.toUpperCase();
        this.telefone = telefone;
        this.email = email;
        validar();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Executa validação dos campos.
     */
    public void validar() {
        Validador.validar(this);
        validarCpfCnpj();
        validarTelefone();
        validarEmail();
    }

    private void validarCpfCnpj() {
        if (this.cpf == null && this.cnpj == null) {
            throw new javax.validation.ValidationException("Cpf ou Cnpj deve estar preenchido.");
        }
        if (this.cpf != null && this.cnpj != null) {
            throw new javax.validation.ValidationException("Cpf e Cnpj não podem estar preenchidos simultâneamente.");
        }
        if (this.cpf != null) {
            validarCpf();
        } else {
            validarCnpj();
        }
    }

    private void validarCpf() {
        String cpfString = this.cpf.toString();
        int d1 = 0;
        int d2 = 0;
        int digito1 = 0;
        int digito2 = 0;
        int resto = 0;
        int digitoCPF;
        String nDigResult;
        for (int count = 1; count < cpfString.length() - 1; count++) {
            digitoCPF = Integer.valueOf(cpfString.substring(count - 1, count)).intValue();
            d1 = d1 + (11 - count) * digitoCPF;
            d2 = d2 + (12 - count) * digitoCPF;
        }
        resto = (d1 % 11);
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        d2 += 2 * digito1;
        resto = (d2 % 11);
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }
        String nDigVerific = cpfString.substring(cpfString.length() - 2, cpfString.length());
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        if (!nDigVerific.equals(nDigResult)) {
            throw new javax.validation.ValidationException("Cpf inválido.");
        }
    }

    private void validarCnpj() {
        if (this.cnpj.toString().length() < 14) {
            this.cnpj = ("00000000000000" + this.cnpj).substring(this.cnpj.toString().length());
        }
        String cnpjString = this.cnpj.toString();
        int soma = 0, dig;
        String cnpjCalc = cnpjString.substring(0, 12);
        char[] chrCnpj = cnpjString.toCharArray();
        for (int i = 0; i < 4; i++) {
            if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9) {
                soma += (chrCnpj[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chrCnpj[i + 4] - 48 >= 0 && chrCnpj[i + 4] - 48 <= 9) {
                soma += (chrCnpj[i + 4] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpjCalc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
        soma = 0;
        for (int i = 0; i < 5; i++) {
            if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9) {
                soma += (chrCnpj[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chrCnpj[i + 5] - 48 >= 0 && chrCnpj[i + 5] - 48 <= 9) {
                soma += (chrCnpj[i + 5] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpjCalc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
        if (!cnpjString.equals(cnpjCalc)) {
            throw new javax.validation.ValidationException("Cnpj inválido.");
        }
    }


    private void validarTelefone() {
        Pattern pattern = Pattern.compile("[0-9]{10,11}");
        Matcher matcher = pattern.matcher(this.telefone);
        if (!matcher.matches()) {
            throw new javax.validation.ValidationException(
                    "Telefone inválido. Preencha com o código da cidade e número do telefone, apenas números.");
        }
    }

    private void validarEmail() {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new javax.validation.ValidationException("Email inválido.");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", cnpj=" + cnpj +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
