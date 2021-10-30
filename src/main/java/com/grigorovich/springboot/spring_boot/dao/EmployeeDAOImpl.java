package com.grigorovich.springboot.spring_boot.dao;



import com.grigorovich.springboot.spring_boot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

//должен иметь доступ к sessionFactory
 //тоже самое что и Component
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager; //его бин создавать не надо, создается автоматически

    @Override
    public List<Employee> getAllEmployees() {
        Session session=entityManager.unwrap(Session.class); //получаем сессию из пакета hibernate
        List<Employee> allEmployees=session.createQuery("from Employee", Employee.class).getResultList(); //пишем не название таблицы а название класса entity для таблицы
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee); //если id = 0 то есть мы добавляем нового работника, то в таблицу insert, а если мы изменяем сущ работника то в таблицу insert
    }

    @Override
    public Employee getEmployee(int id) {
        Session session=entityManager.unwrap(Session.class);
        Employee employee=session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session=entityManager.unwrap(Session.class);
        Query<Employee> query=session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
