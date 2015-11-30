package cs2s03;

public class Matrix3x3cr {

	private Column3 mat; //global record of type Column3

	public class Column3{ //record containing individual columns
		columnRow3 c1;
		columnRow3 c2;
		columnRow3 c3;
		Column3 (columnRow3 c1, columnRow3 c2, columnRow3 c3){
			this.c1 = c1;
			this.c2 = c2;
			this.c3 = c3;
		}
	}
	public class columnRow3{ //record containing row elements of a column
		long r1;
		long r2;
		long r3;
		columnRow3(long r1, long r2, long r3){
			this.r1 = r1;
			this.r2 = r2;
			this.r3 = r3;
		}
	}
	//constructor that creates the global record. Takes in array of size 9 as input, changes global record as result
	public Matrix3x3cr (long[] in_array) throws WrongLength{
		if (in_array.length != 9){ //throws exception of type Length Error if the input array is not of size 9
			throw new WrongLength (9, in_array.length, "in_array");
		}
		else{ //changes the global record if input array length == 9
			//since every 3 elements in the input array correspond to a row, firstly every third element is placed
			//into a column record, then the three columns are stored in the global record
			columnRow3 a1 = new columnRow3(in_array[0], in_array[3], in_array[6]); //stores values of column 1
			columnRow3 b1 = new columnRow3(in_array[1], in_array[4], in_array[7]); //stores values of column 2
			columnRow3 c1 = new columnRow3(in_array[2], in_array[5], in_array[8]); //stores values of column 3
			this.mat = new Column3(a1, b1, c1); //stores all 3 columns in global record
		}
	}
	
	public Column3 smultiply(int i){ //multiplies the matrix A stored in the global record by itself i times
		Column3 tempRec = this.mat; //creates a temporary duplicate of the global record
		long[][] tempMatA = new long[3][3];
		//stores the respective values in the temporary duplicate into a 2D array
		//i.e. creates matrix A
		tempMatA[0][0] = tempRec.c1.r1;
		tempMatA[0][1] = tempRec.c2.r1;
		tempMatA[0][2] = tempRec.c3.r1;
		tempMatA[1][0] = tempRec.c1.r2;
		tempMatA[1][1] = tempRec.c2.r2;
		tempMatA[1][2] = tempRec.c3.r2;
		tempMatA[2][0] = tempRec.c1.r3;
		tempMatA[2][1] = tempRec.c2.r3;
		tempMatA[2][2] = tempRec.c3.r3;
		
		long[][] tempMat2 = new long[3][3]; //creates a secondary temporary 2D array of the same size as A
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
		columnRow3 a1 = new columnRow3(outMat[0][0], outMat[1][0], outMat[2][0]);
		columnRow3 b1 = new columnRow3(outMat[0][1], outMat[1][1], outMat[2][1]);
		columnRow3 c1 = new columnRow3(outMat[0][2], outMat[1][2], outMat[2][2]);
		Column3 tempRec2 = new Column3(a1, b1, c1);
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
