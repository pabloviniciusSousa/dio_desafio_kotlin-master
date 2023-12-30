class main {


    enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

    data class Usuario(val id: Int, val nome: String, val email: String) {

        fun matricular (formacao: Formacao) {
            formacao.inscritos.add(this)
        }
        override fun toString(): String {
            return "Usuario(id=$id, nome=$nome, email=$email)"
        }
    }
    data class ConteudoEducacional(var nome: String, val duracao: Int = 150)

    data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

        val inscritos = mutableListOf<Usuario>()


        fun matricular(vararg usuarios: Usuario) {
            for (usuario in usuarios) {
                inscritos.add(usuario)
            }
        }
    }

    fun main() {
        val cursoBasico = ConteudoEducacional ("Curso Logica de Programação", 80)
        val cursoEtapa1 = ConteudoEducacional ("Curso Estrutura de dados", 20)
        val cursoEtapa2 = ConteudoEducacional ("Curso Arquitetura de Banco de dados", 50)
        val cursoEtapa3 = ConteudoEducacional ("Curso Java", 100)

        val aluno1 = Usuario(1,"Pablo", "pablo@dio.com")
        val aluno2 = Usuario(2, "Bartolomeu", "bartolomeu@dio.com")
        val aluno3 = Usuario(3, "Renan", "renan@dio.com")

        val conteudosBackend = listOf(cursoBasico, cursoEtapa1, cursoEtapa2, cursoEtapa3)
        val formacao = Formacao("Formacao Backend do zero ao avançado", conteudosBackend)

        formacao.matricular(aluno1, aluno2, aluno3)
        aluno3.matricular(formacao)

        val copiaInscritos = formacao.inscritos
        println("Alunos inscritos na ${formacao.nome}: ")
        for (inscrito in copiaInscritos) {
            println(inscrito.nome)
        }
    }
}