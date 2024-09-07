fun main() {

// Declare variáveis para armazenar os dados

    var nomeProduto: String? = null
    var precoProduto: Double? = null
    var quantidadeProdutosComprados: Int? = null
    var impostoSobreProduto: Double? = null
    var margemLucro: Double? = null

// Atribua valores apropriados a cada uma das variáveis.

    nomeProduto = "iPhone"
    precoProduto = 5000.0
    quantidadeProdutosComprados = 34
    impostoSobreProduto = 8.3
    margemLucro = 35.0

// Calcule o valor total sem impostos multiplicando o
// preço unitário pela quantidade comprada.

    var valorTotalSemImpostos: Double = precoProduto * quantidadeProdutosComprados

//- Calcule o valor do imposto sobre o valor total sem impostos
//  e adicione-o ao valor total para obter o valor total com impostos.

    var valorTotalComImpostos: Double = valorTotalSemImpostos * (impostoSobreProduto/100 + 1)

//- Calcule o preço de venda necessário para alcançar a margem de
//  lucro desejada sobre o valor total com impostos.

    var valorProdutoComImpostos: Double = valorTotalComImpostos / quantidadeProdutosComprados
    var precoDeVenda = valorProdutoComImpostos * (margemLucro/100 + 1)

// Arredonde o preço de venda para duas casas decimais.

    val precoDeVendaFinal: String = String.format("%.2f",precoDeVenda)

// Formate o valor total com impostos e o preço de venda como moeda (por exemplo, R$ 123,45).

    var valorTotalFormatado: String = String.format("R$%.2f",valorTotalComImpostos)
    var precoDeVendaFormatado: String = "R$$precoDeVendaFinal"

// Crie uma mensagem final que informe o nome do produto, o valor total com impostos
// e o preço de venda sugerido, tudo formatado adequadamente.

    var mensagemFinal: String = "Nome: $nomeProduto\n" +
            "Valor Total Com Impostos: $valorTotalFormatado\n" +
            "Preço de Venda Sugerido: $precoDeVendaFormatado"

// Imprima no console todas as variáveis criadas, incluindo os resultados
// das operações realizadase a mensagem final formatada.

    println("Nome: $nomeProduto")
    println("Preço: $precoProduto")
    println("Quantidade de Produtos Comprados: $quantidadeProdutosComprados")
    println("Imposto Sobre Produto: $impostoSobreProduto%")
    println("Margem de lucro: $margemLucro%")
    println("Valor sem impostos: $valorTotalSemImpostos")
    println("Valor com impostos: $valorTotalComImpostos")
    println("Valor do Produto com Impostos: $valorProdutoComImpostos")
    println("Preço de Venda: $precoDeVenda")
    println("Preço de Venda Arredondado: $precoDeVendaFinal")
    println("Valor total Formatado: $valorTotalFormatado")
    println("Preço de Venda Formatado: $precoDeVendaFormatado")
    println("#Mensagem Final #")
    println(mensagemFinal)

}