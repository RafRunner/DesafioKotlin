package br.com.digitalhouse.exceptions

import java.lang.Exception

class VagasExgotadasException(nomeCurso: String, numeroVagas: Int)
    : Exception("Curso $nomeCurso com vagas esgotadas! Lotação: $numeroVagas/$numeroVagas")