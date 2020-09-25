package br.com.digitalhouse

import br.com.digitalhouse.pessoas.Aluno
import br.com.digitalhouse.pessoas.Professor
import br.com.digitalhouse.pessoas.ProfessorAdjunto
import br.com.digitalhouse.pessoas.ProfessorTitular

class DigitalHouseManeger {

    private val alunos = mutableListOf<Aluno>()
    private val matriculas = mutableListOf<Matricula>()
    private val professores = mutableListOf<Professor>()
    private val cursos = mutableListOf<Curso>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        val curso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)
        cursos.adicionaSeNaoPresente(curso)
    }

    fun excluirCurso(codigoCurso: Int) {
        cursos.remove(cursos.find { it.codigoCurso == codigoCurso })
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val professorAdjunto = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
        professores.adicionaSeNaoPresente(professorAdjunto)
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val professorTitular = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
        professores.adicionaSeNaoPresente(professorTitular)
    }

    fun excluirProfessor(codigoProfessor: Int) {
        professores.remove(professores.find { it.codigoProfessor == codigoProfessor })
    }

    fun cadastrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno = Aluno(nome, sobrenome, codigoAluno)
        alunos.adicionaSeNaoPresente(aluno)
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val curso = cursos.find { it.codigoCurso == codigoCurso }

        if (curso == null) {
            println("Curso de código $codigoCurso inexistente")
            return
        }

        val aluno = alunos.find { it.codigoAluno == codigoAluno }

        if (aluno == null) {
            println("O aluno de código $codigoAluno deve estar cadsatrado antes de ser matriculado!")
            return
        }

        if (curso.adicionarUmAluno(aluno)) {
            matriculas.add(Matricula(aluno, curso))
            print("Matrícula de $aluno realizado com sucesso em $curso")
        } else {
            println("Não foi possível realizar matrícula do aluno $aluno pois as vagas se esgotaram em $curso")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val curso = cursos.find { it.codigoCurso == codigoCurso }

        if (curso == null) {
            println("Curso de código $codigoCurso inexistente")
            return
        }

        val professorTitular = professores.find { it.codigoProfessor == codigoProfessorTitular }

        if (professorTitular == null || professorTitular !is ProfessorTitular) {
            println("Professor titular de código $codigoProfessorTitular não encontrado")
            return
        }

        val professorAdjunto = professores.find { it.codigoProfessor == codigoProfessorAdjunto }

        if (professorAdjunto == null || professorAdjunto !is ProfessorAdjunto) {
            println("Professor adjunto de código $codigoProfessorAdjunto não encontrado")
            return
        }

        curso.professorTitular = professorTitular
        curso.professorAdjunto = professorAdjunto
    }
}