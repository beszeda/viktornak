package hu.meiit.haladojava;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Perception {
    private final double learningRate = 0.01;
    private final double bias = 1;
    private List<Double> weights = new ArrayList<>();
    private final Function<Values,Double> lossFn;
    private final Function<optimizerParameter, List<Double>> optimizerFn;

    @AllArgsConstructor
    @Getter
public class optimizerParameter{
        private double error;
  private List<Double> weights;
    private double learningRate;
    private double input1;
    private double input2;
    private double bias;

}

    @AllArgsConstructor
    @Getter
    public class Values{
        private double calculated;
        private double real;
    }

    public Perception(Function<Values, Double> lossFn, Function<optimizerParameter, List<Double>> optimizerFn) {
        this.lossFn = lossFn;
        this.optimizerFn = optimizerFn;
        for ( int i = 0; i < 3; i++){
            weights.add(Math.random());
        }
    }

    private double calc( double feature, double label){
        double calcValue = feature*weights.get(0) + feature*weights.get(1) + bias*weights.get(2);
        return (calcValue <= 0)? 0: calcValue;

    }
    public double predict(double feature, double feature2){
        return calc(feature,feature2);
    }

   /* private double loss (double calculated, double real){
        return real- calculated;
    }*/


    public void perceptron(double input1,double input2, double output){
       // double calculated = ;
        double error = lossFn.apply(new Values(calc(input1,input2),output));
         weights = optimizerFn.apply(
                new optimizerParameter(error,this.weights,this.learningRate,input1,input2,bias)
        );


    }
}
