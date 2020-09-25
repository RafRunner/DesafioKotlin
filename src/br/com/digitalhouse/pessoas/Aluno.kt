package br.com.digitalhouse.pessoas

class Aluno(nome: String, sobrenome: String, val codigoAluno: Int) : Pessoa(nome, sobrenome) {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Aluno) {
            return false
        }
        return codigoAluno == other.codigoAluno
    }

    override fun hashCode(): Int {
        return 31 * codigoAluno.hashCode()
    }

    override fun toString(): String {
        return "$nome $sobrenome - $codigoAluno"
    }
}