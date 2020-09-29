package br.com.digitalhouse.main

import br.com.digitalhouse.DigitalHouseManeger

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

    digitalHouseManeger.cadastrarAluno("Rafael", "Santana", 1)
    digitalHouseManeger.cadastrarAluno("Matheus", "Hoffmann", 2)
    digitalHouseManeger.cadastrarAluno("Paula", "Araujo", 3)
    digitalHouseManeger.cadastrarAluno("Luiggi", "Giovanni", 4)

    digitalHouseManeger.matricularAluno(1, 20001)
    digitalHouseManeger.matricularAluno(2, 20001)
    digitalHouseManeger.matricularAluno(1, 20002)
    digitalHouseManeger.matricularAluno(3, 20002)
    digitalHouseManeger.matricularAluno(4, 20002)
}