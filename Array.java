package GB;

public class Array {


    private static final int sizeArray = 4;

    public void checkSize (String[][] arr) throws MyArraySizeException {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != sizeArray | arr[i].length != sizeArray) {
                throw new MyArraySizeException("Incorrect array size: " + arr[i].length + ". Correct array size: " + sizeArray + "x" + sizeArray);
            }
        }
        System.out.println("Correct array size...");
    }

    public void checkData(String[][] array) throws MyArrayDataException {
        int[][] arr = new int[array.length][array.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    arr[i][j] = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect array data: " + String.valueOf(array[i][j]) + " Correct array data: int.");

                    String mass = String.format("Invalid character in array: array[%s][%s]", i, j);
//                    e.printStackTrace();
                    throw new MyArrayDataException(mass, e);
                }
            }
        }
    }
}

