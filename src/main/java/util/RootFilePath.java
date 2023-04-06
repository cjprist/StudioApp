package util;

import java.io.File;

public class RootFilePath {

    private String rootFilePath;

    public RootFilePath() {
        String os = System.getProperty("os.name").toLowerCase();

        if(os.contains("win"))
            this.rootFilePath = System.getProperty("user.dir") + File.separator + "data";
        else
            this.rootFilePath = "/home/ubuntu/UNCR/data";
    }

    public String getRootFilePath() {
        return this.rootFilePath;
    }
}
