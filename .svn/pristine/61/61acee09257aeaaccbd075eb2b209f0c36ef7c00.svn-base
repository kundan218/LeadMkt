/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jspl.lms.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author
 */
public class FileUtility {

    public static String uploadFile(MultipartFile multipart, String uploadFileName, Double maxFileSize,String uploadDocBasePath,Integer maxFileLimit) throws Exception {
        if (multipart != null && !multipart.getOriginalFilename().equals("")) {
            if (multipart.getSize() < maxFileSize) {
                InputStream fileInputStream = multipart.getInputStream();
                if (multipart.getOriginalFilename().contains(".") && !uploadFileName.contains(".")) {
                    uploadFileName = uploadFileName + multipart.getOriginalFilename().substring(multipart.getOriginalFilename().lastIndexOf("."), multipart.getOriginalFilename().length());
                }
                String basePath = uploadDocBasePath;
                String newPath = "";
                if (basePath == null || basePath.trim().equals("") || !new File(basePath).exists()) {
                    throw new RuntimeException("Invalid Virtual Directory");
                } else {
                    Calendar c = Calendar.getInstance();
                    newPath += ("" + c.get(Calendar.YEAR) + (c.get(Calendar.MONTH) > 8 ? (c.get(Calendar.MONTH) + 1) : "0" + (c.get(Calendar.MONTH) + 1)));
                    File file = new File(basePath + File.separator + newPath);
                    Integer maxFileCount = null;
                    try {
                        maxFileCount = 200;
                    } catch (Exception e) {
                    }
                    if (file.exists() && maxFileCount != null) {
                        String tempFilePath = newPath;
                        for (int i = 2; file.list().length >= maxFileCount; i++) {
                            tempFilePath = newPath + "_" + i;
                            file = new File(basePath + File.separator + tempFilePath);
                            if (!file.exists()) {
                                file.mkdir();
                                break;
                            }
                        }
                        newPath = tempFilePath;
                    } else {
                        file.mkdirs();
                    }
                }
                newPath = newPath + File.separator + uploadFileName;
                OutputStream outputStream = new FileOutputStream(basePath + File.separator + newPath);
                int readBytes = 0;
                byte[] buffer = new byte[100000];
                while ((readBytes = fileInputStream.read(buffer, 0, 100000)) != -1) {
                    outputStream.write(buffer, 0, readBytes);
                }
                outputStream.close();
                fileInputStream.close();
                return newPath;
            } else {
                throw new RuntimeException("File Size Exceeded");
            }
        } else {
            throw new RuntimeException("Invalid Multipart Object");
        }
    }
    public static boolean deleteFile(String basePath, String fileName) {
        String fileToDelete = basePath;
        fileToDelete += "/" + fileName;
        File file = new File(fileToDelete);
        return file.delete();
    }
}