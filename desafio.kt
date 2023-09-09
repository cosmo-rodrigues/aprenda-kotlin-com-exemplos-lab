enum class Nivel(val nivel: Int) {
    BASICO(1),
    INTERMEDIARIO(2),
    AVANCADO(3)
}

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val categoria: String, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun cancelarMatricula(usuario: Usuario) {
        inscritos.remove(usuario)
    }
}

fun main() {
    val usuario1 = Usuario("João", "joao@example.com")
    val usuario2 = Usuario("Maria", "maria@example.com")

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90, "Programação", Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados", categoria = "Programação", nivel = Nivel.AVANCADO)

    val formacao = Formacao("Formação de Desenvolvedor", listOf(conteudo1, conteudo2))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println("Inscritos na formação: ${formacao.inscritos.map { it.nome }}")

    formacao.cancelarMatricula(usuario1)

    println("Inscritos na formação após cancelamento: ${formacao.inscritos.map { it.nome }}")
}
