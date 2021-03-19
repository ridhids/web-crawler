package com.rnaidu.webcrawler.helper;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//Class Contains the functions 
//required for WebCrowler 
public class WebCrawler {

	// To store the URLs in the
	// FIFO order required for BFS
	private Queue<String> queue;

	// To store visited URls
	private HashSet<String> discovered_websites;

	// Constructor for initialzing the
	// required variables
	public WebCrawler() {
		this.queue = new LinkedList<>();

		this.discovered_websites = new HashSet<>();
	}

	// Function to start the BFS and
	// discover all URLs
	public void discover(String root) {
		// Storing the root URL to
		// initiate BFS.

		if (root.contains("wiprodigital.com")) {
			this.queue.add(root);
			this.discovered_websites.add(root);

			// It will loop until queue is empty
			while (!queue.isEmpty()) {

				// To store the URL present in
				// the front of the queue
				String v = queue.remove();

				
				 Document document;
				try {
					document = Jsoup.connect(v).get();
				//3. Parse the HTML to extract links to other URLs
	                Elements linksOnPage = document.select("a[href]");
	                
				//Pattern pattern = Pattern.compile(regex);

				// To extract all the URL that
				// matches the pattern in raw
				//Matcher matcher = pattern.matcher(raw);

				// It will loop until all the URLs
				// in the current website get stored
				// in the queue
				for (Element page : linksOnPage)  {

					// To store the next URL in raw
					String actual = page.attr("abs:href");

					//String actualURL = getWiproURLS(actual);
					// It will check whether this URL is
					// visited or not
					if (!discovered_websites.contains(actual)) {

						// If not visited it will add
						// this URL in queue, print it
						// and mark it as visited
						discovered_websites.add(actual);
						System.out.println("Website found: " + actual);

						queue.add(actual);
					}
				}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("For '" + root + "': " + e.getMessage());
				}
	                
			}
		}
	}

	
	}
