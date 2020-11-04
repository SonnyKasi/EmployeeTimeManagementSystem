package com.adp3.service.bridge.impl;

import com.adp3.entity.bridge.EmployeeStore;
import com.adp3.factory.bridge.EmployeeStoreFactory;
import com.adp3.service.bridge.EmployeeStoreService;
import com.adp3.util.GenericHelper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/*
 * Author: Munyaradzi Manyati
 * Class: Part Time
 * Student number: 215211855
 * Class Description: EmployeeStoreServiceImplTest.
 */


@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeStoreServiceImplTest {
@Autowired
    private EmployeeStoreService employeeStoreService;
    private static String empID = GenericHelper.generateID();
    EmployeeStore employeeStore;

    public void a_a(){
        employeeStore = EmployeeStoreFactory.createEmployeeStore(empID, "Bebe");
        employeeStoreService.create(employeeStore);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get All : " + employeeStoreService.getAll());
    }

    @Test
    public void a_create() {

        EmployeeStore created = employeeStoreService.create(employeeStore);
        assertEquals(employeeStore.getEmpID(), created.getEmpID());
        System.out.println("Created : " + created);
    }


    @Test
    public void b_read() {
        EmployeeStore read = employeeStoreService.read(employeeStore.getEmpID());
        System.out.println("Read : " + read);
    }

    @Test
    public void c_update() {
        EmployeeStore updated = new EmployeeStore.Builder().copy(employeeStore).setStoreID("Munya1").build();
        updated = employeeStoreService.update(updated);
        System.out.println("ID Updated : " + updated);
    }

    @Test
    public void e_delete() {
        employeeStoreService.delete(employeeStore.getEmpID());
        System.out.println("Deleted : " + employeeStoreService.getAll());
    }

}