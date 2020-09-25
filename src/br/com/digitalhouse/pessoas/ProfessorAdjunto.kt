package br.com.digitalhouse.pessoas

class ProfessorAdjunto(nome: String, sobrenome: String, tempoDeCasa: Int, codigoProfessor: Int, var horasMonitoria: Int)
    : Professor(nome, sobrenome, tempoDeCasa, codigoProfessor) {
}