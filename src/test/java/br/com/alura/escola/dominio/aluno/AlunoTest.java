package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.FabricaDeAluno;

class AlunoTest {

	@Test
	void naoDeveAceitarMaisQueDoisTelefones() {
		Aluno alunoTeste = new FabricaDeAluno().comNomeCPFEmail("Fernando", "300.763.728-71", "fernando@gmail.com")
				.comTelefone("11", "41244321")
				.comTelefone("11", "321454356").criar();
		assertThrows(IllegalArgumentException.class, () -> alunoTeste.adicionarTelefone("11", "65475142"));
	}

}
