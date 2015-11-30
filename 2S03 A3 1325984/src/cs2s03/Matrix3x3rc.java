package cs2s03;

public class Matrix3x3rc {

	private Row3 mat; //global record of type Row3

	public class Row3{ //record containing rows of matrix
		colRow3 r1;
		colRow3 r2;
		colRow3 r3;
		Row3 (colRow3 r1, colRow3 r2, colRow3 r3){
			this.r1 = r1;
			this.r2 = r2;
			this.r3 = r3;
		}
	}
	public class colRow3{ //record containing column elements of matrix
		long col1;
		long col2;
		long col3;
		colRow3(long col1, long col2, long col3){
			this.col1 = col1;
			this.col2 = col2;
			this.col3 = col3;
		}
	}
	//constructor that creates global record. Input is array of size 9, changes record as output
	public Matrix3x3rc (long[] in_array) throws WrongLength{ //throws error of type WrongLength if input array length is not 9
		if (in_array.length != 9){
			throw new WrongLength (9, in_array.length, "in_array");
		}
		else{ //changes global record if length of input array == 9
			//since every 3 elements of the input array correspond to a row of the matrix, every 3 elements are stored in
			//a column register, then the column registers are stored in a row register
			colRow3 a1 = new colRow3(in_array[0], in_array[1], in_array[2]); //stores 1st row
			colRow3 b1 = new colRow3(in_array[3], in_array[4], in_array[5]); //stores 2nd row
			colRow3 c1 = new colRow3(in_array[6], in_array[7], in_array[8]); //stores 3rd row
			this.mat = new Row3(a1, b1, c1); //stores all 3 record in global record
		}
	}
	
	public Row3 smultiply(int i){ //multiplies the matrix A stored in the global record by itself i times
		Row3 tempRec = this.mat; //creates a temporary duplicate of the global record
		long[][] tempMatA = new long[3][3]; //creates the matrix A as a 2D array
		tempMatA[0][0] = tempRec.r1.col1;
		tempMatA[0][1] = tempRec.r1.col2;
		tempMatA[0][2] = tempRec.r1.col3;
		tempMatA[1][0] = tempRec.r2.col1;
		tempMatA[1][1] = tempRec.r2.col2;
		tempMatA[1][2] = tempRec.r2.col3;
		tempMatA[2][0] = tempRec.r3.col1;
		tempMatA[2][1] = tempRec.r3.col2;
		tempMatA[2][2] = tempRec.r3.col3;
		
		long[][] tempMat2 = new long[3][3]; //creates a 2D array of the same size as A
		long[][] outMat = new long[3][3];
		
		if (i > 1){
			//see for loop explanation in class "Matrix3x3flat"
			for (int j = 1; j < i; j ++){ //loops until j == input variable i.
				//j == 1 because matrix multiplication will occur on the first loop, so if i == 2, tempMat2 == A^3, not A^2
				for (int a = 0; a < 3; a++){ //loops until a == side length of A
					for (int b = 0; b < 3; b++){ //loops until b == side length of A
						for (int c = 0; c < 3; c++){ //loops until c == side length of A
							tempMat2[a][b] = tempMat2[a][b] + (tempMatA[a][c] * tempMatA[c][b]);
						}
					}
				}
			}
			//returns tempMat2 as output matrix
			outMat = copy(tempMat2, outMat);
		}
		//returns A as output matrix, since A^1 = A
		else if (i == 1){
			outMat = copy(tempMatA, outMat);
		}
		//returns a 3x3 matrix filled with ones if i == 0
		//A^0 = 1
		else if (i == 0){
			for (int m = 0; m < 3; m++){
				for (int n = 0; n < 3; n++){
					if (m == n){
						outMat[m][n] = 1;
					}
					else{
						outMat[m][n] = 0;
					}
				}
			}
		}
		//after matrix multiplication is performed, the respective elements of the 2D array tempMatA are stored in
		//the temporary register tempRec2, which is then returned
		colRow3 a1 = new colRow3(outMat[0][0], outMat[0][1], outMat[0][2]);
		colRow3 b1 = new colRow3(outMat[1][0], outMat[1][1], outMat[1][2]);
		colRow3 c1 = new colRow3(outMat[2][0], outMat[2][1], outMat[2][2]);
		Row3 tempRec2 = new Row3(a1, b1, c1);
		return tempRec2;
	}

	public long[][] copy (long[][] in_ar1, long[][] in_ar2){
		for (int i = 0; i < in_ar1.length; i++){
			for (int j = 0; j < in_ar1[0].length; j++){
				//each element in in_ar2 is replaced with the corresponding element in in_ar1
				in_ar2[i][j] = in_ar1[i][j];
			}
		}
		return in_ar2;
	}
}
