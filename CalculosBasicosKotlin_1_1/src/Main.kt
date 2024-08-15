fun main() {

    //Declare variáveis para armazenar os dados

    var nome: String? = null
    var idade: Int? = null
    var salarioMensalBruto: Double? = null
    var mesesTrabalhados: Int? = null
    var produtosComprados: Int? = null

    //Atribua valores apropriados a cada uma das variáveis

    nome = "João"
    idade = 34
    salarioMensalBruto = 3700.0
    mesesTrabalhados = 9
    produtosComprados = 34

//- Calcule o salário anual bruto multiplicando o salário mensal
//  pelo número de meses trabalhados e armazene o resultado.

    var salarioAnualBruto: Double = salarioMensalBruto * mesesTrabalhados

//- Subtraia um valor fixo de desconto do salário anual bruto e
//  armazene o resultado como salário anual líquido.

    val descontoFixo: Double = 950.0
    var salarioAnualLiquido: Double = salarioAnualBruto - descontoFixo

//- Concatene uma string que informe o nome da pessoa e o salário anual
//  líquido com uma mensagem personalizada.

    var mensagemPersonalizada: String = "Nome: $nome; Salário anual líquido: $salarioAnualLiquido"

// Imprima no console todas as variáveis criadas, incluindo os resultados das operações realizadas.

    println("Nome: $nome")
    println("Idade: $idade")
    println("Salario Mensal Bruto: $salarioMensalBruto")
    println("Meses Trabalhados: $mesesTrabalhados")
    println("Produtos Comprados: $produtosComprados")
    println("Salário Anual Bruto: $salarioAnualBruto")
    println("Desconto Fixo: $descontoFixo")
    println("Salário Anual Líquido: $salarioAnualLiquido")
    println(mensagemPersonalizada)
    
}