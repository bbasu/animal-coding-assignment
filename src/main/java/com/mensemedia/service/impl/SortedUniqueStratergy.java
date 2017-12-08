package com.mensemedia.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.mensemedia.service.Strategy;

/**
 * 
 * @author bbasu
 * 
 * UNIQUE SORTED STRATEGY
 * 
 * E.g. 
 * cow
 * horse
 * moose
 * sheep
 *
 */
public class SortedUniqueStratergy implements Strategy{
    
    private List<String> items;
    
    public SortedUniqueStratergy(List<String> items) {
        this.items = items;
    }

    @Override
	public void showResult() {
        
        Set<String> valueSet = new TreeSet<>();
        
        for(Iterator<String> entryIterator = items.iterator(); entryIterator.hasNext();) {
            String value = entryIterator.next();
            valueSet.add(value);
        }
        for(String value : valueSet){
            System.out.println(value);
        }	
	}
}
