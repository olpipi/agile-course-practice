package ru.unn.agile.HarryPotter.Model;

public class ShoppingBasket {
    private int[] booksQuantity;
    private double totalPrice;

    public static final double INITIAL_BOOK_PRICE = 8;
    public static final double TWO_BOOKS_DISCOUNTED = 15.2;
    public static final double THREE_BOOKS_DISCOUNTED = 21.6;
    public static final double FOUR_BOOKS_DISCOUNTED = 25.6;
    public static final double FIVE_BOOKS_DISCOUNTED = 30;
    public static final int ONE_KIND_OF_BOOKS = 1;
    public static final int TWO_KIND_OF_BOOKS = 2;
    public static final int THREE_KIND_OF_BOOKS = 3;
    public static final int FOUR_KIND_OF_BOOKS = 4;
    public static final int FIVE_KIND_OF_BOOKS = 5;

    public ShoppingBasket(final int n1, final int n2, final int n3, final int n4, final int n5) {
        this.booksQuantity = new int[]{n1, n2, n3, n4, n5};
        this.totalPrice = 0.00;
    }

    public int[] getShoppingBasket() {
        return booksQuantity;
    }

    public double getShoppingBasketPriceSameBooks() {
        int quantity = 0;

        for (int  i = 0; i < FIVE_KIND_OF_BOOKS; i++) {
            if (this.booksQuantity[i] != 0) {
                quantity = booksQuantity[i];
                break;
            }
        }
        this.totalPrice = INITIAL_BOOK_PRICE * quantity;
        return totalPrice;
    }

    private double getStandardDiscount(final int quantity) {
        double price = 0.00;

        switch (quantity) {
            case ONE_KIND_OF_BOOKS:
                price = INITIAL_BOOK_PRICE;
                break;
            case TWO_KIND_OF_BOOKS:
                price = TWO_BOOKS_DISCOUNTED;
                break;
            case THREE_KIND_OF_BOOKS:
                price = THREE_BOOKS_DISCOUNTED;
                break;
            case FOUR_KIND_OF_BOOKS:
                price = FOUR_BOOKS_DISCOUNTED;
                break;
            case FIVE_KIND_OF_BOOKS:
                price = FIVE_BOOKS_DISCOUNTED;
                break;
            default:
                break;
        }
        return price;
    }

    private int getUniqueBooksInShoppingBasket() {
        int quantityUnique = 0;

        for (int  i = 0; i < FIVE_KIND_OF_BOOKS; i++) {
            if (this.booksQuantity[i] != 0) {
                quantityUnique++;
            }
        }
        return quantityUnique;
    }

    public double getFinalPriceOfShoppingBasket() {
        int quantityUnique = getUniqueBooksInShoppingBasket();
        double finalPrice = 0.00;

        if (quantityUnique == 1) {
            finalPrice = getShoppingBasketPriceSameBooks();
        } else {
            while (quantityUnique > 0) {
                for (int i = 0; i < FIVE_KIND_OF_BOOKS; i++) {
                    if (this.booksQuantity[i] > 0) {
                        this.booksQuantity[i] -= 1;
                    }
                }
                finalPrice += getStandardDiscount(quantityUnique);
                quantityUnique = getUniqueBooksInShoppingBasket();
            }
        }
            return finalPrice;
    }
}
