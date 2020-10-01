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

    fun registrarCurso(curso: Curso): Boolean = cursos.adicionaSeNaoPresente(curso)

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int): Boolean = registrarCurso(Curso(nome, codigoCurso, quantidadeMaximaDeAlunos))

    private fun encontraCursoPorCodigo(codigo: Int): Curso? = cursos.find { it.codigoCurso == codigo }

    fun excluirCurso(codigoCurso: Int) {
        val curso = encontraCursoPorCodigo(codigoCurso) ?: return

        cursos.remove(curso)
        matriculas.removeAll { it.curso == curso }
        this.alunos.removeAll { consultarMatricular(it).isEmpty() }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val professorAdjunto = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
        professores.adicionaSeNaoPresente(professorAdjunto)
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val professorTitular = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
        professores.adicionaSeNaoPresente(professorTitular)
    }

    private fun encontraProfessorPorCodigo(codigo: Int): Professor? = professores.find { it.codigoProfessor == codigo }

    fun excluirProfessor(codigoProfessor: Int) {
        val professor = encontraProfessorPorCodigo(codigoProfessor) ?: return

        professores.remove(professor)
        cursos.forEach {
            if (it.professorAdjunto == professor) {
                it.professorAdjunto = null
            }
            if (it.professorTitular == professor) {
                it.professorTitular = null
            }
        }
    }

    fun cadastrarAluno(aluno: Aluno): Boolean = alunos.adicionaSeNaoPresente(aluno)

    fun cadastrarAluno(nome: String, sobrenome: String, codigoAluno: Int): Boolean = cadastrarAluno(Aluno(nome, sobrenome, codigoAluno))

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val curso = encontraCursoPorCodigo(codigoCurso)

        if (curso == null) {
            println("Curso de código $codigoCurso inexistente")
            return
        }

        val aluno = alunos.find { it.codigoAluno == codigoAluno }

        if (aluno == null) {
            println("O aluno de código $codigoAluno deve estar cadsatrado antes de ser matriculado!\n")
            return
        }

        if (curso.adicionarUmAluno(aluno)) {
            matriculas.add(Matricula(aluno, curso))
            println("Matrícula de $aluno realizado com sucesso no curso:\n$curso\n")
        } else {
            println("Não foi possível realizar matrícula do aluno $aluno pois as vagas se esgotaram em $curso\n")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val curso = encontraCursoPorCodigo(codigoCurso)

        if (curso == null) {
            println("Curso de código $codigoCurso inexistente\n")
            return
        }

        val professorTitular = encontraProfessorPorCodigo(codigoProfessorTitular)

        if (professorTitular == null || professorTitular !is ProfessorTitular) {
            println("Professor titular de código $codigoProfessorTitular não encontrado\n")
            return
        }

        val professorAdjunto = encontraProfessorPorCodigo(codigoProfessorAdjunto)

        if (professorAdjunto == null || professorAdjunto !is ProfessorAdjunto) {
            println("Professor adjunto de código $codigoProfessorAdjunto não encontrado\n")
            return
        }

        curso.professorTitular = professorTitular
        curso.professorAdjunto = professorAdjunto
    }

    fun consultarMatricular(aluno: Aluno): List<Matricula> = matriculas.filter { it.aluno == aluno }

    fun getAlunos(): List<Aluno> = alunos.toList()
}