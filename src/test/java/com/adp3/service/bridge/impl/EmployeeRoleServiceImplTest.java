package com.adp3.service.bridge.impl;

import com.adp3.entity.bridge.EmployeeRole;
import com.adp3.entity.bridge.EmployeeRoleId;
import com.adp3.factory.bridge.EmployeeRoleFactory;
import com.adp3.service.bridge.EmployeeRoleService;
import com.adp3.service.bridge.impl.EmployeeRoleServiceImpl;
import com.adp3.util.GenericHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Sonwabo Kasi
 * Class: Part Time
 * Student number: 214293939
 * Class Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRoleServiceImplTest {
    @Autowired
    private EmployeeRoleServiceImpl employeeRoleService;
    private static final String empId = GenericHelper.generateID();
    EmployeeRole employeeRole;

    @Before
    public void prep(){
        employeeRole = EmployeeRoleFactory.createEmployeeRole(empId,"Managerr");
        employeeRoleService.create(employeeRole);

    }

    @Test
    public void a_create() {
        EmployeeRole created = employeeRoleService.create(employeeRole);
        assertEquals(employeeRole.getEmpID(), created.getEmpID());
        System.out.println(created);

    }

    @Test
    public void b_read() {
        EmployeeRole read = employeeRoleService.read(employeeRole.getEmpID());
        System.out.println(read);
    }

    @Test
    public void c_update() {
        EmployeeRole updated = new EmployeeRole.Builder().copy(employeeRole).setEmployeeId(empId).setRoleId("Manager").build();
        updated = employeeRoleService.update(updated);
        System.out.println(updated);

    }

    @Test
    public void d_getAll() {
        Set<EmployeeRole> employeeRoles = employeeRoleService.getAll();
        Assert.assertEquals(employeeRoles,employeeRoles);
        System.out.println(employeeRoleService.getAll());
    }


    @Test
    public void e_delete() {
        employeeRoleService.delete(employeeRole.getEmpID());
    }

   /* @Test
    public void getAllRolesStartWith() {
    }*/
}
