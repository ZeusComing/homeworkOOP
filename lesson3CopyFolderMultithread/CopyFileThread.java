import java.io.*;

public class CopyFileThread implements Runnable {
    private File startDir;
    private File toDir;

    public CopyFileThread(File startDir, File toDir) {
        this.startDir = startDir;
        this.toDir = toDir;
    }

    private void copyFile(File fileIn, File fileOut) {
        if (fileIn == null || fileOut == null) {
            throw new IllegalArgumentException("It's null :(");
        }
        try (InputStream is = new FileInputStream(fileIn);
             OutputStream os = new FileOutputStream(fileOut)) {
            byte[] buffer = new byte[1024*1024];
            int byteCopy = 0;
            for (;(byteCopy = is.read(buffer)) > 0 ;) {
                os.write(buffer, 0, byteCopy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyToDir(File fileStart, File toDir) {

        int slashIndex = fileStart.getName().lastIndexOf("\\");
        String fileName = fileStart.getName().substring(slashIndex + 1);
        try {
            File newFile = new File(toDir + "\\" + fileName);
            newFile.createNewFile();
            copyFile(fileStart, newFile);
            System.out.println("\"" + fileName + "\" is copied to " + toDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        copyToDir(startDir, toDir);
    }

    public static void startCopy(File startDir, File finalDir) {
        try {
            if (startDir.isDirectory()) {
                long startTime = System.currentTimeMillis();
                File[] filelist = startDir.listFiles();
                for (int i = 0; i < filelist.length ; i++) {
                    Thread cft = new Thread(new CopyFileThread(filelist[i], finalDir));
                    cft.start();
                    cft.join();
                }
                long time = System.currentTimeMillis() - startTime;
                System.out.println("Folder " + startDir.getName() + " copied to " +
                                    finalDir.getName() + " for " + time + "ms");
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(startDir + " is not directory");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
