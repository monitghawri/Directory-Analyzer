package com.directory.analyzer;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.directory.analyzer.read.DirectoryAnalyzer;

@SpringBootApplication
public class DirectoryAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectoryAnalyzerApplication.class, args);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the directory path:");
		String directoryPath = sc.next();

		DirectoryAnalyzer directoryAnalyzer = new DirectoryAnalyzer();
		directoryAnalyzer.analyzeDirectory(directoryPath);

		sc.close();
	}

}
