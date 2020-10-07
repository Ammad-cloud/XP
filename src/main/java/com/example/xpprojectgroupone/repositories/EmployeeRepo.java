package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Employee;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepo {
    private Connection conn;

    public EmployeeRepo(){
        this.conn = DatabaseConnectionManager.getDBConnection();
    }


    public boolean add(Employee model) {
        try {
            PreparedStatement addEmployee = conn.prepareStatement("INSERT INTO instructor" + "(firstName, lastName)VALUES" + "(?,?);");
            addEmployee.setString(1, model.getFirstName());
            addEmployee.setString(2, model.getLastName());

            addEmployee.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employee read(int id) {
        Employee employeeToReturn = new Employee();
        try {
            PreparedStatement getSingleEmployee = conn.prepareStatement("SELECT * FROM instructor WHERE id=" + id);
            ResultSet rs = getSingleEmployee.executeQuery();
            while (rs.next()) {
                employeeToReturn.setId((rs.getInt(1)));
                employeeToReturn.setFirstName(rs.getString(2));
                employeeToReturn.setLastName(rs.getString(3));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return employeeToReturn;
    }

    public List<Employee> readAll() {
        List<Employee> allEmployees = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM instructor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee tempEmployee = new Employee();
                tempEmployee.setId(rs.getInt(1));
                tempEmployee.setFirstName(rs.getString(2));
                tempEmployee.setLastName(rs.getString(3));
//                tempEmployee.setActivityId(rs.getInt(4)); Spørg kristian <---------------
                allEmployees.add(tempEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployees;
    }

    public boolean update(Employee employee) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE instructor SET firstName = ?, lastName = ?" +
                    "WHERE id =" + employee.getId());
            myStmt.setString(1, employee.getFirstName());
            myStmt.setString(2, employee.getLastName());

            System.out.println(myStmt);
            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


        public boolean delete(int id) {
            String sql = "DELETE FROM instructor WHERE id = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Fail");
            }


            return false;

        }
}
