//Em um banco, para se cadastrar uma conta bancária, é necessário informar o número da conta, o nome do titular da conta, e o valor de depósito inicial que o titulo ao abrir a conta.
//Este valor de depósito inicial, entretanto, é opcional, ou seja: se o titular não tive dinheiro a depositar no momento de abrir sua conta, o depósito inicial não será, naturalmente,
//zero.Importante: uma vez que uma conta bancária foi aberta, o número da conta unca poderá ser alterado. Já que o nome do titular pode ser alterado (pois uma pessoa pode mudar de 
//nome por ocasião de casamento).Por fim, o saldo da conta não pode ser alterado livremente. É preciso haver um mecanismo para proteger isso. O saldo só aumenta por meio de depósitos,
//e só diminuirá por meio de saques. Para cada saque realizado, o banco cobra uma taxa de $ 5.00, nota: a conta pode ficar com saldo negativo se o saldo não for suficiente para
//realizar o saque e/ou pagar a taxa.Você deve fazer um programa que realize o cadastro de uma conta, dando opção para que seja ou não informado o valor de depósito inicial.
//Em seguida, realizar um depósito e depois um saque, sempre mostrando os dados da conta após cada operação.

package application;

import java.util.Locale;
import java.util.Scanner;
import entities.cliente;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o nome do titular da conta");
		String nome = sc.nextLine();
		System.out.println("Digite o número da sua conta");
		int numeroConta = sc.nextInt();
		cliente cliente = new cliente(nome , numeroConta);
		
		System.out.println("Desejar realizar um deposito inicial? Digite:");
		System.out.println("[1] SIM %n [2]NÃO");
		int OpcaoDeposito = sc.nextInt();
		
		if (OpcaoDeposito == 1) {
			System.out.println("Quanto deseja depositar");
			double deposito = sc.nextDouble();
			cliente.Deposito (deposito);
			
		}
		else if (OpcaoDeposito == 0) {
			double deposito = 0;
			cliente.Deposito (deposito);
		}
		
		System.out.println("Dados atuais : " + cliente.toString());
		
		System.out.println("Quanto deseja Sacar");
		double saque = sc.nextDouble();
		cliente.Saque(saque);
		
		System.out.println("Dados atuais : " + cliente.toString());
		sc.close();
}
}

// Entidade responsavel por realizar todos os calculos ref a classe CLIENTE.

package entities;

public class cliente {
	private String nome;
	private int numeroConta;
	private double saldo;
	
	// construtor para obrigar a entrada de dados em nome e numero da conta
	public cliente (String nome , int numeroConta) {
		this.nome = nome;
		this.numeroConta = numeroConta;
	}
	// get retorna , set altera
	public String getNome () {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	// funcao responsavel por subtratir toda vez que o cliente sacar + cobranca na taxa de saque
	public void Saque(double saque) {
		 this.saldo = (this.saldo - saque) - 5.00 ; 
	}
	// funcao responsavel por incluir no saldo toda vez que o cliente depositar um valor
	public void Deposito (double deposito) {
		this.saldo = (this.saldo + deposito);
	}
	// funcao que sobrepõe as informações dos dados iniciais já atualizados.
	public String toString() {
		return "conta "
			+	getNumeroConta()
			+	" , Nome do Titular: "
			+	getNome()
			+	" Saldo atual da conta: "
			+	getSaldo();
	}

}
