package com.adp3.controller.bridge;

import com.adp3.entity.bridge.EmployeeRole;
import com.adp3.entity.standalone.Employee;
import com.adp3.entity.standalone.Role;
import com.adp3.entity.standalone.Store;
import com.adp3.factory.bridge.EmployeeRoleFactory;
import com.adp3.factory.bridge.EmployeeStoreFactory;
import com.adp3.service.bridge.impl.EmployeeRoleServiceImpl;
import com.adp3.service.standalone.EmployeeService;
import com.adp3.service.standalone.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("employee_time_management/employeeRole")
public class EmployeeRoleController {

    @Autowired
    private EmployeeRoleServiceImpl employeeRoleService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    //@Autowired
    //private RoleServiceImpl roleService;


    @PostMapping("/create")
    public EmployeeRole create(@RequestBody EmployeeRole employeeRole)

    { boolean employeeExist = false;
        boolean roleExist = false;

        Employee employee = employeeService.read(employeeRole.getEmpID());   //calling employee.java
        if (employee != null) {
            employeeExist = true;
        }
      /*  Role role = roleService.read(employeeRole.getRoleID();       //calling store.java
        if (role != null) {
            roleExist = true;
        }*/

        if (employeeExist && roleExist)
            return employeeRoleService.create(employeeRole);
        else return EmployeeRoleFactory.createEmployeeRole("", "");
    }

    @GetMapping("/read/ {empID}")
    public EmployeeRole read(@PathVariable String empID)
    {
        return employeeRoleService.read(empID);
    }

    @PutMapping("/update")
    public EmployeeRole update(EmployeeRole employeeRole)
    {
        employeeRoleService.update(employeeRole);
        return employeeRole;
    }

    @DeleteMapping("/deleting/ {empID}")
    public void delete(@PathVariable String empID)
    {
            employeeRoleService.delete(empID);
    }

    @GetMapping("/getAll")
    public Set<EmployeeRole> getAll()
    {
      return employeeRoleService.getAll();
    }

}
