package br.com.digitalhouse

import br.com.digitalhouse.pessoas.Aluno
import java.time.LocalDate

class Matricula(val aluno: Aluno, val curso: Curso) {

    val dataMatricula: LocalDate = LocalDate.now()

    override fun toString(): String {
        return "matrícula do aluno ${aluno.nome} de código ${aluno.codigoAluno} no curso ${curso.nome} de código ${curso.codigoCurso}"
    }
}