package cs2s03;

public class MatrixArrayRC {

	private long[][] mat; //global record n_flat, of type flatNElems

	//constructor which creates the global record given an array of length 9
	public MatrixArrayRC (long[] in_array) throws WrongLength{
		if (in_array.length != 9){ //throws error if length of array != 9
			throw new WrongLength (9, in_array.length, "in_array");
		}
		else{ //updates record with in_array if in_array.length == 9
			this.mat = flatTo2D(in_array);
		}
	}
	//constructor which creates the global record given an integer n and an array of length n
	public MatrixArrayRC (int n, long[] in_array) throws WrongLength{
		if (in_array.length != n){ //throws error if length of array != n
			throw new WrongLength (n, in_array.length, "in_array");
		}
		else{ //updates record with in_array if in_array.length == n
			this.mat = flatTo2D(in_array);
		}
	}
	//multiplies the matrix A in the global record by itself i times
	public long[][] smultiply(int i){
		int sl = this.mat.length; //jumps to method sideLength to obtain the side length n of the matrix A
		//a temporary 2D array tempMatA, and is made equal to A
		long[][] tempMatA = this.mat;
		long[][] tempMat2 = new long[sl][sl]; //creates a temporary 2D matrix of the same size as tempMatA
		long[][] outMat = new long[sl][sl];
		
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
		return outMat;
	}
	//given a 2D array "in_mat", this method returns the transpose of it
	//(as long as in_array is an nxn matrix)
	
	public long[][] flatTo2D (long[] in_array1d){
		int sl = (int)Math.sqrt(in_array1d.length);
		long[][] out_array = new long[sl][sl]; //declares output 2D array
		int q = 0; //temporary variable, used in following nested for loop
		for(int a = 0; a < sl; a++){ //loops until a == side length
			for(int b = 0; a < sl ; b++){ //loops until b == side length
				//q is initially set to zero. With each iteration of the b for-loop, the value of
				//out_array[a][b] is replaced with in_array[q], and q is incremented by 1. This means
				//that, for every iteration of the a for-loop, q is incremented by sl
				out_array[a][b] = in_array1d[q]; 
				q = q + 1;
				}
			}
		return out_array;
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


