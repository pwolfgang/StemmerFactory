/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.cla.papolicy.wolfgang.stemmer;

import java.util.function.Function;

/**
 * A Stemmer converts a word to its root form.
 * @author Paul
 */
public interface Stemmer extends Function<String, String> {
    @Override
    String apply(String s);
}
