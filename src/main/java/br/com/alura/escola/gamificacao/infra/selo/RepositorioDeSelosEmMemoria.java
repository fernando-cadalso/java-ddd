package br.com.alura.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.gamificacao.dominio.selo.SeloRepository;
import br.com.alura.escola.shared.dominio.CPF;

public class RepositorioDeSelosEmMemoria implements SeloRepository {

	private List<Selo> selos = new ArrayList<>();
	@Override
	public void salvar(Selo selo) {

		selos.add(selo);
	}

	@Override
	public Selo recuperarUmSelo(CPF cpfDoAluno) {

		return selos.stream().filter(s -> s.getCpfDoAluno().equals(cpfDoAluno)).findFirst().get();
	}

	@Override
	public List<Selo> recuperarTodos() {
		return this.selos;
	}

}
