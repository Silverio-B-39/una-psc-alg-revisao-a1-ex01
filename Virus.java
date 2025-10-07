package Exercicio1;

import java.util.Scanner;

public class Virus {

	private static String coletarRespostaSimNao(Scanner scanner, String pergunta) {
		String resposta;

		while (true) {
			System.out.print(pergunta + " (SIM/NAO): ");

			resposta = scanner.nextLine().trim().toUpperCase();

			if (resposta.equals("SIM") || resposta.equals("NAO")) {
				return resposta;
			} else {
				System.out.println("Resposta inválida. Por favor, responda apenas com 'SIM' ou 'NAO'.");
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("--- Avaliação de Risco de Infecção ---");

		System.out.print("Informe o seu nome: ");
		String nome = scanner.nextLine();

		System.out.print("Informe a sua idade: ");

		int idade;
		try {
			idade = scanner.nextInt();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Idade inválida. Assumindo 0.");
			idade = 0;
		}
		scanner.nextLine();

		System.out.println("\nPerguntas de Risco (Responda SIM ou NAO):");

		String cartaoVacina = coletarRespostaSimNao(scanner, "Seu cartão de vacina está no dia?");
		String teveSintomas = coletarRespostaSimNao(scanner,
				"Teve algum sintoma recentemente? (dor de cabeça, febre, náusea, etc.)");
		String teveContato = coletarRespostaSimNao(scanner,
				"Teve contato com pessoas com sintomas gripais nos últimos dias?");
		String retornoViagem = coletarRespostaSimNao(scanner, "Você está retornando de viagem realizada no exterior?");

		int contagemRisco = 0;

		if (cartaoVacina.equals("NAO")) {
			contagemRisco++;
		}

		if (teveSintomas.equals("SIM")) {
			contagemRisco++;
		}

		if (teveContato.equals("SIM")) {
			contagemRisco++;
		}

		if (retornoViagem.equals("SIM")) {
			contagemRisco++;
		}

		String orientacao = "";

		if (contagemRisco == 4) {
			orientacao = "Paciente em Nível de Risco **Extremamente Alto**. Procure auxílio médico imediatamente.";
		} else if (contagemRisco >= 3) {
			orientacao = "Paciente com **Alto Risco** de infecção. Recomenda-se isolamento por 5 dias e monitoramento dos sintomas.";
		} else if (contagemRisco >= 1) {
			orientacao = "Paciente com **Baixo Risco**. Monitore os sintomas. Em caso de agravamento, procure assistência médica.";
		} else {

			if (retornoViagem.equals("SIM")) {
				orientacao = "Nenhum sintoma ou contato, mas como retornou de viagem, mantenha a observação por 5 dias.";
			} else {
				orientacao = "Paciente sob **Mínimo Risco**. Mantenha os cuidados preventivos.";
			}
		}

		System.out.println("\n--- Diagnóstico e Orientação ---");
		System.out.println("Nome: " + nome + ", Idade: " + idade);
		System.out.println("Fatores de Risco Identificados: " + contagemRisco + " de 4");
		System.out.println("\nOrientação Final:");
		System.out.println(orientacao);

		scanner.close();
	}
}