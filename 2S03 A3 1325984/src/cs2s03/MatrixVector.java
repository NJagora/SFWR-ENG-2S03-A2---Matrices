package cs2s03;

import java.util.Vector;

public class MatrixVector {
    private Vector l;

    MatrixVector(long[] elems) throws WrongLength {
        int len = elems.length;
        if (len != 9) {
            throw new WrongLength(len, len, "MatrixVector");
        }
        // rest of constructor code goes here
    }
}
