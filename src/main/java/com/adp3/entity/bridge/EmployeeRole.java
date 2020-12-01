package com.adp3.entity.bridge;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Author: Sonwabo Kasi
 * Class: Part Time
 * Student number: 214293939
 * Class Description: EmployeeRole
 */
@Entity
//@IdClass(EmployeeRoleId.class)
public class EmployeeRole {
    @Id
    private String empID;
   // @Id
    private String roleID;

    protected EmployeeRole(){

    }

    private EmployeeRole(Builder builder) {
        this.empID = builder.empID;
        this.roleID = builder.roleID;
    }

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "empID='" + empID + '\'' +
                ", roleID='" + roleID + '\'' +
                '}';
    }

    public String getEmpID() {
        return empID;
    }

    public String getRoleID() {
        return roleID;
    }

    public static class Builder {
        private String empID, roleID;

        public Builder setEmployeeId(String empId) {
            this.empID = empId;
            return this;
        }

        public Builder setRoleId(String roleID) {
            this.roleID = roleID;
            return this;
        }

        public Builder copy(EmployeeRole employeeR) {
            this.empID = employeeR.empID;
            this.roleID = employeeR.roleID;
            return this;
        }

        public EmployeeRole build() {
            return new EmployeeRole(this);
        }

    }

}
