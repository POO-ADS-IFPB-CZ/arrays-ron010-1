package model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Venda {

    private Item[] itens;
    private LocalDateTime dataHora;
    private int quantidadeItens;

    public Venda() {
        itens = new Item[3];
        dataHora = LocalDateTime.now();
        quantidadeItens = 0;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < quantidadeItens; i++) {
            total += itens[i].getSubtotal();
        }
        return total;
    }

    public boolean adicionarItem(Item item) {
        if (quantidadeItens == itens.length) {
            itens = Arrays.copyOf(itens, itens.length + 3);
        }
        itens[quantidadeItens++] = item;
        return true;
    }

    public LocalDateTime getHora() {
        return dataHora;
    }

    public boolean removerItem(int position) {
        if (position >= 0 && position < quantidadeItens) {
            // Remover o item deslocando os elementos seguintes
            System.arraycopy(itens, position + 1, itens, position, quantidadeItens - position - 1);
            quantidadeItens--;
            return true;
        }
        return false; // Índice inválido
    }

    public Item[] getItens() {
        return Arrays.copyOf(itens, quantidadeItens);
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

}
