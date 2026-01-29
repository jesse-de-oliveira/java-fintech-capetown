package com.fintech.foundations;
import java.util.ArrayList;
import java.math.BigDecimal;

public class ListaTransacoes {
	public static void main(String[] args) {
		//Lista de valores de transacoes
		ArrayList<BigDecimal> transacoes = new ArrayList<>();
		
		//Adicionar transacoes do dia
		transacoes.add(new BigDecimal("150.50"));  //Compra no mercado
		transacoes.add(new BigDecimal("45.00"));  //Uber
		transacoes.add(new BigDecimal("320.75"));  //Conta de luz	
		transacoes.add(new BigDecimal("89.90"));  //Netflix
		
		System.out.println("=== TRANSACOES DO DIA ===");
		System.out.println("Total de transacoes: " + transacoes.size());
		
		//Calcular total gasto
		BigDecimal totalGasto = new BigDecimal("0.00");
		
		for (BigDecimal valor : transacoes) {
			System.out.println("Transacao: R$ " + valor);
			totalGasto = totalGasto.add(valor);
		}
		
		System.out.println("\n--- RESUMO ---");
		System.out.println("Total gasto hoje: R$ " + totalGasto);
		
		//Encontrar maior transacao
		BigDecimal maiorTransacao = transacoes.get(0);
		
		for (BigDecimal valor : transacoes) {
			if (valor.compareTo(maiorTransacao) > 0) {
				maiorTransacao = valor;
			}
		}
		
		System.out.println("Maior Transacao: R$ " + maiorTransacao);
		
	}
}




