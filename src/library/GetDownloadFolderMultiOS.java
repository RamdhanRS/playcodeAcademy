/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author user
 */
public class GetDownloadFolderMultiOS {

    public static File getDownloadFolder() {
        String userHome = System.getProperty("user.home");
        File downloadDir = new File(userHome, "Download");

        if (downloadDir.exists()) {
            return downloadDir;
        } else {
            return FileSystemView.getFileSystemView().getDefaultDirectory();
        }
    }
}
