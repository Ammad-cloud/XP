package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Employee;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import com.mysql.cj.protocol.Resultset;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepo {
    private Connection conn;

    public EmployeeRepo(){
        this.conn = DatabaseConnectionManager.getDBConnection();
    }


    public int add(Employee model) {
        String sql = "INSERT INTO instructor" + "(firstName, lastName, activityId)VALUES" + "(?,?,?);";
        try {
            PreparedStatement addEmployee = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            addEmployee.setString(1, model.getFirstName());
            addEmployee.setString(2, model.getLastName());
            addEmployee.setInt(3, model.getActivityId());

            addEmployee.executeUpdate();

            // Getting auto generated ID
            ResultSet rs = addEmployee.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Employee read(int id) {
        Employee employeeToReturn = new Employee();
        try {
            PreparedStatement getSingleEmployee = conn.prepareStatement("SELECT * FROM instructor WHERE id=" + id);
            ResultSet rs = getSingleEmployee.executeQuery();
            if(rs.next()) {
                employeeToReturn.setId((rs.getInt(1)));
                employeeToReturn.setFirstName(rs.getString(2));
                employeeToReturn.setLastName(rs.getString(3));
                employeeToReturn.setActivityId(rs.getInt(4));
            } else{
                return null;
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
                tempEmployee.setActivityId(rs.getInt(4));
                allEmployees.add(tempEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployees;
    }

    public boolean update(Employee employee) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE instructor SET firstName = ?, lastName = ?, activityId = ? " +
                    "WHERE id =" + employee.getId());
            myStmt.setString(1, employee.getFirstName());
            myStmt.setString(2, employee.getLastName());
            myStmt.setInt(3, employee.getActivityId());

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
