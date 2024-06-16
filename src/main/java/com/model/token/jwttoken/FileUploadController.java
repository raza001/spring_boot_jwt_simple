package com.model.token.jwttoken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Future;

@RestController
public class FileUploadController {
    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);
    private static String UPLOADED_FOLDER = "/Users/neosoft/personal/fileup";
    @GetMapping("/check")
    public String index() {
        return "upload";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if(file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message","Please select a file");
            return "redirect:/upload";
        }
        try {
           byte[] bytes =file.getBytes();
            Path path= Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
            Files.write(path,bytes);
            System.out.printf(String.valueOf(path));
            redirectAttributes.addFlashAttribute("message","File uploaded successfully");

        } catch
            (Exception e) {
            e.printStackTrace();
        }
//        System.out.printf(file.getOriginalFilename());
         return "redirect:/uploadStatus";
    }
    @DeleteMapping("/delete")
    public String delete() throws IOException {
//        Files.createFile(Paths.get("/Users/neosoft/personal/fileToDelete_jdk7.txt"));
        Path fileToDeletePath = Paths.get("/Users/neosoft/personal/fileToDelete_jdk7.txt");
//        log.atInfo();
        return "Deleted Successfully";
    }
    @GetMapping("/async")
    @Async()
    public Future<String> async() {
        System.out.println("Execute method asynchronously - "
                + Thread.currentThread().getName());
      try {
    Thread.sleep(5000);
//    System.out.printf("HHHH");
 return new AsyncResult<String>("Async executed successfully");
      } catch (InterruptedException e){
          e.printStackTrace();
      }
      return null;
    }
}
