package com.infotech.client;

import com.infotech.entity.Employee;
import com.infotech.entity.Address;
import com.infotech.service.EmployeeService;
import com.infotech.service.impl.EmployeeServiceImpl;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class SaveDataClientTest {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Employee employee1= new Employee();
            employee1.setEmployeeName("Barry Bingel");
            employee1.setEmail("barry.cs2017@gmail.com");
            employee1.setSalary(50000.00);
            employee1.setDoj(new Date());

            Employee employee2= new Employee();
            employee2.setEmployeeName("Sean Bingel");
            employee2.setEmail("sean.cs2017@gmail.com");
            employee2.setSalary(70000.00);
            employee2.setDoj(new Date());

            Address address1 = new Address();
            address1.setCity("Chennai");
            address1.setPincode(9087727L);
            address1.setState("Tamilnadu");
            address1.setStreet("Park Street");

            Address address2 = new Address();
            address2.setCity("Pune");
            address2.setPincode(9000027L);
            address2.setState("MH");
            address2.setStreet("XYZ Street");

            Address address3 = new Address();
            address3.setCity("Delhi");
            address3.setPincode(908877027L);
            address3.setState("DL");
            address3.setStreet("PQR Street");

            employee1.getAddressList().add(address1);
            employee1.getAddressList().add(address2);
            employee1.getAddressList().add(address3);

            address1.getEmpList().add(employee1);
            address2.getEmpList().add(employee1);
            address3.getEmpList().add(employee1);

            employee2.getAddressList().add(address2);
            employee2.getAddressList().add(address3);

            address2.getEmpList().add(employee2);
            address3.getEmpList().add(employee2);

            session.persist(employee1);
            session.persist(employee2);

            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }

    }


}
