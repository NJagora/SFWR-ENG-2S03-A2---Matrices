package cs2s03;

import static org.junit.Assert.*;

import org.junit.Test;

import cs2s03.Matrix3x3cr.Column3;
import cs2s03.Matrix3x3flat.Record9;
import cs2s03.Matrix3x3rc.Row3;

public class Testing {

	private long[] m01 = {1, 1, 1, 1, 1, 1, 1, 1, 1}; //all 1 matrix
    private long[] m02 = {1, 0, 0, 0, 1, 0, 0, 0, 1}; //identity matrix
    private long[] m03 = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    private long[] m04 = {3, 2, 1, 3, 2, 1, 3, 2, 1};
    private long[] m05 = {1, 2, 0, 3, 4, 0, 0, 0, 0};
    private long[] m06 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private long[] m07 = {1, 4, 7, 2, 5, 8, 3, 6, 9};
    private long[] m08 = {-1, -2, -3, -4, -5, -6, -7, -8, -9};
    private long[] m09 = {-1, 2, -3, 4, -5, 6, -7, 8, -9};
    private long[] m10 = {2, 4, 0, 1, -2, 0, 0, 0, 0}; //matrix N, such that N^2 = 0
    private long[] m00 = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //matrix containing all zeroes. May be useful.
    //note, m02^2 = m02, and m10^2 = m00
    private long[] m01_i2 = {3, 3, 3, 3, 3, 3, 3, 3, 3};//m01^2
    private long[] m03_i2 = {12, 12, 12, 12, 12, 12, 12, 12, 12}; //m03^2
    private long[] m04_i2 = {18, 12, 6, 18, 12, 6, 18, 12, 6}; //m04^2
    private long[] m05_i2 = {7, 10, 0, 15, 22, 0, 0, 0, 0}; //m05^2
    private long[] m06_i2 = {30, 36, 42, 66, 81, 96, 102, 126, 150}; //m06^2
    private long[] m07_i2 = {30, 66, 102, 36, 81, 126, 42, 96, 150}; //m07^2
    //m08^2 = m06_i2
    private long[] m09_i2 = {30, -36, 42, -66, 81, -96, 102, -126, 150}; //m09^2
    //note, m02^3 = m03, m10^3 = m00
    private long[] m01_i3 = {9, 9, 9, 9, 9, 9, 9, 9, 9}; //m01^3
    private long[] m03_i3 = {72, 72, 72, 72, 72, 72, 72, 72, 72}; //m03^3
    private long[] m04_i3 = {108, 72, 36, 108, 72, 36, 108, 72, 36}; //m04^3
    private long[] m05_i3 = {37, 54, 0, 81, 118, 0, 0, 0, 0}; //m05^3
    private long[] m06_i3 = {468, 576, 684, 1062, 1305, 1548, 1656, 2034, 2412}; //m06^3
    private long[] m07_i3 = {468, 1026, 1656, 576, 1305, 2034, 684, 1548, 2412}; //m07^3
    private long[] m08_i3 = {-468, -576, -684, -1062, -1305, -1548, -1656, -2034, -2412}; //m08^3 (!= m06^3)
    private long[] m09_i3 = {-468, 576, -684, 1062, -1305, 1548, -1656, 2034, -2412}; //m09^3
    
    //2D array containing un-multiplied arrays
    private long[][] matrices = {m01, m02, m03, m04, m05, m06, m07, m08, m09, m10, m00};
    //2D array containing matrices multiplied by themselves
    private long[][] matrices_i2 = {m01_i2, m02, m03_i2, m04_i2, m05_i2, m06_i2, m07_i2, m06_i2, m09_i2, m00};
    //2D array containing matrices multiplied by themselves twice
    private long[][] matrices_i3 = {m01_i3, m02, m03_i3, m04_i3, m05_i3, m06_i3, m07_i3, m08_i3, m09_i3, m00};
    
    //flattens a record of type Record9 (found in Matrix3x3flat) into a 1D array
    private long[] Record9Flatten(Record9 in_rec9){
    	long[] out_array = new long[9];
    	out_array[0] = in_rec9.elem1_1;
    	out_array[1] = in_rec9.elem1_2;
    	out_array[2] = in_rec9.elem1_2;
    	out_array[3] = in_rec9.elem2_1;
    	out_array[4] = in_rec9.elem2_2;
    	out_array[5] = in_rec9.elem2_3;
    	out_array[6] = in_rec9.elem3_1;
    	out_array[7] = in_rec9.elem3_2;
    	out_array[8] = in_rec9.elem3_3;
    	return out_array;
    }
    
    //flattens a record of type Column3 (found in Matrix3s3cr) into a 1D array
    private long[] Column3Flatten(Column3 in_col3){
    	long[] out_array = new long[9];
    	out_array[0] = in_col3.c1.r1;
		out_array[1] = in_col3.c2.r1;
		out_array[2] = in_col3.c3.r1;
		out_array[3] = in_col3.c1.r2;
		out_array[4] = in_col3.c2.r2;
		out_array[5] = in_col3.c3.r2;
		out_array[6] = in_col3.c1.r3;
		out_array[7] = in_col3.c2.r3;
		out_array[8] = in_col3.c3.r3;
		return out_array;
    }
    
    //flattens a record of type Row3 (found in Matrix3x3rc) into a 1D array
    private long[] Row3Flatten(Row3 in_row3){
    	long[] out_array = new long[9];
    	out_array[0] = in_row3.r1.col1;
    	out_array[1] = in_row3.r1.col2;
    	out_array[2] = in_row3.r1.col3;
    	out_array[0] = in_row3.r2.col1;
    	out_array[1] = in_row3.r2.col2;
    	out_array[2] = in_row3.r2.col3;
    	out_array[0] = in_row3.r3.col1;
    	out_array[1] = in_row3.r3.col2;
    	out_array[2] = in_row3.r3.col3;
    	return out_array;
    }
   
    //same flatten method as in MatrixArrayFlat
    private long[] flatten (long[][] in_mat){
		long[] out_array = new long[(in_mat[0].length * in_mat[0].length)];
		int q = 0; 
		for (int a = 0; a < in_mat.length; a++){
			for (int b = 0; b < in_mat.length; b++){
				out_array[q] = in_mat[a][b];
				q = q + 1;
			}
		}
		return out_array;
    }
    
	@Test
	public void testing() {
		
		//tests each matrix in Matrix3x3flat where i = 0
		for (int i = 0; i < this.matrices.length; i++){
			try {
				cs2s03.Matrix3x3flat out = new cs2s03.Matrix3x3flat(this.matrices[i]);
				Record9 out_smul = out.smultiply(0);
				assertArrayEquals(Record9Flatten(out_smul), this.m02);

			} catch (WrongLength e) {
				// TODO Auto-generated catch block
				System.err.print(e);
				e.printStackTrace();
				
			}
		}
		
		//tests each matrix in Matrix3x3rc where i = 0
		for (int i = 0; i < this.matrices.length; i++){
			try {
				cs2s03.Matrix3x3rc out = new cs2s03.Matrix3x3rc(this.matrices[i]);
				Row3 out_smul = out.smultiply(0);
				assertArrayEquals(Row3Flatten(out_smul), this.m02);

			} catch (WrongLength e) {
				// TODO Auto-generated catch block
				System.err.print(e);
				e.printStackTrace();
				
			}
		}
		
		//tests each matrix in Matrix3x3cr where i = 0
		for (int i = 0; i < this.matrices.length; i++){
			try {
				cs2s03.Matrix3x3cr out = new cs2s03.Matrix3x3cr(this.matrices[i]);
				Column3 out_smul = out.smultiply(0);
				assertArrayEquals(Column3Flatten(out_smul), this.m02);

			} catch (WrongLength e) {
				// TODO Auto-generated catch block
				System.err.print(e);
				e.printStackTrace();
				
			}
		}
		
		//tests each matrix in MatrixArrayFlat where i = 0
		for (int i = 0; i < this.matrices.length; i++){
			try {
				cs2s03.MatrixArrayFlat out = new cs2s03.MatrixArrayFlat(this.matrices[i]);
				long[] out_smul = out.smultiply(0);
				assertArrayEquals(out_smul, this.m02);

			} catch (WrongLength e) {
				// TODO Auto-generated catch block
				System.err.print(e);
				e.printStackTrace();
						
			}
		}
		
		//tests each matrix in MatrixArrayRC where i = 0
		for (int i = 0; i < this.matrices.length; i++){
			try {
				cs2s03.MatrixArrayRC out = new cs2s03.MatrixArrayRC(this.matrices[i]);
				long[][] out_smul = out.smultiply(0);
				assertArrayEquals(flatten(out_smul), this.m02);

			} catch (WrongLength e) {
				// TODO Auto-generated catch block
				System.err.print(e);
				e.printStackTrace();
						
			}
		}
		
		//tests each matrix in MatrixArrayCR where i = 0
		for (int i = 0; i < this.matrices.length; i++){
			try {
				cs2s03.MatrixArrayCR out = new cs2s03.MatrixArrayCR(this.matrices[i]);
				long[][] out_smul = out.smultiply(0);
				assertArrayEquals(flatten(out_smul), this.m02);

			} catch (WrongLength e) {
				// TODO Auto-generated catch block
				System.err.print(e);
				e.printStackTrace();
								
			}
		}
		
		// \(-_-\)=--  I'm out.
	}
}

