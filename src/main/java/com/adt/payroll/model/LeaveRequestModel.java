package com.adt.payroll.model;


import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(catalog = "EmployeeDB", schema = "payroll_schema", name = "LeaveRequest")
public class LeaveRequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leaveid", columnDefinition = "serial")
    private Integer leaveid;

    @Column(name = "empid")
    private Integer empid;

    @Column(name = "status")
    private String status;
    
    @Column(name = "updated_by")
    private String updatedBy;
    
    @Column(name="expiry_time")
    private Long expiryTime;
    
    @Column(name="leave_type")
    private String leaveType;
    
    @Column(name="leave_reason")
    private String leaveReason;

    @Column(name="cancel_reason")
    private String cancelReason;
    
	@Transient
    private Integer leaveBalance;
	
	@Transient
    private String name;
	@Transient
    private String email;
	@Transient
	private String message;
	
    @ElementCollection
    @CollectionTable(catalog = "EmployeeDB", schema = "payroll_schema", name = "LEAVE_DATES", joinColumns = @JoinColumn(name = "LEAVE_ID"))
    @Column(name = "leavedate")
    private List<String> leavedate;


}
