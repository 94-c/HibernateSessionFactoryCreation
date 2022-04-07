package com.infotech.dao.impl;

import com.infotech.dao.EmployeeDAO;
import com.infotech.entity.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            System.out.println("addEmployee is Created with Id :: " + id);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public Employee fetchEmployeeById(int employeeId) {
        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                return employee;
            }else {
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployeeById(int employeeId, Double newSal) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            Employee employee = session.get(Employee.class, employeeId);
            if(employee != null){
                employee.setSalary(newSal);
                session.beginTransaction();
                session.update(employee);
                session.getTransaction().commit();
            }else{
                System.out.println("Employee doesn't exist with provideded Id..");
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Employee employee = session.get(Employee.class, employeeId);
            if(employee != null){
                session.beginTransaction();

                session.delete(employee);
                session.getTransaction().commit();
            }else{
                System.out.println("Employee doesn't exist with provideded Id..");
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
}
