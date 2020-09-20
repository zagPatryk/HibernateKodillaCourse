package com.kodilla.hibernate.manytomany.facede;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompaniesByNameLike(String name) {
        return companyDao.retrieveCompaniesByNameLike(name);
    }

    public List<Employee> findEmployeeByByNameLike(String name) {
        return employeeDao.retrieveEmployeeByNameLike(name);
    }
}
