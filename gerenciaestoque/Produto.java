package gerenciaestoque;

public class Produto {

    private int codProduto;
    private String descProduto;
    private int qtdeProduto;

    public Produto(int codigo, String descricao) {
        this.codProduto = codigo;
        this.descProduto = descricao;
        this.qtdeProduto = 0;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescProd() {
        return descProduto;
    }

    public void setDescProd(String descProd) {
        this.descProduto = descProd;
    }

    public int getQtdeProd() {
        return qtdeProduto;
    }

    public void setQtdeProd(int qtdeProd) {
        this.qtdeProduto = qtdeProd;
    }

    public void entradaProduto(int quantidade) {
        this.qtdeProduto += quantidade;
        System.out.println("\nEntrada de " + quantidade + " unidades do produto " + descProduto + " realizada com sucesso.");
    }

    public void saidaProduto(int quantidade) {
        if (quantidade <= qtdeProduto) {
            this.qtdeProduto -= quantidade;
            System.out.println("\nSaída de " + quantidade + " unidades do produto " + descProduto + " realizada com sucesso.");
        } else {
            System.out.println("\nQuantidade insuficiente em estoque para realizar a saída.");
        }
    }

    public void exibirEstoque() {
        System.out.println("\nQuantidade em estoque do produto " + descProduto + ": " + qtdeProduto);
    }
}
