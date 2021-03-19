package com.rnaidu.webcrawler.main;

import com.rnaidu.webcrawler.helper.WebCrawler;

public class Main {
	 // Driver Code 
    public static void main(String[] args) 
    { 
        // Creating Object of WebCrawler 
        WebCrawler web_crowler 
            = new WebCrawler(); 
  
        // Given URL 
        String root 
            = "http://wiprodigital.com"; 
  
        // Method call 
        web_crowler.discover(root); 
        web_crowler.writeToFile("Wiprowebsitesdiscovered");
    } 

}
