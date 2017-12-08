package com.mensemedia.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mensemedia.service.Strategy;
import com.mensemedia.utils.Constants;
import com.mensemedia.utils.Utility;

public class Executor implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Executor.class);
    protected List<String> items = new ArrayList<>();
    protected Map<String, Strategy> strategyMap = new HashMap<>();
    protected Map<String, List<String>> valueMap = new HashMap<>();
    protected String inputFileString;
    protected Scanner inputScanner;
    protected String inputCategory;
    protected String inputStrategy;

    /**
     * This method in executed first, when the Executor class gets called
     */
    @Override
    public void run() {
        
        valueMap = Utility.getValueMap("input2.txt");
        try {

            inputScanner = new Scanner(System.in);
            boolean running=true;

            while(running) {                
                
                System.out.println(Constants.INPUT_CATEGORY);
                inputCategory = inputScanner.nextLine();                
                inputCategory = inputCategory.toUpperCase();
                
                isInputZero(inputCategory);
                
            }
        } catch (NumberFormatException e) {
            try {
                checkCategory(inputCategory);

                items = valueMap.get(inputCategory);
                strategyMap = Utility.getStrategies(items);

                System.out.println(Constants.INPUT_STRATEGY);
                inputStrategy = inputScanner.nextLine();
                
                isInputZero(inputStrategy);
                displayResults(inputStrategy, strategyMap);
                
            } catch (NumberFormatException ne) {
                LOGGER.error("NumberFormatException {} ", e.getMessage());
            }
        } catch (Exception e) {
            LOGGER.error("Exception {} ", e.getMessage());
        }
    }
    
    /**
     * @param value
     * 
     * This method checks if the input is 0. The control flows to the catch block and program is exited.
     */
    private void isInputZero(String value) {
        try {
            int k=1;
            k = k/Integer.parseInt(value);
        } catch (ArithmeticException e) {
            System.out.println(Constants.EXIT);
            System.exit(0);
        }
        
    }
        
    /** 
     * @param inputCategory
     * 
     * This method checks if an input category exists. The control flows to the catch block and an 
     * appropriate message is shown and program is exited.
     */
    private void checkCategory(String inputCategory) {
        try {
            valueMap.get(inputCategory).size();
        } catch (NullPointerException e) {
            System.out.println(Constants.CATEGORY_DOES_NOT_EXISTS);
            System.exit(0);
        }        
    }

    /**
     * 
     * @param inputStrategy
     * @param strategyMap
     * 
     * Displaying the results on the basis of the input category and input strategy
     */
    private void displayResults(String inputStrategy, Map<String, Strategy> strategyMap) {

        Strategy strategy;        
        try {
            strategy = strategyMap.get(inputStrategy);
            strategy.showResult();
        } catch (NullPointerException e) {
            System.out.println(Constants.STRATEGY_DOES_NOT_EXISTS);
            strategy = strategyMap.get(Constants.ONE);
            strategy.showResult();
        }        
    }
}
