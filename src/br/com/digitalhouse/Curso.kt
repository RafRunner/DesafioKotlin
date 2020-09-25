package br.com.digitalhouse

import br.com.digitalhouse.exceptions.VagasExgotadasException
import br.com.digitalhouse.pessoas.Aluno

class Curso(val nome: String, val codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {

    private val alunos = mutableListOf<Aluno>()
    private var vagasOcupadas = 0
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
        return "Curso $nome, codigo: $codigoCurso"
    }
}