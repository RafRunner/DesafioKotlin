package br.com.digitalhouse.main

import br.com.digitalhouse.DigitalHouseManeger
import br.com.digitalhouse.pessoas.Aluno

fun main() {
    val digitalHouseManeger = DigitalHouseManeger()

    digitalHouseManeger.registrarProfessorTitular("Rodolfo", "Rodriguez", 100,  "Java")
    digitalHouseManeger.registrarProfessorTitular("Reneta", "Alvez", 200,  "Javascript")

    digitalHouseManeger.registrarProfessorAdjunto("Vitória", "Silva", 20, 110)
    digitalHouseManeger.registrarProfessorAdjunto("Breno", "Nunes", 50, 111)

    digitalHouseManeger.registrarCurso("Full Stack", 20001, 3)
    digitalHouseManeger.registrarCurso("Android", 20002, 2)

    digitalHouseManeger.alocarProfessores(20001, 200, 20)
    digitalHouseManeger.alocarProfessores(20002, 100, 50)

    val aluno1 = Aluno("Rafael", "Santana", 1)
    val aluno2 = Aluno("Matheus", "Hoffmann", 2)
    val aluno3 = Aluno("Paula", "Araujo", 3)
    val aluno4 = Aluno("Luiggi", "Giovanni", 4)

    digitalHouseManeger.cadastrarAluno(aluno1)
    digitalHouseManeger.cadastrarAluno(aluno2)
    digitalHouseManeger.cadastrarAluno(aluno3)
    digitalHouseManeger.cadastrarAluno(aluno4)

    digitalHouseManeger.matricularAluno(1, 20001)
    digitalHouseManeger.matricularAluno(2, 20001)
    digitalHouseManeger.matricularAluno(1, 20002)
    digitalHouseManeger.matricularAluno(3, 20002)
    digitalHouseManeger.matricularAluno(4, 20002)

    println(digitalHouseManeger.consultarMatricular(aluno1))
    println(digitalHouseManeger.consultarMatricular(aluno2))
    println(digitalHouseManeger.consultarMatricular(aluno3))
    println(digitalHouseManeger.consultarMatricular(aluno4))
}