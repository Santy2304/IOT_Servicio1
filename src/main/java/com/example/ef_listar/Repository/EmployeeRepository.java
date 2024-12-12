package com.example.ef_listar.Repository;

import com.example.ef_listar.DTO.EmployeeDTO;
import com.example.ef_listar.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findAllByOrderByFirstNameDesc();
    List<Employee> findAllByOrderByLastNameDesc();
    List<Employee> findAllByOrderByEmailDesc();

    @Query(nativeQuery = true, value = "SELECT  \n" +
            "e.employee_id AS id,\n" +
            "e.first_name AS firstName,\n" +
            "e.last_name AS lastName,\n" +
            "e.email AS email,\n" +
            "e.phone_number AS phoneNumber\n" +
            "FROM \n" +
            "employees e \n" +
            "ORDER BY \n" +
            "e.first_name DESC;")
    List<EmployeeDTO> obtenerEmployeeFirstName();

    @Query(nativeQuery = true, value = "SELECT  \n" +
            "e.employee_id AS id,\n" +
            "e.first_name AS firstName,\n" +
            "e.last_name AS lastName,\n" +
            "e.email AS email,\n" +
            "e.phone_number AS phoneNumber\n" +
            "FROM \n" +
            "employees e \n" +
            "ORDER BY \n" +
            "e.last_name DESC;")
    List<EmployeeDTO> obtenerEmployeeLastName();

    @Query(nativeQuery = true, value = "SELECT  \n" +
            "e.employee_id AS id,\n" +
            "e.first_name AS firstName,\n" +
            "e.last_name AS lastName,\n" +
            "e.email AS email,\n" +
            "e.phone_number AS phoneNumber\n" +
            "FROM \n" +
            "employees e \n" +
            "ORDER BY \n" +
            "e.email DESC;")
    List<EmployeeDTO> obtenerEmployeeEmail();

}