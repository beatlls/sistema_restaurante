package org.example.cardapio;

public class ComBaconExtra implements ItemCardapio{

    private ItemCardapio lancheOriginal;

    public ComBaconExtra(ItemCardapio lancheOriginal) {
        this.lancheOriginal = lancheOriginal;
    }

    @Override
    public String getDescricao() {
        return lancheOriginal.getDescricao() + " + bacon extra";
    }

    @Override
    public double getPreco() {
        return lancheOriginal.getPreco() + 6.00;
    }
}
