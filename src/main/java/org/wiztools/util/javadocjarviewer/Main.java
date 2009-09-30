package org.wiztools.util.javadocjarviewer;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

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
        final URI indexFileUri = indexFile.toURI();

        // Give user feedback:
        System.out.println("Opening: " + indexFileUri.toString());

        // Open default page in web browser:
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(indexFileUri);
        }
        else{
            System.err.println("Java platform does not support opening web-browser!");
            System.exit(2);
        }
    }
}
