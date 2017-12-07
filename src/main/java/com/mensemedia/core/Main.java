package com.mensemedia.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author bbasu
 * 
 * This is the main class, the starting point of the code execution
 *
 */
public class Main {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String args[]) {
        try{
            Thread thread = new Thread(new Executor());
            thread.start();
        } catch(Exception e) {
            LOGGER.error("Exception {} ", e.getMessage());
        }
    }
}
