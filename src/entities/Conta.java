package entities;

import exceptions.BusinessException;

public class Conta {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteDeSaque;
	
	public void deposito(Double montante) {
		saldo += montante;
	}
	
	public void saque (Double montante) {
		validateSaque(montante);
		saldo -= montante;
	}
	
	private void validateSaque(double montante) {
		if (montante > getLimiteDeSaque()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
		}
		if (montante > getSaldo()) {
			throw new BusinessException("Erro de saque: Saldo Insuficiente");
		}
	}

	public Conta(Integer numero, String titular, Double saldo, Double limiteDeSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteDeSaque = limiteDeSaque;
	}
	

	public Conta() {
		
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}

	public void setLimiteDeSaque(Double limiteDeSaque) {
		this.limiteDeSaque = limiteDeSaque;
	}
	
	
	
}
