package Model;

import lombok.*;

import java.io.File;
import java.io.InputStream;

@Data
public class Contact {

    private int hjid;

    private String first_name;

    private String last_name;

    private String mail;

    private String phone;

    private int gender;

    private String street;

    private String zip;

    private String town;

    private String country;

    private String picture_url;

    private File file_picture;

}
