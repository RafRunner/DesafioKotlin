package br.com.digitalhouse.main

import br.com.digitalhouse.Curso
import br.com.digitalhouse.DigitalHouseManeger
import br.com.digitalhouse.pessoas.Aluno

fun main() {
    val digitalHouseManeger = DigitalHouseManeger()

    println("Registrando professores")
    digitalHouseManeger.registrarProfessorTitular("Rodolfo", "Rodriguez", 100,  "Java")
    digitalHouseManeger.registrarProfessorTitular("Reneta", "Alvez", 200,  "Javascript")
    println()

    digitalHouseManeger.registrarProfessorAdjunto("Vitória", "Silva", 20, 110)
    digitalHouseManeger.registrarProfessorAdjunto("Breno", "Nunes", 50, 111)

    val curso1 = Curso("Full Stack", 20001, 3)
    val curso2 = Curso("Android", 20002, 2)

    println("Registrando cursos")
    digitalHouseManeger.registrarCurso(curso1)
    digitalHouseManeger.registrarCurso(curso2)
    println()

    println("Cursos antes de alocar professores:")
    println(curso1)
    println(curso2)
    println()

    digitalHouseManeger.alocarProfessores(20001, 200, 20)
    digitalHouseManeger.alocarProfessores(20002, 100, 50)

    println("Cursos depois de alocar professores:")
    println(curso1)
    println(curso2)
    println()

    println("Criando alunos")
    val aluno1 = Aluno("Rafael", "Santana", 1)
    val aluno2 = Aluno("Matheus", "Hoffmann", 2)
    val aluno3 = Aluno("Paula", "Araujo", 3)
    val aluno4 = Aluno("Luiggi", "Giovanni", 4)
    println()

    println("Consultando matriculas:")
    println(digitalHouseManeger.consultarMatricular(aluno1))
    println(digitalHouseManeger.consultarMatricular(aluno2))
    println(digitalHouseManeger.consultarMatricular(aluno3))
    println(digitalHouseManeger.consultarMatricular(aluno4))
    println()

    println("Cadastrando e matriculando os alunos:")
    digitalHouseManeger.cadastrarAluno(aluno1)
    digitalHouseManeger.cadastrarAluno(aluno2)
    digitalHouseManeger.cadastrarAluno(aluno3)
    digitalHouseManeger.cadastrarAluno(aluno4)

    digitalHouseManeger.matricularAluno(1, 20001)
    digitalHouseManeger.matricularAluno(2, 20001)
    digitalHouseManeger.matricularAluno(1, 20002)
    digitalHouseManeger.matricularAluno(3, 20002)
    digitalHouseManeger.matricularAluno(4, 20002)
    println()

    println("Consultando matriculas:")
    println(digitalHouseManeger.consultarMatricular(aluno1))
    println(digitalHouseManeger.consultarMatricular(aluno2))
    println(digitalHouseManeger.consultarMatricular(aluno3))
    println(digitalHouseManeger.consultarMatricular(aluno4))
    println()

    println("Cursos depois de alocar professores:")
    println(curso1)
    println(curso2)
    println()

    println("Exluindo professor de código 200 e vendo o estado dos cursos:")
    digitalHouseManeger.excluirProfessor(200)
    println(curso1)
    println(curso2)
    println()

    println("Excluindo o curso 20001:")
    digitalHouseManeger.excluirCurso(20001)
    println(digitalHouseManeger.consultarMatricular(aluno1))
    println(digitalHouseManeger.consultarMatricular(aluno2))
    println(digitalHouseManeger.consultarMatricular(aluno3))
    println(digitalHouseManeger.consultarMatricular(aluno4))
    println(digitalHouseManeger.getAlunos())
}