package com.infotech.client;

import com.infotech.entity.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;


public class DirtyCheckingClientTest {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Employee employee = session.get(Employee.class, 13);
            if (employee != null){
                session.beginTransaction();
                employee.setSalary(6000.000);
                employee.setEmployeeName("최형우");

                //session.update(employee);

                session.getTransaction().commit();
            }else {
                System.out.println("업데이트 실패");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }
        }
    }


}
