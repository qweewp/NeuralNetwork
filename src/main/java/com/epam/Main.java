package com.epam;

import com.epam.util.ConsoleHelper;
import com.epam.util.Randomizer;
import com.sun.org.apache.bcel.internal.classfile.ConstantInteger;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;


public class Main {

    // list of numbers from 0 to 9 in string representation
    private static List<SimpleEntry<Integer, String>> numbers = Arrays.asList(
            new SimpleEntry<>(1, "001001001001001"),
            new SimpleEntry<>(2, "111001111100111"),
            new SimpleEntry<>(3, "111001111001111"),
            new SimpleEntry<>(4, "101101111001001"),
            new SimpleEntry<>(5, "111100111001111"),
            new SimpleEntry<>(6, "111100111101111"),
            new SimpleEntry<>(7, "111001001001001"),
            new SimpleEntry<>(8, "111101111101111"),
            new SimpleEntry<>(9, "111101111001111"),
            new SimpleEntry<>(0, "111101101101111")
    );



    private static List<SimpleEntry<Integer, String>> variationsOfFive = Arrays.asList(

            new SimpleEntry<>(5, "111100111000111"),
            new SimpleEntry<>(5, "111100010001111"),
            new SimpleEntry<>(5, "111100011001111"),
            new SimpleEntry<>(5, "011100111001111"),
            new SimpleEntry<>(5, "011100111001110"),
            new SimpleEntry<>(5, "111100101000111"),
            new SimpleEntry<>(0, "111101101101111")
    );

    public static void main(String[] args) throws IOException {


        SimpleNeuralNetwork simpleNeuralNetwork = new SimpleNeuralNetwork(15, 5);
        for (int i = 0; i < 10000000; i++) {
            simpleNeuralNetwork.train(numbers.get(Randomizer.getRandomNumberInRange(0, 9)));
        }

        ConsoleHelper.printNeuronsWeight(simpleNeuralNetwork.getNeurons(), 3);
        for (int i = 0; i < variationsOfFive.size(); i++) {
            for (int j = 0; j < String.valueOf(variationsOfFive.get(i).getValue()).length(); j++) {
                if (j % 3 == 0) {
                    System.out.println();
                }
                System.out.print("[" + String.valueOf(variationsOfFive.get(i).getValue()).charAt(j) + "]");
            }
            System.out.print("\nAttempt #" + i + ": " + simpleNeuralNetwork.proceed(variationsOfFive.get(i)));
        }
    }
}
