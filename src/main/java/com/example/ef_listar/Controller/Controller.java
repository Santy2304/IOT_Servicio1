package com.example.ef_listar.Controller;

import com.example.ef_listar.DTO.EmployeeDTO;
import com.example.ef_listar.Entity.Employee;
import com.example.ef_listar.Repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Controller
@RestController
@RequestMapping("/rh/empleado")

public class Controller {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/orderby/{order}")
    public List<EmployeeDTO>  listar(@PathVariable String order) throws JsonProcessingException {
        List<EmployeeDTO> empleados;
        switch (order.toLowerCase()) {
            case "firstname":
                empleados = employeeRepository.obtenerEmployeeFirstName();
                break;
            case "lastname":
                empleados = employeeRepository.obtenerEmployeeLastName();
                break;
            case "email":
                empleados = employeeRepository.obtenerEmployeeEmail();
                break;
            default:
                return null;        }
        return empleados;
    }

    @GetMapping("/listarTodo")
    public List<Employee> listarTodo() {
        return employeeRepository.findAll();
    }

}
