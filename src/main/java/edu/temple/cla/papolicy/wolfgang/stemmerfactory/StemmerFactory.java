/* 
 * Copyright (c) 2018, Temple University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * * All advertising materials features or use of this software must display 
 *   the following  acknowledgement
 *   This product includes software developed by Temple University
 * * Neither the name of the copyright holder nor the names of its 
 *   contributors may be used to endorse or promote products derived 
 *   from this software without specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package edu.temple.cla.papolicy.wolfgang.stemmerfactory;
import org.tartarus.snowball.javastemmers.SnowballStemmer;

/**
 * Class to find the appropriate stemmer class for a given language.
 * @author Paul Wolfgang
 */
public class StemmerFactory {
    private static final String PACKAGE_NAME = "org.tartarus.snowball.ext.";
    
    /**
     * Get an instance of the appropriate stemmer class. The default is the
     * Porter stemmer for English. If the language is "false" or "0", then
     * no stemming is performed.
     * @param language The target language.
     * @return An instance of the stemmer class.
     */
    public static SnowballStemmer getInstance(String language) {
        if (null == language) language = "porter";
        else switch (language) {
            case "false":
                language = "no";
                break;
            case "FALSE":
                language = "no";
                break;
            case "0":
                language = "no";
                break;
            default:
                break;
        }
        try {
            return (SnowballStemmer)Class.forName(PACKAGE_NAME + language + "Stemmer").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            return new org.tartarus.snowball.ext.noStemmer();
        }
    }

}
