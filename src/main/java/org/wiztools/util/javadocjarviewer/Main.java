package org.wiztools.util.javadocjarviewer;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author subhash
 */
public class Main {

    private static final String TMP_FOLDER_PREFIX = "jdoc-";

    private static File getTempFolder() throws IOException{
        while(true){
            File f = new File(new File(System.getProperty("java.io.tmpdir")),
                TMP_FOLDER_PREFIX + RandomUtil.getRandomStr(4));
            if(!f.exists()){
                if(!f.mkdir()){
                    throw new IOException("Cannot create directory: "
                        + f.getAbsolutePath());
                }
                return f;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Cli validation:
        if(args.length != 1){
            System.err.println("Please enter the JavaDoc jar file as parameter.");
            System.exit(1);
        }

        // Unzip:
        final File javadocJarFile = new File(args[0]);

        File tmpDir = getTempFolder(); // directory where JavaDocs will be extracted
        UnzipUtil.unzip(javadocJarFile, tmpDir);

        // Check if index.html is available:
        File indexFile = new File(tmpDir, "index.html");
        if(!indexFile.exists()){
            throw new IOException("File not available: "
                    + indexFile.getAbsolutePath());
        }

        // Give user feedback:
        System.out.println("Opening: " + indexFile.toURI().toString());

        // Get which browser to use:
        String webBrowser = System.getProperty("web.browser");
        if(webBrowser == null){
            webBrowser = "firefox";
        }

        // Open default page in web browser:
        try{
            Runtime.getRuntime().exec(new String[]{webBrowser,
                indexFile.toURI().toString()});
        }
        catch(IOException ex){
            System.err.println("Error opening browser: " + webBrowser);
            System.exit(2);
        }
    }
}
