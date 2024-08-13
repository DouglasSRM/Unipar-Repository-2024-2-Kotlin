//Primeira aula de Kotlin (12/08/2024)

var version = 56565

fun main(args: Array<String>) {

    //var nomeVariavel: tipo = valor  >>> Declaração de VARIÁVEL

    //val nomeConstante: tipo = valor >>> Declaração de CONSTANTE

    //Variável sem tipagem declarada
    var idade: Int? = 19

    println(idade)

    idade = 20

    println(idade)

    //Variáveis com tipagem declarada
    val altura: Double = 1.75
    var nome: String = "Douglas"
    var eEstudade: Boolean = true
    var nome2: String? = null

    do {
        print("Insira sua idade: ")
        var lerIdade = readln()
        idade = lerIdade?.toIntOrNull()
        if (idade == null) {
            println("Entrada inválida. Tente novamente.")
        }
    } while (idade == null)

    println("Minha idade é $idade")

    if (idade >= 18) {
        println("Você é maior de idade.")
    } else {
        println("Você é menor de idade.")
    }

    println("version $version")

    mudarVersion(9)

    println("version ${version}")

    var soma = somarValores(9,18)
    println("A soma é $soma")

    /**   ANOTAÇÕES
    Não há necessidade de utilização do > ; < ponto e vírgula

    Sintaxe mais dinâmica e simplificada

    Há a possibilidade de criar funções fora de uma classe (funcional)

    É possível declarar valores nulos para diferentes tipos de variáveis ao
    colocar um "?" ao lado do tipo. Exemplo: "var nome2: String? = null"

    Uso de $ para concatenar variáveis em frases no println

    Para situações que necessitariam do uso da classe "InputMismatchException" em java,
     pode ser utilizado o método ".toIntOrNull", tornando o processo muito mais fácil
     Exemplo: idade = lerIdade?.toIntOrNull() (linha 29)
     **/
}

//fun nome_funcao(parametros) << função void
fun mudarVersion(versionChange: Int) {
    version = versionChange
}

//Função COM retorno
fun somarValores(valorA: Int, valorB: Int): Int {
    return valorA+valorB
}
