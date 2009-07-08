package org.wiztools.util.javadocjarviewer;

import java.io.File;
import junit.framework.TestCase;

/**
 *
 * @author subhash
 */
public class UnzipUtilTest extends TestCase {
    
    public UnzipUtilTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of unzip method, of class UnzipUtil.
     */
    public void testUnzip() throws Exception {
        System.out.println("unzip");
        File input = new File("src/test/resources/qdox-1.9-javadoc.jar");
        File outputDir = new File(System.getProperty("java.io.tmpdir"),
                RandomUtil.getRandomStr(4));
        outputDir.mkdir();
        UnzipUtil.unzip(input, outputDir);
        outputDir.delete();
    }

}
