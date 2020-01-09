package com.cv.parser.read;

import com.cv.parser.CVParserSingleton;
import com.cv.parser.extract.ExtensionSingleton;
import com.cv.parser.extract.ExtensionSingleton.Ext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import java.io.File;
import java.util.Arrays;

public class ReadFiles {
    private File[] filesInPublicDir;
    private Table tableDirContent;    
    private MenuItem menuItemReadPublicDir;
    private MenuItem mntmExtractPublicDirectory;

    public ReadFiles(MenuItem menuItemReadPublicDir, File[] filesInPublicDir, Table tableDirContent,
	    MenuItem mntmExtractPublicDirectory) {
	this.menuItemReadPublicDir = menuItemReadPublicDir;
	this.filesInPublicDir = filesInPublicDir;
	this.tableDirContent = tableDirContent;
	this.mntmExtractPublicDirectory = mntmExtractPublicDirectory;
    }
    
    public void handleMenuItemClick() {
//	menuItemReadPublicDir.addListener(SWT.Selection, arg0 -> {
            setFiles();
//            menuItemReadPublicDir.setEnabled(false);
//            mntmExtractPublicDirectory.setEnabled(true);
//        });
    }

    private void setFiles() {
        for (int i = 0; i < filesInPublicDir.length; i++) {
            if (filesInPublicDir[i].isFile()) {
                String fileName = filesInPublicDir[i].getName();
                String ext = fileName.substring(fileName.indexOf('.'));
//                TableItem item = new TableItem(tableDirContent, SWT.NONE);
                String[] fExts = {ExtensionSingleton.getInstance().get(Ext.TXT),
                        ExtensionSingleton.getInstance().get(Ext.PDF), ExtensionSingleton.getInstance().get(Ext.DOCX),
                        ExtensionSingleton.getInstance().get(Ext.DOC)};
                if (Arrays.asList(fExts).contains(ext)) {
//                    item.setText(new String[]{(i + 1) + "", ext, fileName, ""});
                    System.out.println(new String[]{(i + 1) + "", ext, fileName, ""});
                } else {
                	System.out.println(new String[]{(i + 1) + "", ext, fileName, "Invalid file extension."});
//                    item.setBackground(CVParserSingleton.getInstance().yellow);
                }
            }
        }
    }

}
