package com.slotegrator.framework.utils;

import java.io.*;

public class Utils {

    public static void writeDataToFile(String fileName, String data) {
        try (BufferedWriter buf = new BufferedWriter(new FileWriter("src/test/resources/" + fileName + ".txt"))) {
            buf.write(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readDataFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try (BufferedReader buf = new BufferedReader(new FileReader("src/test/resources/" + fileName))) {
            while ((line = buf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(stringBuilder);
    }
}
