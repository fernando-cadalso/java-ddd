package br.com.alura.escola.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.alura.escola.dominio.Evento;
import br.com.alura.escola.dominio.Ouvinte;

public class LogDeAlunoMatriculado extends Ouvinte {

	@Override
	public void reageAo(Evento evento) {
		String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm"));

		System.out.printf("Aluno com CPF %s foi matriculado em %s%n%n", ((AlunoMatriculado) evento).getCpfDoAluno().toString(),
				momentoFormatado);
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}
}
