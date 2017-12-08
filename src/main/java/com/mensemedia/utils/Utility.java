package com.mensemedia.utils;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mensemedia.core.Executor;
import com.mensemedia.service.Strategy;
import com.mensemedia.service.impl.ReverseSortedUniqueStratergy;
import com.mensemedia.service.impl.SortedUniqueStratergy;
import com.mensemedia.service.impl.UniqueCountStratergy;

public class Utility {

    private static final Logger LOGGER = LoggerFactory.getLogger(Executor.class);   

    /**
     * 
     * @param inputFileString
     * @return valueMap
     * 
     * This method parses the input.txt file to come up with a value Map,
     * where the categories (identified by upper case) are keys and they have a list of items as values
     */
    public static Map<String, List<String>> getValueMap(String inputFileString) {

        Scanner fileScanner = null;
        String currentCategory = StringUtils.EMPTY;
        Map<String, List<String>> map = new HashMap<>();

        try {
            fileScanner = new Scanner(new FileReader(inputFileString));

            while (fileScanner.hasNext()) {
                String value = fileScanner.nextLine();

                /*
                 * If-else is used to read the CARS category. As CARS has upper cased values as items,
                 * it was necessary to do this check to populate the CARS items/
                 */
                if(StringUtils.isAllUpperCase(value) && !value.equalsIgnoreCase(Constants.CARS)) {
                    currentCategory = value;
                } else if(StringUtils.isAllUpperCase(value) && value.equalsIgnoreCase(Constants.CARS)) {
                    currentCategory = value;
                    while (fileScanner.hasNext()) {
                        String carValue = fileScanner.nextLine();
                        carValue = carValue.toLowerCase();
                        try {
                            map.get(currentCategory).add(carValue);
                        } catch (NullPointerException e) {
                            List<String> list = new ArrayList<>();
                            list.add(carValue);
                            map.put(currentCategory, list);
                        }
                    }
                } else {
                    try {
                        map.get(currentCategory).add(value);
                    } catch (NullPointerException e) {
                        List<String> list = new ArrayList<>();
                        list.add(value);
                        map.put(currentCategory, list);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException {} ", e.getMessage());
        } finally {
            fileScanner.close();
        }

        return map;
    }

    /**
     * 
     * @param value
     * @return byte[] hash
     * 
     * This method converts a string to its corresponding MD5 hash
     */
    public static byte[] stringToMD5(String value) {
        byte[] hash = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance(Constants.MD_5);
            InputStream stream = new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
            DigestInputStream inputStream = new DigestInputStream(stream, md5);
            while (inputStream.read() != -1);
            hash = md5.digest();
        } catch (NoSuchAlgorithmException | IOException e) {
            LOGGER.error("Exception in stringToMD5 {} ", e.getMessage());
            System.exit(-1);
        }
        return hash;
    }

    /**
     * 
     * @param items
     * @return strategyMap
     * 
     * This method populates all the strategies in a map. The keys are the expected input from the user,
     * values are object of the corresponding Impl class defining those strategies
     */
    public static Map<String, Strategy> getStrategies(List<String> items) {

        Map<String, Strategy> stratergyMap = new HashMap<>();

        stratergyMap.put("1", new SortedUniqueStratergy(items));
        stratergyMap.put("2", new UniqueCountStratergy(items));
        stratergyMap.put("3", new ReverseSortedUniqueStratergy(items));

        return stratergyMap;
    }  
}
