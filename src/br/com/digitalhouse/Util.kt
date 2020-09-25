package br.com.digitalhouse

fun <T> MutableList<T>.adicionaSeNaoPresente(elemento: T): Boolean {
    if (!this.contains(elemento)) {
        return this.add(elemento)
    }
    return false
}
