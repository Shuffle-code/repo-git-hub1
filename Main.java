package GB;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws MyArrayDataException {
        Array array = new Array();


        checkArray(array);
        checkArrayData(array);
        arrayString(3, "Hello");
        printArray2(getMatrix());
        printArray2(arr2string(4,10));
        printArray22(arrayInt(arr2string(4,99)));
        sum(arrayInt(getMatrix()));

        text(10);
        txt(12);


    }
    static void checkArray(Array array) {
        try {
            array.checkSize(getMatrix());

        } catch (MyArraySizeException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            ex.printStackTrace();
        }
    }
    static void checkArrayData(Array array){
        try{
            array.checkData((getMatrix()));
        }catch (MyArrayDataException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    static String[][] getMatrix(){
        String[][] matrix = {
                {"1", "2", "3", "4"},
                {"9", "8", "7", "6"},
                {"2", "2", "2", "2"},
                {"3", "@", "3", "3", "2"}
        };
       return matrix;
    }
    static String[] arrayString(int len, String text) {
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = text;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" \n");
        return arr;
    }

    static String[][] arr2string(int size, int number){
        String[][] arr = new String[size][size];
        int[][] array = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = txt(generateRandom(number));;
            }
        }
        return arr;
    }
    static int[][] arrayInt(String[][] array) throws MyArrayDataException{
        int[][] arr = new int[array.length][array.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    arr[i][j] = Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e) {
                    System.out.println("Incorrect array data: " + array[i][j] + " Correct array data: int.");

                    String mass = String.format("Invalid character in array: array[%s][%s]", i, j);
//                    e.printStackTrace();
                    throw new MyArrayDataException(mass, e);
                }
            }
        }
        return arr;
    }

    static int sum (int[][] arr){
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                s += arr[i][j];
            }
        }
        System.out.println(s);
        return s;

    }

    static int generateRandom(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }
    static void printArray2(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
//                System.out.print(array[j] + " ");
            }
        }
        System.out.println(" \n ");
    }
    static void printArray22(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");

//                System.out.print(array[j] + " ");
            }
        }
        System.out.println(" \n ");
    }

    static String text(int num){

        String text = "" + num;
//        System.out.println(text);
        return text;
    }
    static String txt(int num){
        String txt = Integer.toString (num);
//        System.out.println(txt);
        return txt;
    }

}
