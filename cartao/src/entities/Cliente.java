package entities;
import java.math.BigInteger;

public class Cliente {
    private String nome;
        private String email;
        private BigInteger nCartao;

        public Cliente () {
        }

        public Cliente(String nome, String email, BigInteger nCartao) {
            super();
            this.nome = nome;
            this.email = email;
            this.nCartao = nCartao;
        }

        public String getNome() {return nome;}

        public void setNome(String nome) {this.nome = nome;}

        public String getEmail() {return email;}

        public void setEmail(String email) {this.email = email;}

        public BigInteger getnCartao() {return nCartao;}

        public void setnCartao(BigInteger nCartao) {this.nCartao = nCartao;}

        @Override
        public String toString() {
            return "Nome: " + nome + ", Email: " + email + ", Cartão: " + nCartao;
        }
}
