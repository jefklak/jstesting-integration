// creating modules
// want more? See API: http://code.google.com/p/phantomjs/wiki/Interface
page = require("webpage").create();
fs = require("fs");

page.onConsoleMessage = function(msg, source, linenumber) {
	console.log(msg);
};

page.open("http://www.jquery.com", function(status) {
	if (status !== "success") {
		conosle.log("could not open jquery page?");
		phantom.exit(1);
	}
	
	var data = page.evaluate(function() {
		console.log($("body").html());
		
		// Do Notice you can't use "page" or "fs" (created above)
		// This function runs in a sandbox on the page itself and has no access to this scope!
		return $("body").html();
	});
	
	var scrapedFile = fs.open("scraped.html", "w");
	scrapedFile.write(data);
	scrapedFile.close();
		
	console.log("");
	console.log("Scraped successfully!");
	phantom.exit(1);
});
