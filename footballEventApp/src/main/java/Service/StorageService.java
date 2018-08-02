package Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import Model.ImageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

    private static final String UPLOAD_FOLDER = "./src/main/resources/static/";

   public ImageDto getImage(String fileName) throws IOException {

       File file = new File(UPLOAD_FOLDER + fileName);
       String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(file.toPath()));
        String extension = "";

       int i = fileName.lastIndexOf('.');
       if (i > 0) {
           extension = fileName.substring(i+1);
       }

       ImageDto imageDto=new ImageDto();
       imageDto.setContent(encodeImage);
       imageDto.setExtension(extension);

       return imageDto;

   }
}