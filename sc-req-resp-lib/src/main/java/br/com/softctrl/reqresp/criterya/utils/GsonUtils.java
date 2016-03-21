/**
 * 
 */
package br.com.softctrl.reqresp.criterya.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
The MIT License (MIT)

Copyright (c) 2015 Carlos Timoshenko Rodrigues Lopes
http://www.0x09.com.br

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

/**
 * 
 * @author carlostimoshenkorodrigueslopes@gmail.com
 */
public final class GsonUtils {

    private GsonUtils() {
    }

    private static final Gson GSON = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().serializeNulls()
            .create();
    private static final Gson GSON_PRETTY = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().serializeNulls()
            .setPrettyPrinting().create();

    /**
     * 
     * @param json
     * @param clazz
     * @return
     */
    public static final <T> T fromJson(final String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    /**
     * 
     * @param object
     * @return
     */
    public static final <T> String toJson(final Object object) {
        return GSON.toJson(object);
    }

    public static final <T> String toPrettyJson(final Object object) {
        return GSON_PRETTY.toJson(object);
    }

    /**
     * 
     * @param file
     * @param clazz
     * @return
     */
    public static final <T> T fromJsonFile(final String file, Class<T> clazz) {
        T result = null;
        FileReader json;
        try {
            json = new FileReader(new File(file));
            result = GSON.fromJson(json, clazz);
            json.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    /**
     * 
     * @param file
     * @param clazz
     * @return
     */
    public static final <T> T fromJsonFile(final File file, Class<T> clazz) {
        T result = null;
        FileReader json;
        try {
            json = new FileReader(file);
            result = GSON.fromJson(json, clazz);
            json.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

}
