package be.cegeka.zombies.webmodule;

import static org.apache.commons.io.FileUtils.readFileToString;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import sun.org.mozilla.javascript.internal.Context;
import sun.org.mozilla.javascript.internal.ContextFactory;
import sun.org.mozilla.javascript.internal.NativeObject;
import sun.org.mozilla.javascript.internal.Scriptable;

public class PlayingWithRhinoTest {

	private Context jsContext;
	private Scriptable scope;

	@Before
	public void setUp() {
		this.jsContext = ContextFactory.getGlobal().enterContext();
		// tells the Rhino context to initialize "function, object, ..."
		this.scope = jsContext.initStandardObjects();
	}

	private Object eval(String string) {
		// "script", 1 = filename, linenumber
		return jsContext.evaluateString(scope, string, "script", 1, null);
	}

	@Test
	public void letsEvaluateSomethingInJS() {
		Assert.assertEquals(new Integer(3), (Integer) eval("var a = 3; a"));
	}

	@Test
	public void letsLoadOurModuleJSFileIntoTheRhinoContext() throws IOException {
		eval(readFileToString(new File("src/main/javascript/module.js")));

		// wow, I can even bring my JS Objects into Java space!
		NativeObject zombie = (NativeObject) eval("Zombies.create(3)");

		// this is basically a map like in JS, you can ask for it's properties!
		Assert.assertEquals(new Integer(3), (Integer) zombie.get("health", zombie));
	}
}
