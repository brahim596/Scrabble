package Controller;

import Model.Contact;
import Model.ImageDto;
import Service.Contact_service;
import Service.StorageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.Base64;


@RestController
@CrossOrigin(origins = "http://35.180.0.166:1800")
public class contactController {

    @Autowired
    private Contact_service contact_service;

    @Autowired
    private StorageService storageService;


    private static final String UPLOAD_FOLDER = "./src/main/resources/static/";


    /**
     * Renvoie tous les contacts présent en BDD
     * @return
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/contacts")
    public ResponseEntity<String> test() throws SQLException, JsonProcessingException {

        contact_service=new Contact_service();
        return    contact_service.getAllContacts();

    }

    @RequestMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable int id) throws SQLException {
        Contact contact=contact_service.getContact(id);
        ResponseEntity<Contact> responseEntity =new ResponseEntity<Contact>(contact,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * Ajoute un contact en BDD
     * @param contact
     * @throws SQLException
     */
    @RequestMapping(value = "/addContact", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public void addContact(@RequestBody Contact contact) throws SQLException {
        this.contact_service.addContact(contact);
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public void aupdateContact(@RequestBody Contact contact) throws SQLException {
        this.contact_service.updateContact(contact);
    }


    /**
     * Enregistre une image dans les ressources
     * @param file
     * @param fileName
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/uploadImage")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("fileName") String fileName) throws IOException {

        String uploadedFileLocation = UPLOAD_FOLDER + fileName;
        saveToFile(file.getInputStream(), uploadedFileLocation);
        return null;
    }

    /**
     * Supprime un contact à partir d'un "id"
     * @param id
     * @throws SQLException
     */
    @RequestMapping(value = "/delete")
    public void deleteContact(@RequestParam("id") int id) throws SQLException {
        this.contact_service.deleteContact(id);
    }

    /**
     * Récupère une image provenant des ressources à partir d'un nom de fichier
     * @param fileName
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public ImageDto getImageAsResponseEntity(@RequestParam(value = "fileName") String fileName) throws IOException {
        return storageService.getImage(fileName);
    }




    /********* COPIER COLLER ************/

    /**
     * Utility method to save InputStream data to target location/file
     *
     * @param inStream
     *            - InputStream to be saved
     * @param target
     *            - full path to destination file
     */
    private void saveToFile(InputStream inStream, String target)
            throws IOException {
        OutputStream out = null;
        int read = 0;
        byte[] bytes = new byte[1024];
        out = new FileOutputStream(new File(target));
        while ((read = inStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    }

    /**
     * Creates a folder to desired location if it not already exists
     *
     * @param dirName
     *            - full path to the folder
     * @throws SecurityException
     *             - in case you don't have permission to create the folder
     */
    private void createFolderIfNotExists(String dirName)
            throws SecurityException {
        File theDir = new File(dirName);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
    }
}
