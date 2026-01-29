package com.fintech.foundations;
import java.util.ArrayList;

public class ArrayListBasico {
	public static void main(String[] args) {
		//Criar ArrayList de Strings (nomes de clientes)
		ArrayList<String> clientes = new ArrayList<>();
		
		//Adicionar clientes
		clientes.add("Maria Silva");
		clientes.add("Joao Santos");
		clientes.add("Ana Costa");
		
		System.out.println("Total de clientes: " + clientes.size());
		System.out.println("Todos os clientes: " + clientes);
		
		//Acessar cliente especifico (comeca do 0!)
		System.out.println("\nPrimeiro cliente: " + clientes.get(0));
		System.out.println("Segundo cliente: " + clientes.get(1));
		
		//verificar se cliente existe
		boolean temMaria = clientes.contains("Maria Silva");
		System.out.println("\nMaria Silva é cliente? " + temMaria);
		
		//Remover cliente
		clientes.remove("Joao Santos");
		System.out.println("\nApós remover Joao: " + clientes);
		System.out.println("Total agora: " + clientes.size());
		
		//Percorrer todos os clientes
		System.out.println("\n=== LISTA DE CLIENTES ===");
		for (String cliente : clientes) {
			System.out.println("- " + cliente);
		}
	}
}