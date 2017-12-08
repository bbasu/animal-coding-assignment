package com.mensemedia.service.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.codec.binary.Hex;

import com.mensemedia.service.Strategy;
import com.mensemedia.utils.Utility;

/**
 * 
 * @author bbasu
 * 
 * REVERSE UNIQUE SORTED HASH STRATEGY
 * 
 * E.g. 
 * vw(7336a2c49b0045fa1340bf899f785e70)
 * opel(f65b7d39472c52142ea2f4ea5e115d59)
 * bmw(71913f59e458e026d6609cdb5a7cc53d)
 * audi(4d9fa555e7c23996e99f1fb0e286aea8)
 *
 */
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
