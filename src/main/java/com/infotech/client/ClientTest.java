package com.infotech.client;

import com.infotech.entity.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            /*String SQL = "SELECT VERSION()";
            String result = (String) session.createNativeQuery(SQL).getSingleResult();
            System.out.println("MY SQL version is :: ");
            System.out.println(result);*/
            Employee employee = getEmployee();

            session.beginTransaction();

            session.persist(employee);

            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Employee getEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeName("HyeongWoo Choi");
        employee.setEmail("hyeongwoo26@naver.com");
        employee.setSalary(8000.00);
        employee.setDoj(new Date());
        return employee;
    }
}
