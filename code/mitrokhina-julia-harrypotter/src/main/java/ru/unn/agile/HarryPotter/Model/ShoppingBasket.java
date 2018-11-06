package ru.unn.agile.HarryPotter.Model;

import java.util.Objects;

public class ShoppingBasket {
    private int[] booksQuantity;
    private double totalPrice;

    public static final double initialBookPrice = 8;

    public ShoppingBasket(int quantityBook1,int quantityBook2,int quantityBook3,int quantityBook4,int quantityBook5) {
        this.booksQuantity = new int[]{quantityBook1, quantityBook2, quantityBook3, quantityBook4, quantityBook5};
        this.totalPrice = 0.00;
    }

    public int[] getShoppingBasket() {
        return booksQuantity;
    }

    public double getShoppingBasketPriceSameBooks() {
        int quantity = 0;

        for (int  i = 0; i < 5; i++){
            if (this.booksQuantity[i] != 0) {
                quantity = booksQuantity[i];
                break;
            }
        }
        this.totalPrice = initialBookPrice * quantity;
        return totalPrice;
    }

    private double getStandardDiscount(int quantity) {
        double price = 0.00;

        if ( quantity == 1 ) {
                price = initialBookPrice;
        } else
            if ( quantity == 2 ) {
               price = 15.2;
        } else
            if ( quantity == 3 ) {
                price = 21.6;
        } else
            if ( quantity == 4 ) {
                price = 25.6;
        } else
            if ( quantity == 5 ) {
                price = 30;
        }
        return price;
    }

    private int getUniqueBooksInShoppingBasket() {
        int quantityUnique = 0;

        for (int  i = 0; i < 5; i++) {
            if (this.booksQuantity[i] != 0) {
                quantityUnique++;
            }
        }
        return quantityUnique;
    }

    public double getDiscountForUniqueItems() {
        return getStandardDiscount(getUniqueBooksInShoppingBasket());
    }

    public double getFinalPriceOfShoppingBasket() {
        int quantityUnique = getUniqueBooksInShoppingBasket();
        double finalPrice = 0.00;

        while (quantityUnique > 0) {
            for (int i = 0; i < 5; i++) {
                if (this.booksQuantity[i] > 0) {
                    this.booksQuantity[i] -= 1;
                }
            }
            finalPrice += getStandardDiscount(quantityUnique);
            quantityUnique = getUniqueBooksInShoppingBasket();
        }
        return finalPrice;
    }
}
