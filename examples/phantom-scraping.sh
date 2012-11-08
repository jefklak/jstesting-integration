#!/bin/bash
echo "starting phantomjs to eval js file..."
phantomjs phantom-scraping.js > scraped.html
echo "scraping done - result file: scraped.html"
