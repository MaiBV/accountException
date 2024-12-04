package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados da conta");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteDeSaque = sc.nextDouble();
		
		
		Conta acc = new Conta(numero, titular, saldo, limiteDeSaque);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double montante = sc.nextDouble();
		
		try {
			acc.saque(montante);
			System.out.printf("Novo saldo: %.2f%n", acc.getSaldo());
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
