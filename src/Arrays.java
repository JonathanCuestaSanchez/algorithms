import java.util.ArrayList;
import java.util.List;

public class Arrays {

    public static void main(String[] args) {
        //Declare
        int[] intArray;
        //Instantiate- put the array length
        intArray = new int[8];
        //Initialize
        intArray[0]=1;
    }

    void singleDimensionalArrry(){
        //Declare
        int[] intArray;
        //Instantiate- put the array length
        intArray = new int[8];
        //Initialize
        intArray[0]=1;
        List hola= new ArrayList(java.util.Arrays.asList(1,1,2,5,5,6,6,9,9));
        System.out.println(hola.indexOf(9));
    }
}
