package com.infotech.client;

import com.infotech.entity.Employee;
import com.infotech.model.Address;
import com.infotech.service.EmployeeService;
import com.infotech.service.impl.EmployeeServiceImpl;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {

            EmployeeService employeeService = new EmployeeServiceImpl();
            createEmployee(employeeService);
            //getEmployeeById(employeeService);
            //updateEmployeeById(employeeService);
            //deleteEmployeeById(employeeService);

    }

    private static void deleteEmployeeById(EmployeeService employeeService) {
        employeeService.deleteEmployeeById(13);
    }
    private static void updateEmployeeById(EmployeeService employeeService) {
        employeeService.updateEmployeeById(14, 60000.00);

    }

    private static void getEmployeeById(EmployeeService employeeService) {
        Employee employee = employeeService.getEmployeeById(14);
        System.out.println("아이디 조회 : " + employee);
    }

    private static void createEmployee(EmployeeService employeeService) {
        employeeService.createEmployee(getEmployee());
    }

    private static Employee getEmployee(){
        Employee employee= new Employee();
        employee.setEmployeeName("최형우");
        employee.setEmail("hyeongwoo26@1231412.kr");
        employee.setSalary(80000.00);
        employee.setDoj(new Date());

        Address address = new Address();
        address.setCity("인천");
        address.setPincode(1234567L);
        address.setState("남동구");
        address.setStreet("만수동");
        employee.setAddress(address);
        return employee;
    }

}
