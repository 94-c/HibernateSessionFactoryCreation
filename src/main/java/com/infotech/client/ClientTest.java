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

            /*Employee employee = getEmployee3();*/

            session.beginTransaction();

            session.persist(getEmployee1());

            Integer id =(Integer)session.save(getEmployee2());
            System.out.println("Employee is created  with Id::"+id);


            session.saveOrUpdate(getEmployee3());

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static Employee getEmployee3(){
        Employee employee= new Employee();
        employee.setEmployeeName("Martin Bingel");
        employee.setEmail("martin.cs2017@gmail.com");
        employee.setSalary(80000.00);
        employee.setDoj(new Date());
        return employee;
    }

    private static Employee getEmployee1(){
        Employee employee= new Employee();
        employee.setEmployeeName("Frank Bingel");
        employee.setEmail("frank.cs2017@gmail.com");
        employee.setSalary(30000.00);
        employee.setDoj(new Date());
        return employee;
    }

    private static Employee getEmployee2(){
        Employee employee= new Employee();
        employee.setEmployeeName("Sean Bingel");
        employee.setEmail("sean.cs2017@gmail.com");
        employee.setSalary(60000.00);
        employee.setDoj(new Date());
        return employee;
    }
}
