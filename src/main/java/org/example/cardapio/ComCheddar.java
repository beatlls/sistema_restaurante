package org.example.cardapio;

public class ComCheddar implements ItemCardapio{

    private ItemCardapio lancheOriginal;

    public ComCheddar(ItemCardapio lancheOriginal) {
        this.lancheOriginal = lancheOriginal;
    }

    @Override
    public String getDescricao() {
        return lancheOriginal.getDescricao() + " + cheddar";
    }

    @Override
    public double getPreco() {
        return lancheOriginal.getPreco() + 4.00;
    }
}
