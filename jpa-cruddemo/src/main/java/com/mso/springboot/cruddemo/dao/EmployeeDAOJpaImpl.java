package com.mso.springboot.cruddemo.dao;

import com.mso.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query theQuery = entityManager.createQuery("from Employee ");

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        Employee dbemployee = entityManager.merge(theEmployee);

        // update with id from db ... so we can get generated id for save/insert
        theEmployee.setId(dbemployee.getId());
    }

    @Override
    public void deleteById(int theId) {

        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");

        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();

    }
}
