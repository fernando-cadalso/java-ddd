package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.PublicadorDeEvento;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
	
	private final RepositorioDeAlunos repositorio;
	private final PublicadorDeEvento publicarEvento;

	public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEvento publicarEvento) {
		this.repositorio = repositorio;
		this.publicarEvento = publicarEvento;
	}
	
	// COMMAND
	public void executa(MatricularAlunoDto dados) {
		Aluno novo = dados.criarAluno();
		repositorio.matricular(novo);
		/*
		 * Registra o evento na entidade Aluno
		 */
		AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
		/*
		 * Publica o evento para o ouvinte interessado.
		 */
		publicarEvento.publicar(evento);
	}

}
