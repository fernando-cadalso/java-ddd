package br.com.alura.escola.gamificacao.aplicacao;

import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDoEvento;

public class GerarSeloParaAlunoMatriculado extends Ouvinte {

	private final RepositorioDeSelosEmMemoria seloRepo;

	public GerarSeloParaAlunoMatriculado(RepositorioDeSelosEmMemoria seloRepo) {

		this.seloRepo = seloRepo;
	}

	@Override
	protected void reageAo(Evento evento) {
		CPF cpf = (CPF) evento.informacoes().get("cpf");
		Selo novato = new Selo(cpf, "Novato");
		seloRepo.salvar(novato);
		System.out.println("Selo registrado com sucesso!");
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento.tipo() == TipoDoEvento.ALUNO_MATRICULADO;
	}

}
