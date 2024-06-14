package com.model.token.jwttoken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {
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
}
