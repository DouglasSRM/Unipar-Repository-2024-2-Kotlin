//1 - Manipulação de Variáveis Simples em Kotlin

fun main() {

// Declare variáveis para armazenar dados:

    var idade: Int? = null;
    var altura: Double? = null;
    var nome: String? = null;
    var eEstudante: Boolean? = null;

// Atribua valores apropriados a cada uma das variáveis.

    idade = 19
    altura = 1.75
    nome = "Douglas"
    eEstudante = true

//    - Calcule a soma de duas idades e armazene o resultado em uma nova variável.
//    - Multiplique a altura por um fator de 2 e armazene o resultado.
//    - Concatene o nome da pessoa com uma saudação, por exemplo, "Olá, [Nome]!".

    var idade2: Int = 18
    var somaIdades: Int = idade + idade2

    var dobroAltura: Double = altura * 2

    var saudacao: String = "Olá $nome!"

// Imprima no console todas as variáveis criadas, incluindo os resultados das operações realizadas.

    println("Nome: $nome")
    println("Altura: $altura")
    println("Idade: $idade anos")
    println("É estudante? $eEstudante")
    println("Soma das idades: $somaIdades")
    println("Altura dobrada: $dobroAltura")
    println(saudacao)





}