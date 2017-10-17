package com.epam;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrii_Yakovenko on 10/11/2017.
 */
public class SimpleNeuralNetwork {

    private int neuronAmount;
    private int expectedOutput;
    private int bias;
    private ArrayList<Neuron> neurons = new ArrayList<>();

    public SimpleNeuralNetwork(int neuronAmount, int expectedOutput) {
        this.bias = 7; //todo
        this.expectedOutput = expectedOutput;
        for (int i = 0; i < neuronAmount; i++) {
            neurons.add(new Neuron());
        }
    }

    public void train(SimpleEntry<Integer, String> entry) {
        activateNeuron(String.valueOf(entry.getValue()));
        int weightedAverage = calculateWeightedAverage(entry.getValue());
        if (weightedAverage >= bias && !entry.getKey().equals(expectedOutput)) {
            neurons.stream().filter(Neuron::isActive)
                    .forEach(Neuron::decreaseWeight);
        } else if (weightedAverage <= bias && entry.getKey().equals(expectedOutput)) {
            neurons.stream().filter(Neuron::isActive)
                    .forEach(Neuron::increaseWeight);
        }
        clearNeuronState();
    }

    public boolean proceed(SimpleEntry<Integer, String> entry) {
        return calculateWeightedAverage(entry.getValue()) >= bias;
    }

    private void activateNeuron(String pixels) {
        for (int i = 0; i < pixels.length(); i++) {
            if (String.valueOf(pixels.charAt(i)).equals("1")) {
                neurons.get(i).setActive(true);
            }
        }
    }

    private void clearNeuronState() {
        neurons.forEach(neuron -> neuron.setActive(false));
    }

    private int calculateWeightedAverage(String pixels) {
        Integer result = 1;
        for (int i = 0; i < pixels.length(); i++) {
            result += Integer.valueOf(String.valueOf(pixels.charAt(i))) * neurons.get(i).getWeight();
        }
        return result - 1;
    }

    public int getNeuronAmount() {
        return neuronAmount;
    }

    public void setNeuronAmount(int neuronAmount) {
        this.neuronAmount = neuronAmount;
    }

    public int getBias() {
        return bias;
    }

    public void setBias(int bias) {
        this.bias = bias;
    }

    public ArrayList<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }

    private void getNeuronNetworkWeights() {

    }
}
