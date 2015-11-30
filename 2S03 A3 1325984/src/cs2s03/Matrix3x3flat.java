package cs2s03;

public class Matrix3x3flat {

public Record9 mat; //global instance of record Record9

	public class Record9{ //Record containing 9 individual array elements
		long elem1_1;
		long elem1_2;
		long elem1_3;
		long elem2_1;
		long elem2_2;
		long elem2_3;
		long elem3_1;
		long elem3_2;
		long elem3_3;
		//updates record elements
		Record9 (long elem1_1, long elem1_2, long elem1_3, long elem2_1, long elem2_2, long elem2_3, long elem3_1, long elem3_2, long elem3_3){
			this.elem1_1 = elem1_1;
			this.elem1_2 = elem1_2;
			this.elem1_3 = elem1_3;
			this.elem2_1 = elem2_1;
			this.elem2_2 = elem2_2;
			this.elem2_3 = elem2_3;
			this.elem3_1 = elem3_1;
			this.elem3_2 = elem3_2;
			this.elem3_3 = elem3_3;
		}
	}
	
	public Matrix3x3flat (long[] in_array) throws WrongLength{ //Record constructor. Takes in array of size 9, updates global record as result
		if (in_array.length != 9){ //checks if size of input array == 9. If not, throws an error of type WrongLength
			throw new WrongLength (9, in_array.length, "in_array");
		}
		else{ //if size of input array == 9, passes in array values to global record
		this.mat = new Record9(in_array[0], in_array[1], in_array[2], in_array[3], in_array[4], in_array[5], in_array[6], in_array[7], in_array[8]); 	
		}
	}
	//multiplies the matrix A stored in the record by itself i times
	public Record9 smultiply(int i){ 
		//creates the matrix A as a 2D array
		long[][] tempMatA = new long[3][3];
		tempMatA[0][0] = this.mat.elem1_1;
		tempMatA[0][1] = this.mat.elem1_2;
		tempMatA[0][2] = this.mat.elem1_3;
		tempMatA[1][0] = this.mat.elem2_1;
		tempMatA[1][1] = this.mat.elem2_2;
		tempMatA[1][2] = this.mat.elem2_3;
		tempMatA[2][0] = this.mat.elem3_1;
		tempMatA[2][1] = this.mat.elem3_2;
		tempMatA[2][2] = this.mat.elem3_3;
		
		long[][] tempMat2 = new long[3][3]; //creates a 2D matrix of the same size as A, but filled with zeroes 
		long[][] outMat = new long[3][3];
		
		if (i > 1){
			//in terms of matrix multiplication A^i = A*A*A*A..., if the multiplication A^2 = A*A is interpreted
			//as A*B, where B = A, a represents an increment along a row in A, b represents an increment along
			//a column in B, and a represents an increment along a column in A. Therefore, each time the a loop
			//finishes iterating, tempMat2 = A*A. For each iteration of the j loop, therefore, the previous value of
			//tempMat2 (A^(i-1)) is multiplied by A.
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
			
			
			//a similar version of the previous nested for loop is used in all 6 classes to automate matrix
			//multiplication, to simplify the smultiply method, and to make it easier to edit across 
			//different classes
			
			//returns tempMat2 as output matrix
			outMat = copy(tempMat2, outMat);
		}
		//returns A as output matrix, since A^1 = A
		else if (i == 1){
			outMat = copy(tempMatA, outMat);
		}
		//returns a 3x3 identity matrix if i == 0
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
		
		//creates a new register with the contents of tempMatA
		Record9 tempRec2 = new Record9(outMat[0][0], outMat[0][1], outMat[0][2], outMat[1][0], outMat[1][1], outMat[1][2], outMat[2][0], outMat[2][1], outMat[2][2]);
		return tempRec2;
	}
	
	//method that takes in two 2D arrays in_ar1 and in_ar2, and copies the contents of in_ar1 int in_ar2
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

	
	