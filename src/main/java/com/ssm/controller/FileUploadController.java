package com.ssm.controller;

import com.ssm.entity.TabFile;
import com.ssm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("filename1") MultipartFile file, HttpServletRequest request) {
        String filePath = request.getSession().getServletContext().getRealPath("/fileUpload");
        System.out.println(filePath);
        String newFileName = (new Date()).getTime() + Math.ceil(Math.random() * 100) + file.getOriginalFilename();
        String path = filePath + File.separator + newFileName;
        File newFile = new File(path);
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fileUpload";
    }

    @RequestMapping("/fileUploadMore")
    public String fileUploadMore(@RequestParam("filename1") List<MultipartFile> files, HttpServletRequest request) {
        for (MultipartFile file : files) {
            String filePath = request.getSession().getServletContext().getRealPath("/fileUpload");
            System.out.println(filePath);
            String oldFileName = file.getOriginalFilename();
            //重新命名，保证唯一
            String newFileName = (new Date()).getTime() + Math.ceil(Math.random() * 100) + file.getOriginalFilename();
            //拷贝到的文件路径——separator会自动识别操作系统
            File fileDate = new File(filePath + File.separator + "2020-04-14");
            if (!fileDate.exists()) {
                fileDate.mkdir();
            }
            String path = filePath + File.separator + "2020-04-14" + File.separator + newFileName;
            File newFile = new File(path);
            try {
                file.transferTo(newFile);//这一步完成文件拷贝
                TabFile tabFile = new TabFile();
                tabFile.setFilename(oldFileName);
                tabFile.setFileurl("2020-04-14" + File.separator + newFileName);
                fileService.insertFile(tabFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "fileList";
    }

    @GetMapping("/selectFile")
    @ResponseBody
    public List selectFile() {
        return fileService.selectFile();
    }

    @RequestMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response,
                           Integer fileid) {
        TabFile tabFile = fileService.selectFileById(fileid);
        InputStream is = null;
        OutputStream writer = null;
        try {
            response.reset();
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(tabFile.getFilename().getBytes(), "utf-8"));

            String filePath = request.getSession().getServletContext().getRealPath("/fileUpload");
            String path = filePath + File.separator + tabFile.getFileurl();

            is = new FileInputStream(path);
            writer = response.getOutputStream();
            int length = -1;
            byte[] bytes = new byte[1024];
            while ((length = is.read(bytes)) > 0) {
                writer.write(bytes, 0, length);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

}
