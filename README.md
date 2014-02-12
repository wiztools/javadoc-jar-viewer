# WizTools.org Javadoc Jar Viewer

Many projects have started distributing their JavaDocs as a single Jar file. For viewing these files offline, I have to do the following:

1. Create a temporary folder
2. Extract the content of the JavaDoc Jar to this temporary directory
3. View the JavaDoc in a browser

To avoid these steps, we have the **JavaDoc Jar Viewer**. It does all the above. To execute it:

    $ java -jar javadoc-jar-viewer-NN.jar project-NN-javadoc.jar

This will open the JavaDoc's index.html in your default browser.

