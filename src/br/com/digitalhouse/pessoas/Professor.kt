package br.com.digitalhouse.pessoas

open class Professor(nome: String, sobrenome: String, var tempoDeCasa: Int, val codigoProfessor: Int) : Pessoa(nome, sobrenome) {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Professor) {
            return false
        }
        return codigoProfessor == other.codigoProfessor
    }

    override fun hashCode(): Int {
        return 31 * codigoProfessor.hashCode()
    }
}