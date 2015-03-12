package know;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class IO implements Virtual {

    @Override
    public File call() throws Exception {
        file = new File(folder + "/" + name + "." + type);
        new Thread(this).start();
        return file;
    }

    @Override
    public void run() {
        try {
            if (file.exists()) {
                Files.delete(file.toPath());
            } else {
                Files.createDirectories(file.getParentFile().toPath());
            }
            try (FileWriter fw = new FileWriter(file)) {
                fw.write(virtual);
            }
        } catch (IOException e) {
            System.out.println("... ERROR writing file ...." + e.getLocalizedMessage());
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFolder() {
        return folder;
    }

    @Override
    public void setFolder(String parent) {
        this.folder = parent;
    }

    @Override
    public String getContent() {
        return virtual;
    }

    @Override
    public void setContent(String value) {
        this.virtual = value;
    }

    public IO() {
    }

    public IO(String folder, String name, String type, String virtual) {
        this.type = type;
        this.name = name;
        this.folder = folder;
        this.virtual = virtual;
    }

    private String type;
    private String name;
    private String folder;
    private String virtual;
    private File file;

}
