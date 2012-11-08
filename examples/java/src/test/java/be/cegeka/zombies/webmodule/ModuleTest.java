package be.cegeka.zombies.webmodule;

import org.junit.runner.RunWith;

import be.klak.junit.jasmine.JasmineSuite;
import be.klak.junit.jasmine.JasmineTestRunner;

@RunWith(JasmineTestRunner.class)
@JasmineSuite(sources = { "module.js" }, sourcesRootDir = "src/main/javascript")
public class ModuleTest {

}
