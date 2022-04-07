package com.infotech.client;

import com.infotech.entity.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class SavingEntityClientTest {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            createEmployee(session);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }
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
        employee.setEmployeeName("choi");
        employee.setEmail("hyeongwoo26@outlook.kr");
        employee.setSalary(10000.00);
        employee.setDoj(new Date());
        return employee;
    }
}
