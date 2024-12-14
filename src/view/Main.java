package view;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import model.Categoria;
import model.Item;
import model.Produto;
import model.Venda;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        Produto arroz = new Produto(01, "Arroz Parbolizado", 3.20, Categoria.ALIMENTICIO);
        Produto feijao = new Produto(02, "Feijão Carreteiro", 4.20, Categoria.ALIMENTICIO);
        Produto macarrao = new Produto(03, "Macarrão Instântaneo", 1.20, Categoria.ALIMENTICIO);
        Produto acucar = new Produto(04, "Açucar Cristal", 2.00, Categoria.ALIMENTICIO);
        Produto sal = new Produto(05, "Sal", 1.50, Categoria.ALIMENTICIO);
        Produto doce = new Produto(06, "Doce de Goiaba", 5.20, Categoria.ALIMENTICIO);

        // Estoque
        Produto[] produtosEstoque = {
                arroz, feijao, macarrao, acucar, sal, doce
        };

        // Variáveis de Controle
        int varControl = 1;
        Venda venda = new Venda();

        while (varControl > 0) {
            System.out.printf("\nxxxxxxxxxxxxx- Bem vindo ao Mercado do Pai! -xxxxxxxxxxxxx\n");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("Insira uma das opções em nosso sistema:");
            System.out.println("1 - Adicionar Item");
            System.out.println("2 - Remover Item");
            System.out.println("3 - Listar Itens");
            System.out.println("4 - Calcular Total");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            varControl = sc.nextInt();

            switch (varControl) {
                case 1:
                    System.out.printf("\nInsira um dos itens que deseja inserir:\n");
                    for (int i = 0; i < produtosEstoque.length; i++) {
                        System.out.printf("%d - %s\n", i, produtosEstoque[i].getDescricao());
                    }
                    int varProdutos = 1;
                    varProdutos = sc.nextInt();
                    switch (varProdutos) {
                        case 0:
                            venda.adicionarItem(new Item(arroz.getCodigo(), arroz, 1));
                            break;
                        case 1:
                            venda.adicionarItem(new Item(feijao.getCodigo(), feijao, 1));
                            break;
                        case 2:
                            venda.adicionarItem(new Item(macarrao.getCodigo(), macarrao, 1));
                            break;
                        case 3:
                            venda.adicionarItem(new Item(acucar.getCodigo(), acucar, 1));
                            break;
                        case 4:
                            venda.adicionarItem(new Item(sal.getCodigo(), sal, 1));
                            break;
                        case 5:
                            venda.adicionarItem(new Item(doce.getCodigo(), doce, 1));
                            break;
                        default:
                            break;
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.printf("\nInsira um dos itens que deseja remover.\n");
                    System.out.println("Esses são seus produtos atuais:");
                    Item[] array = venda.getItens();
                    int count = 0;

                    // Exibir itens com índice para o usuário
                    for (int i = 0; i < venda.getQuantidadeItens(); i++) {
                        Item item = array[i];
                        System.out.printf("%d - Produto: %-15s | Quantidade: %-2d\n",
                                count,
                                item.getProduto().getDescricao(),
                                item.getQuantidade());
                        count++;
                    }

                    System.out.printf("Insira qual produto deseja remover, insira entre 0 e %d: ", count - 1);
                    varProdutos = sc.nextInt();

                    if (varProdutos >= 0 && varProdutos < venda.getQuantidadeItens()) {
                        if (venda.removerItem(varProdutos)) {
                            System.out.printf("Item removido com sucesso!\n\n");
                            System.out.println("PRODUTOS PÓS REMOÇÃO:");

                            // Exibir produtos restantes após a remoção
                            for (int i = 0; i < venda.getQuantidadeItens(); i++) {
                                Item item = array[i];
                                System.out.printf("Produto: %-15s | Quantidade: %-2d\n",
                                        item.getProduto().getDescricao(),
                                        item.getQuantidade());
                            }
                        } else {
                            System.out.println("Erro ao tentar remover o item!");
                        }
                    } else {
                        System.out.println("Índice inválido!");
                    }
                case 3:
                    System.out.printf("\n%-30s\n", "==================== PRODUTOS ====================");
                    array = venda.getItens();
                    for (Item item : array) {
                        System.out.printf("Produto: %-15s | Quantidade: %-2d\n",
                                item.getProduto().getDescricao(),
                                item.getQuantidade());
                    }
                    break;
                case 4:
                    System.out.printf("\n%-30s\n", "==================== NOTA FISCAL ====================");
                    array = venda.getItens();
                    for (Item item : array) {
                        System.out.printf("Produto: %-15s | Quantidade: %-2d | Subtotal: R$ %.2f\n",
                                item.getProduto().getDescricao(),
                                item.getQuantidade(),
                                item.getSubtotal());
                    }
                    System.out.printf("\n%-30s\n",
                            "==================================================================");
                    System.out.printf("Horário: %s\n", venda.getHora().format(formatter));
                    System.out.printf("TOTAL: R$ %.2f\n", venda.getTotal());
                    System.out.printf("%-30s\n", "==================================================================");
                    break;
                default:
                    System.out.printf("\nOpção Inválida!");
                    break;
            }

        }

        sc.close();

    }
}