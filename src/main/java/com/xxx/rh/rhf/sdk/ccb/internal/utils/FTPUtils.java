package com.xxx.rh.rhf.sdk.ccb.internal.utils;

import com.xxx.rh.rhf.sdk.ccb.CCBPayApiException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * FTP 工具类
 * @author lihy
 * @version 1.0  2017/8/7.
 */
public final class FTPUtils {

    private FTPUtils() {}

    public static boolean upload(FTPClient ftpClient, InputStream in, String remotePath, String fileName) {
        boolean isUpload = false;
        try{
            ftpClient.setBufferSize(1024 * 10 * 10);
            ftpClient.setControlEncoding("GBK");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();//问题所在
            if (!ftpClient.changeWorkingDirectory(remotePath)) {
                isUpload = false;
            }else{
                isUpload = ftpClient.storeFile(fileName, in);
            }
        }catch(Exception e){
            // logger.error("上传文件失败", e);
        }
        return isUpload;
    }

    public static boolean download(FTPClient ftpClient, String remotePath, String fileName, String localFilePath) throws CCBPayApiException {
        ftpClient.setBufferSize(1024 * 10 * 10);
        ftpClient.setControlEncoding("GBK");
        FileOutputStream locaFileOut = null;
        try {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            if (!ftpClient.changeWorkingDirectory(remotePath)) {
                return false;
            }
            locaFileOut = new FileOutputStream(localFilePath);
            return ftpClient.retrieveFile(fileName, locaFileOut);
        } catch (IOException e) {
            throw new CCBPayApiException("文件下载异常", e);
        } finally {
            try {
                if (locaFileOut != null) {
                    locaFileOut.close();
                }
                if (ftpClient != null) {
                    ftpClient.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean connect(FTPClient ftpClient, String url, int port, String username, String password) throws CCBPayApiException {
        boolean connected = false;
        if (ftpClient.isConnected()) {
            return true;
        }
        try {
            ftpClient.connect(url, port);
            if (ftpClient.login(username, password)) {
                connected = true;
            }
            return connected;
        } catch (Exception e) {
            throw new CCBPayApiException(e);
        }
    }

    public static boolean rename(FTPClient ftpClient, String remotePath, String oldFileName, String newFileName) {
        boolean flag = false;
        try{
            ftpClient.enterLocalPassiveMode();
            if(!ftpClient.changeWorkingDirectory(remotePath)){
                flag = false;
            }else{
                flag = ftpClient.rename(oldFileName, newFileName);
            }
        }catch(Exception e){
            // logger.error("删除文件失败", e);
        }
        return flag;
    }

    public static boolean deleteFile(FTPClient ftpClient, String pathname, String filename) {
        boolean flag = false;
        try{
            if(!ftpClient.changeWorkingDirectory(pathname)){
                flag = false;
            }else{
                int reply = ftpClient.dele(filename);
                if(reply == FTPReply.COMMAND_OK){
                    flag = true;
                }else{
                    flag = false;
                }
            }
        }catch(Exception e){
//            logger.error("删除文件失败", e);
        }
        return flag;
    }
}
