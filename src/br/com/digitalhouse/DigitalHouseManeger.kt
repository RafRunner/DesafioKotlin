package br.com.digitalhouse

import br.com.digitalhouse.pessoas.Aluno
import br.com.digitalhouse.pessoas.Professor
import br.com.digitalhouse.pessoas.ProfessorAdjunto

class DigitalHouseManeger {

    private val alunos = mutableListOf<Aluno>()
    private val professores = mutableListOf<Professor>()
    private val cursos = mutableListOf<Curso>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        val curso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)
        cursos.adicionaSeNaoPresente(curso)
    }

    fun excluirCurso(codigoCurso: Int) {
        cursos.remove(cursos.firstOrNull { it.codigoCurso == codigoCurso })
    }

    fun registrarProfessorAdjunto(nome: String , sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val professorAdjunto = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
        professores.adicionaSeNaoPresente(professorAdjunto)
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {

    }
}