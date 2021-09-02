package br.com.alura.escola.gamificacao.dominio.selo;

import java.util.List;

import br.com.alura.escola.shared.dominio.CPF;

public interface SeloRepository {

	void salvar(Selo selo);
	Selo recuperarUmSelo(CPF cpfDoAluno);
	List<Selo> recuperarTodos();
}
