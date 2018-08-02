package Service;

import Controller.SQLiteJDBCDriverConnection;
import Model.Contact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class Contact_service {


    private Connection connection;
    private ResultSet rs;
    private Statement st;
    private PreparedStatement preparedStatement;
    private SQLiteJDBCDriverConnection sqLiteJDBCDriverConnection;

    private ObjectMapper objectMapper;

    public Contact_service() throws SQLException {

        sqLiteJDBCDriverConnection=new SQLiteJDBCDriverConnection();
        connection=sqLiteJDBCDriverConnection.getConnection();
        st=connection.createStatement();
    }

    /**
     * Récupère un contact dans la BDD à partir de l'id
     * @param id
     * @return
     * @throws SQLException
     */
    public Contact getContact(int id) throws SQLException {
        openConnection();

        Contact contact=new Contact();

        rs=st.executeQuery("Select * from contact where hjid="+id);

        while (rs.next()){

            contact.setHjid(rs.getInt("hjid"));
            contact.setCountry(rs.getString("country"));
            contact.setFirst_name("first_name");
            contact.setGender(rs.getInt("gender"));
            contact.setLast_name(rs.getString("last_name"));
            contact.setFirst_name(rs.getString("first_name"));
            contact.setTown(rs.getString("town"));
            contact.setZip(rs.getString("zip"));
            contact.setStreet(rs.getString("street"));
            contact.setMail(rs.getString("mail"));
            contact.setPhone(rs.getString("phone"));
            contact.setPicture_url(rs.getString("picture_url"));
        }

        st.close();
        connection.close();

        return contact;
    }

    /**
     * Ajoute un ocntact à la BDD
     * @param contact
     * @throws SQLException
     */
    public void addContact(Contact contact) throws SQLException {


        int avaible_id=this.getAvaibleId();

        openConnection();

        String sqlRequest="INSERT INTO Contact(first_name,last_name,mail,phone,gender,street,zip,town,country,picture_url,hjid) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        preparedStatement=connection.prepareStatement(sqlRequest);

        preparedStatement.setString(1,contact.getFirst_name());
        preparedStatement.setString(2,contact.getLast_name());
        preparedStatement.setString(3,contact.getMail());
        preparedStatement.setString(4,contact.getPhone());
        preparedStatement.setInt(5,contact.getGender());
        preparedStatement.setString(6,contact.getStreet());
        preparedStatement.setString(7,contact.getZip());
        preparedStatement.setString(8,contact.getTown());
        preparedStatement.setString(9,contact.getCountry());
        preparedStatement.setString(10,contact.getPicture_url());
        preparedStatement.setInt(11,avaible_id);

        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.close();

    }

    /**
     * Récupère tous les contacts dans la BDD
     * @return
     * @throws SQLException
     * @throws JsonProcessingException
     */
    public ResponseEntity<String> getAllContacts() throws SQLException, JsonProcessingException {

        openConnection();

        ArrayList<Contact> contacts=new ArrayList<>();
        rs=st.executeQuery("Select * from contact");

        Contact contact;
        while(rs.next()){

            contact=new Contact();

            contact.setHjid(rs.getInt("hjid"));
            contact.setCountry(rs.getString("country"));
            contact.setFirst_name("first_name");
            contact.setGender(rs.getInt("gender"));
            contact.setLast_name(rs.getString("last_name"));
            contact.setFirst_name(rs.getString("first_name"));
            contact.setTown(rs.getString("town"));
            contact.setZip(rs.getString("zip"));
            contact.setStreet(rs.getString("street"));
            contact.setMail(rs.getString("mail"));
            contact.setPhone(rs.getString("phone"));
            contact.setPicture_url(rs.getString("picture_url"));

            contacts.add(contact);

        }

        objectMapper = new ObjectMapper();

        String responseBody = objectMapper.writeValueAsString(contacts);

        ResponseEntity<String> contactsResponse= new ResponseEntity<String>(responseBody,HttpStatus.OK);

        st.close();
        connection.close();

        return contactsResponse;

    }

    /**
     * Supprime un contact à paritr d'un "id"
     * @param id
     * @throws SQLException
     */
    public void deleteContact(int id) throws SQLException {
        openConnection();
        preparedStatement=connection.prepareStatement("delete from contact where hjid="+id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

    }

    /**
     * Récupère un id non utilisé dans la BDD pour les contacts
     * @return
     * @throws SQLException
     */
    public int getAvaibleId() throws SQLException {
        openConnection();
        int id;
        rs=st.executeQuery("select hjid from contact order by hjid desc");
        id=rs.getInt("hjid");
        System.out.println(id);
        st.close();
        connection.close();

        return  id+1;
    }

    public void updateContact(Contact updatedContact) throws SQLException {
        String sql = "UPDATE contact SET first_name = ? , "
                + "last_name = ? ,"
                + "mail = ? ,"
                + "phone = ? ,"
                + "gender = ? ,"
                + "street = ? ,"
                + "zip = ? ,"
                + "town= ? ,"
                + "country= ? ,"
                + "picture_url = ? "
                + "WHERE hjid = ? ";

        openConnection();

        preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,updatedContact.getFirst_name());
        preparedStatement.setString(2,updatedContact.getLast_name());
        preparedStatement.setString(3,updatedContact.getMail());
        preparedStatement.setString(4,updatedContact.getPhone());
        preparedStatement.setInt(5,updatedContact.getGender());
        preparedStatement.setString(6,updatedContact.getStreet());
        preparedStatement.setString(7,updatedContact.getZip());
        preparedStatement.setString(8,updatedContact.getTown());
        preparedStatement.setString(9,updatedContact.getCountry());
        preparedStatement.setString(10,updatedContact.getPicture_url());
        preparedStatement.setInt(11,updatedContact.getHjid());

        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    /**
     * Ouvre une connexion vers la BDD
     * @throws SQLException
     */
    public void openConnection() throws SQLException {
        connection=this.sqLiteJDBCDriverConnection.openConnection();
        st=connection.createStatement();
    }
}
