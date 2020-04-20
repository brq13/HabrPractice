package Practice.Vector;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class MainVectorClass {
    public static void main(String[] args) {
        MyVector myVector1 = new MyVector("Вектор 1", 7, 2, 3);
        MyVector myVector2 = new MyVector("Вектор 2", 2, 5, 6);

        printVector(myVector1); //координаты вектора
        printVector(myVector2);
        vectorLength(myVector1); //длинна вектора
        vectorLength(myVector2);
        vectorScalarProduct(myVector1, myVector2); //скалярное произведение векторов
        printVector(vectorVectorProduct(myVector1, myVector2)); //векторное произведение векторов
        angleBetweenVectors(myVector1, myVector2); //угол (в градусах) между векторами
        printVector(sumOfVectors(myVector1, myVector2)); //сумма векторов
        printVector(differenceOfVectors(myVector1, myVector2)); //разность векторов
        printArrayOfVectors(arrayOfVectors(10)); //массив случайных векторов размером N(10)

    }


    public static void printVector(MyVector myVector) {
        System.out.println(myVector.getName());
        System.out.println("X: " + myVector.getX());
        System.out.println("Y: " + myVector.getY());
        System.out.println("Z: " + myVector.getZ());
    }

    public static double vectorLength(MyVector myVector) {
        double myVectorLength = Math.sqrt(Math.pow(myVector.getX(), 2) + Math.pow(myVector.getY(), 2) + Math.pow(myVector.getZ(), 2));
        System.out.println("Длинна вектора " + myVector.getName() + " равна " + myVectorLength);
        return myVectorLength;
    }

    public static double vectorScalarProduct(MyVector myVector1, MyVector myVector2) {
        double myVectorScalarProduct = myVector1.getX() * myVector2.getX() + myVector1.getY() * myVector2.getY() + myVector1.getZ() * myVector2.getZ();
        System.out.println("Скалярное произведение вектора " + myVector1.getName() + " и " + myVector2.getName() + " равно " + myVectorScalarProduct);
        return myVectorScalarProduct;
    }

    public static MyVector vectorVectorProduct(MyVector myVector1, MyVector myVector2) {
        MyVector vectorVectorProduct = new MyVector("Векторное произведение векторов " + myVector1.getName() + " и " + myVector2.getName(), myVector1.getY() * myVector2.getZ() - myVector1.getZ() * myVector2.getY(), myVector1.getZ() * myVector2.getX() - myVector1.getX() * myVector2.getZ(), myVector1.getX() * myVector2.getY() - myVector1.getY() * myVector2.getX());
        return vectorVectorProduct;
    }

    public static double angleBetweenVectors(MyVector myVector1, MyVector myVector2) {
        double myAngleBetweenVectors = Math.toDegrees(Math.acos(vectorScalarProduct(myVector1, myVector2) / (Math.abs(vectorLength(myVector1)) * Math.abs(vectorLength(myVector2)))));
        System.out.println("Угол (в градусах) между векторами  " + myVector1.getName() + " и " + myVector2.getName() + " равен " + myAngleBetweenVectors);
        return myAngleBetweenVectors;
    }

    public static MyVector sumOfVectors(MyVector myVector1, MyVector myVector2) {
        MyVector sumOfVectors = new MyVector("Сумма векторов " + myVector1.getName() + " и " + myVector2.getName(), myVector1.getX() + myVector2.getX(), myVector1.getY() + myVector2.getY(), myVector1.getZ() + myVector2.getZ());
        return sumOfVectors;
    }

    public static MyVector differenceOfVectors(MyVector myVector1, MyVector myVector2) {
        MyVector differenceOfVectors = new MyVector("Разность векторов " + myVector1.getName() + " и " + myVector2.getName(), myVector1.getX() - myVector2.getX(), myVector1.getY() - myVector2.getY(), myVector1.getZ() - myVector2.getZ());
        return differenceOfVectors;
    }

    public static List<MyVector> arrayOfVectors(int numberOfVectors) {
        List<MyVector> listMyVector = new ArrayList<>();
        for (int i = 0; i < numberOfVectors; i++) {
            listMyVector.add(new MyVector(Integer.toString(i), (int) (Math.random() * 10), (int) (Math.random() * 10), (int) (Math.random() * 10)));
        }
        return listMyVector;
    }

    public static void printArrayOfVectors(List<MyVector> listMyVector) {
        for (int i = 0; i < listMyVector.size(); i++) {
            System.out.println("Вектор " + listMyVector.get(i).getName() + " с координатами (" + listMyVector.get(i).getX() + ", " + listMyVector.get(i).getY() + ", " + listMyVector.get(i).getZ() + ")");
        }

    }


}
