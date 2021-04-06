package hu.meiit.haladojava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class App {

    private static List<Double> optimizeWeights(Perception.optimizerParameter optimizerParameter) {
        List<Double> rv = new ArrayList<>();
         rv.add( optimizerParameter.getWeights().get(0) +
                 optimizerParameter.getLearningRate() *
                 optimizerParameter.getError() *
                 optimizerParameter.getInput1());

        rv.add( optimizerParameter.getWeights().get(1) +
                optimizerParameter.getLearningRate() *
                        optimizerParameter.getError() *
                        optimizerParameter.getInput2());


        rv.add( optimizerParameter.getWeights().get(2) +
                optimizerParameter.getLearningRate() *
                        optimizerParameter.getError() *
                        optimizerParameter.getBias());



        return rv;

        }

    public static void main(String[] args) {
      Perception perception = new Perception(values -> values.getReal()- values.getCalculated(),
              App::optimizeWeights);

        for  ( int i = 0; i < 10; i++){
            perception.perceptron(0,0,0);
            //perception.perceptron(0,1,1);
            //perception.perceptron(1,0,1);
            //perception.perceptron(1,1,1);
            double predict00 = perception.predict(0,0);
            //double predict01 = perception.predict(0,1);
            //double predict10 = perception.predict(1,0);
            //double predict11 = perception.predict(1,1);
            System.out.println("predict00 " + predict00);
            //System.out.println("predict01 " + predict01);
            //System.out.println("predict10 " + predict10);
            //System.out.println("predict11 " + predict11);

        }





    }
}
