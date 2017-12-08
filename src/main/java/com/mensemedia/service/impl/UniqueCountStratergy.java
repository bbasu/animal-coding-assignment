package com.mensemedia.service.impl;


import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mensemedia.service.Strategy;

/**
 * 
 * @author bbasu
 * 
 * UNIQUE COUNT STRATEGY
 * 
 * E.g. 
 * six : 2
 * one : 2
 * seven : 1
 * three : 2
 * two : 1
 *
 */
public class UniqueCountStratergy implements Strategy{
    
    private List<String> items;
    
    public UniqueCountStratergy(List<String> items) {
        this.items = items;
    }

    @Override
	public void showResult() {
        
        Map<String, Integer> valueMap = new HashMap<>();
		
        for(Iterator<String> entryIterator = items.iterator(); entryIterator.hasNext();) {
            String value = entryIterator.next();
            int numberOccurrence = Collections.frequency(items, value);
            valueMap.put(value, numberOccurrence);
        }

        for (Map.Entry<String, Integer> entry : valueMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
	}

}
