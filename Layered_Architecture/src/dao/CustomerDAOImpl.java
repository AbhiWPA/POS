package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import model.CustomerDTO;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
//        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
//        while (rst.next()){
//            String id = rst.getString(1);
//            String name = rst.getString(2);
//            String address = rst.getString(3);
//            allCustomers.add(new CustomerDTO(id, name, address));
//        }
//        return allCustomers;
        return (ArrayList<CustomerDTO>) SQLUtil.executeQuery("SELECT * FROM Customer");
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
//        pstm.setString(1, dto.getId());
//        pstm.setString(2,dto.getName());
//        pstm.setString(3,dto.getAddress());
//        pstm.executeUpdate();
//        return pstm.executeUpdate() > 0;
        return SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
//        pstm.setString(1, dto.getName());
//        pstm.setString(2, dto.getAddress());
//        pstm.setString(3, dto.getId());
//        return pstm.executeUpdate() > 0;
        return SQLUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?", dto.getName(), dto.getAddress(), dto.getId());
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        return pstm.executeQuery().next();
        return SQLUtil.executeUpdate("SELECT id FROM Customer WHERE id=?",id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        return pstm.executeUpdate() > 0;
        return SQLUtil.executeUpdate("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

//    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
//        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
//        while (rst.next()){
//            String id = rst.getString(1);
//            String name = rst.getString(2);
//            String address = rst.getString(3);
//            allCustomers.add(new CustomerDTO(id, name, address));
//        }
//        return allCustomers;
//    }
//
//    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
//        pstm.setString(1, dto.getId());
//        pstm.setString(2,dto.getName());
//        pstm.setString(3,dto.getAddress());
//        pstm.executeUpdate();
//        return pstm.executeUpdate() > 0;
//    }
//
//    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
//        pstm.setString(1, dto.getName());
//        pstm.setString(2, dto.getAddress());
//        pstm.setString(3, dto.getId());
//        return pstm.executeUpdate() > 0;
//    }
//
//
//    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        return pstm.executeQuery().next();
//    }
//
//
//    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        return pstm.executeUpdate() > 0;
//    }
//
//    public String generateNewID() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("id");
//            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//            return String.format("C00-%03d", newCustomerId);
//        } else {
//            return "C00-001";
//        }
//    }
}
