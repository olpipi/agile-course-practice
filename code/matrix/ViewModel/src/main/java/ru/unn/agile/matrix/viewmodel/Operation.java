package ru.unn.agile.matrix.viewmodel;

import ru.unn.agile.matrix.model.Matrix;

public enum Operation {
    ADD("+") {
        public Matrix apply(final Matrix l, final Matrix r) {
            return l.add(r);
        }
    },
    SUBTRACT("-") {
        public Matrix apply(final Matrix l, final Matrix r) {
            return l.subtract(r);
        }
    },
    MULTIPLY("x") {
        public Matrix apply(final Matrix l, final Matrix r) {
            return l.multiply(r);
        }
    };

    private final String name;

    Operation(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract Matrix apply(Matrix l, Matrix r);
}
