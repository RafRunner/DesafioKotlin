package br.com.digitalhouse

import br.com.digitalhouse.exceptions.VagasExgotadasException
import br.com.digitalhouse.pessoas.Aluno
import br.com.digitalhouse.pessoas.ProfessorAdjunto
import br.com.digitalhouse.pessoas.ProfessorTitular

class Curso(val nome: String, val codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {

    val alunos = mutableListOf<Aluno>()
    var vagasOcupadas = 0
    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null
    val vagasDisponiveis: Int

    init {
        if (quantidadeMaximaDeAlunos <= 0) {
            throw VagasExgotadasException(nome, quantidadeMaximaDeAlunos)
        }
        this.vagasDisponiveis = quantidadeMaximaDeAlunos
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        if (vagasDisponiveis == vagasOcupadas) {
            return false
        }

        return if (alunos.adicionaSeNaoPresente(umAluno)) {
            vagasOcupadas++
            true
        } else {
            false
        }
    }

    fun excluirAluno(umAluno: Aluno) {
        alunos.remove(umAluno)
        vagasOcupadas--
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Curso) {
            return false
        }
        return codigoCurso == other.codigoCurso
    }

    override fun hashCode(): Int {
        return 31 * codigoCurso.hashCode()
    }

    override fun toString(): String {
        return "$nome, codigo: $codigoCurso, lotação: $vagasOcupadas/$vagasDisponiveis\n" +
                "Professores:\n" +
                "Professor titular: $professorTitular\n" +
                "Professor adjunto: $professorAdjunto"
    }
}