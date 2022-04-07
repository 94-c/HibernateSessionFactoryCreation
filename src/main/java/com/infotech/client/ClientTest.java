package com.infotech.client;

import com.infotech.entity.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            /*String SQL = "SELECT VERSION()";
            String result = (String) session.createNativeQuery(SQL).getSingleResult();
            System.out.println("MY SQL version is :: ");
            System.out.println(result);*/

            deleteEmployeeById(session);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static void deleteEmployeeById(Session session) {
        Employee employee = session.get(Employee.class, 12);
        if(employee != null){
            session.beginTransaction();

            session.delete(employee);
            session.getTransaction().commit();
        }else{
            System.out.println("Employee doesn't exist with provideded Id..");
        }
    }

    private static void updateEmployeeById(Session session) {
        Employee employee = session.get(Employee.class, 12);
        if(employee != null){
            employee.setSalary(40000.00);
            session.beginTransaction();

            session.update(employee);
            session.getTransaction().commit();
        }else{
            System.out.println("Employee doesn't exist with provideded Id..");
        }
    }

    private static void getEmployeeById(Session session) {
        Employee employee = session.get(Employee.class, 12);
        if (employee != null) {
            System.out.println(employee);
        }else {
            System.out.println("Employee doesn't exist with provideded Id.. ");
        }
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Integer id =(Integer) session.save(getEmployee());
        System.out.println("Employee is created  with Id::"+id);
        session.getTransaction().commit();
    }

    private static Employee getEmployee(){
        Employee employee= new Employee();
        employee.setEmployeeName("hyeongwoo");
        employee.setEmail("hyeongwoo26@outlook.kr");
        employee.setSalary(80000.00);
        employee.setDoj(new Date());
        return employee;
    }

}
