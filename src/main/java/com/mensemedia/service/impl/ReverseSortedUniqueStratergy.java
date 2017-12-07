package com.mensemedia.service.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.codec.binary.Hex;

import com.mensemedia.service.Strategy;
import com.mensemedia.utils.Utility;

public class ReverseSortedUniqueStratergy implements Strategy {
    
    private List<String> items;
    
    public ReverseSortedUniqueStratergy(List<String> items) {
        this.items = items;
    }
    
    @Override
	public void showResult() {
        
        Set<String> reverseValueSet = new TreeSet<>(Collections.reverseOrder());
        
        for(Iterator<String> entryIterator = items.iterator(); entryIterator.hasNext();) {
            String value = entryIterator.next();

            byte[] hash = Utility.stringToMD5(value);
            //convert to hexadecimal format
            String hex = new String(Hex.encodeHex(hash));

            value = value + "(" + hex + ")";
            reverseValueSet.add(value);
        }

        for(String value : reverseValueSet){
            System.out.println(value);
        }
	}

}
