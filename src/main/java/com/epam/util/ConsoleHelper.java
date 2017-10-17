package com.epam.util;

import com.epam.Neuron;

import java.util.List;
import java.util.Objects;

/**
 * Created by Andrii_Yakovenko on 10/12/2017.
 */
public class ConsoleHelper {

    public static void printNeuronsWeight(List<Neuron> neurons, int columns) {
        Objects.requireNonNull(neurons, "Matrix cannot be null");

        for (int j = 0; j < neurons.size(); j++) {
            if (j % columns == 0) {
                System.out.println();
            }
            System.out.print(neurons.get(j));
        }
    }

}
