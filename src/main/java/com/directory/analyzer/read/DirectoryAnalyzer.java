package com.directory.analyzer.read;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryAnalyzer {

    private int numFolders;
    private int numFiles;

    public DirectoryAnalyzer() {
        numFolders = 0;
        numFiles = 0;
    }

    public void analyzeDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path provided.");
            return;
        }

        try {
            StringBuilder xmlContent = new StringBuilder();
            xmlContent.append("<directory>\n");
            processDirectory(directory, xmlContent);
            xmlContent.append("</directory>");

            // Write to XML file
            FileWriter writer = new FileWriter("C:\\Users\\dell\\Desktop\\directory_hierarchy.xml");
            writer.write(xmlContent.toString());
            writer.close();

            System.out.println("Analysis completed:");
            System.out.println("Number of folders: " + numFolders);
            System.out.println("Number of files: " + numFiles);
            System.out.println("XML hierarchy saved to directory_hierarchy.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processDirectory(File directory, StringBuilder xmlContent) {
        xmlContent.append("<folder name=\"").append(directory.getName()).append("\">\n");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    numFolders++;
                    processDirectory(file, xmlContent);
                } else {
                    numFiles++;
                    xmlContent.append("<file>").append(file.getName()).append("</file>\n");
                }
            }
        }
        xmlContent.append("</folder>\n");
    }
}
