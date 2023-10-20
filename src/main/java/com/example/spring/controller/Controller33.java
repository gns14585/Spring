package com.example.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("main33")
public class Controller33 {


    @GetMapping("sub1")
    public void method1() {

    }

    @PostMapping("sub2")
    public void method2(String name, Integer age, MultipartFile myfile) throws IOException {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        if (myfile != null) {
            String fileName = myfile.getOriginalFilename();
            System.out.println("fileName = " + fileName);

            String path = "c:\\Temp\\upload_" + fileName;
            InputStream inputStream = myfile.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(path);

            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);

            try (bis; bos; inputStream; outputStream;) {
                byte[] data = new byte[1024];
                int len = 0;

                while ((len = bis.read(data)) != -1) {
                    bos.write(data, 0, len);
                }
                bos.flush();
            }
        }
    }

    @GetMapping("sub3")
    public void method3() {

    }

    // /main33/sub4
    @PostMapping("sub4")
    public void method4(MultipartFile upload) throws Exception {
        // 업로드 한 파일을 c:\\Temp\\ 폴더내에 저장하기
        if (upload != null) {
            String fileName = upload.getOriginalFilename();

            String path = "c:\\Temp\\test" + fileName;
            InputStream inputStream = upload.getInputStream();
            OutputStream outputStream = new FileOutputStream(path);

            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);

            try (inputStream; outputStream; bis; bos) {
                byte[] data = new byte[1024];
                int len = 0;
                while ((len = bis.read(data)) != -1) {
                    bos.write(data, 0, len);
                }
                bos.flush();
            }
        }
    }

    @GetMapping("sub5")
    public void method5() {

    }

    @PostMapping("sub6")
    // 여러파일은 배열형식으로 처리
    public void method6(MultipartFile[] files) throws IOException {
//        System.out.println("files.length = " + files.length);
        System.out.println("업로드 파일 크기들.");
        for (MultipartFile file : files) {
//            System.out.println("file.getSize() = " + file.getSize());

            if (file.getSize() > 0) {
                String path = "c:\\Temp\\";
                BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + file.getOriginalFilename()));

                try (bis; bos) {
                    int len = 0;
                    byte[] data = new byte[2048];

                    while ((len = bis.read(data)) != -1) {
                        bos.write(data, 0, len);
                    }
                    bos.flush();
                }
            }
        }
    }
    @GetMapping("sub7")
    public void method7() {

    }
    // 여러 업로드된 파일을
    // c:\\Temp\\upload\\
    // 에 저장
    @PostMapping("sub8")
    public void method8(MultipartFile[] files) throws Exception {
        for (MultipartFile file : files) {
            if (file.getSize() > 0) {
                String path = "c:\\Temp\\upload\\";
                File fileList = new File(path);
                if (!fileList.exists()) {
                    fileList.mkdir();
                }
                BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + file.getOriginalFilename()));
                try(bis; bos) {
                    int len = 0;
                    byte[] data = new byte[2048];

                    while ((len = bis.read(data)) != -1) {
                        bos.write(data, 0, len);
                    }
                    bos.flush();
                }
            }
        }
    }
}


























