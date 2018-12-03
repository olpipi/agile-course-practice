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

    Operation(final String name) {
        this.name = name;
    }

    public abstract Matrix apply(Matrix l, Matrix r);

    @Override
    public String toString() {
        return name;
    }

    private final String name;
}
