package com.first.java.hello_project.dao;

import com.first.java.hello_project.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository("customerDao")
@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Customer customer) {
        final String sqlInsert = "INSERT INTO customer (id,name,city,salary,designation) " +
                "VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sqlInsert, new Object[]
                        {customer.getCustomerId(),
                                customer.getName(),
                                customer.getCity(),
                                customer.getSalary(),
                                customer.getDesignation()},
                new int[]{Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.VARCHAR});
    }

    @Override
    public List<Customer> getEmployeesByCity(String city) {
        final String sqlCity = "SELECT * FROM customer WHERE city= ?";
        return jdbcTemplate.query(sqlCity, new Object[]{city},
                (resultSet, i) -> {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String city_name = resultSet.getString("city");
                    double salary = resultSet.getDouble("salary");
                    String designation = resultSet.getString("designation");
                    return new Customer(id, name, city_name, salary, designation);
                });
    }


    @Override
    public List<Customer> getEmployeesBySal(double salary) {
        final String sqlCity = "SELECT * FROM customer WHERE salary>= ?";
        return jdbcTemplate.query(sqlCity, new Object[]{salary},
                (resultSet, i) -> {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String city = resultSet.getString("city");
                    double salary_greater = resultSet.getDouble("salary");
                    String designation = resultSet.getString("designation");
                    return new Customer(id, name, city, salary_greater, designation);
                });
    }

    @Override
    public List<Customer> getEmployeesByDesignation(String designation) {
        final String sqlCity = "SELECT * FROM customer WHERE designation= ?";
        return jdbcTemplate.query(sqlCity, new Object[]{designation},
                (resultSet, i) -> {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String city = resultSet.getString("city");
                    double salary = resultSet.getDouble("salary");
                    String designation_name = resultSet.getString("designation");
                    return new Customer(id, name, city, salary, designation_name);
                });
    }

    @Override
    public List<Customer> getSortedEmployees() {
        final String sqlCity = "SELECT * FROM customer ORDER BY designation";
        return jdbcTemplate.query(sqlCity, new Object[]{},
                (resultSet, i) -> {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String city = resultSet.getString("city");
                    double salary = resultSet.getDouble("salary");
                    String designation = resultSet.getString("designation");
                    return new Customer(id, name, city, salary, designation);
                });
    }

    @Override
    public int update(Customer customer, int id) {
        final String sqlUpdate = "Update customer set name=?, city=?, salary=?, designation=? where id=?";
        return jdbcTemplate.update(
                sqlUpdate,
                new Object[]{customer.getName(), customer.getCity(), customer.getSalary(), customer.getDesignation(), id},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.VARCHAR, Types.INTEGER});
    }

    @Override
    public int delete(int id) {
        final String sqlDelete = "Delete FROM customer Where id=?";
        return jdbcTemplate.update(sqlDelete, new Object[]{id}, new int[]{Types.INTEGER});
    }

    @Override
    public String getCity(int id, String name) {
        final String sqlGetCity = "SELECT city FROM customer Where id=? AND name=?";
        return jdbcTemplate.queryForObject(sqlGetCity, new Object[]{id, name}, new int[]{Types.INTEGER, Types.VARCHAR},
                (resultSet, i) -> resultSet.getString("city")
        );
    }
}
