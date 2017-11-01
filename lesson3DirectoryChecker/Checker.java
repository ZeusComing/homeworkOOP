import java.io.File;

public class Checker implements Runnable {
    File folder;
    String message;

    public Checker(File folder) {
        this.folder = folder;
    }

    private File[] getCurrentStance() {
        File[] folderCheck = this.folder.listFiles();
        return folderCheck;
    }

    private boolean check (File[] folder, File[] currentStance) {
        if (folder.equals(currentStance)) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean inArray(File file, File[] listFiles) {
        for (int i = 0; i < listFiles.length; i++) {
            if (file.equals(listFiles[i])) {
                return true;
            }
        }
        return false;
    }

    private static void addToArray(File file, File[] filelist) {
        for (int i = 0; i < filelist.length ; i++) {
            if (filelist[i] == null) {
                filelist[i] = file;
                break;
            }
        }
    }

    private File[] getDifferent(File[] folder, File[] currentStance) {
        if (!check(folder,currentStance)) {
            File[] smaller;
            File[] bigger;
            if (folder.length < currentStance.length) {
                smaller = folder;
                bigger = currentStance;
                this.message = " file have been added";
            } else {
                smaller = currentStance;
                bigger = folder;
                this.message = " file have been deleted";
            }
            File[] res = new File[bigger.length - smaller.length];
            for (int i = 0; i < bigger.length ; i++) {
                if (!inArray(bigger[i], smaller)) {
                    addToArray(bigger[i], res);
                }
            }
            return res;
        } else {
            return null;
        }

    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        File[] startStance = getCurrentStance();
        for (; true ;) {
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!check(startStance, getCurrentStance() )) {
                File[] diff = getDifferent(startStance, getCurrentStance());
                for (File f: diff) {
                    System.out.println(f + message);
                }
                startStance = getCurrentStance();
            }
        }

    }
}
