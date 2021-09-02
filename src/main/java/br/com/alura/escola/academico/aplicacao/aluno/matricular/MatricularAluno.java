package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEvento;

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
