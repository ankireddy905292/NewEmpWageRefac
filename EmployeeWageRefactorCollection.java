package com.bridgelabz;
import java.util.Random;

public class EmployeeWageRefactorCollection {
    public String company;
    public int wagePerHr;
    public int maxMonthHr;
    public int workingDays;
    public int fullTimeHr;
    public int partTimeHr;

    public EmployeeWageRefactorCollection(String company, int wagePerHr, int maxMonthHr, int workingDays, int fullTimeHr, int partTimeHr) {
        this.company = company;
        this.wagePerHr = wagePerHr;
        this.maxMonthHr = maxMonthHr;
        this.workingDays = workingDays;
        this.fullTimeHr = fullTimeHr;
        this.partTimeHr = partTimeHr;
    }
}

class EmpWageArray {
    private static final int IS_FULL_TIME = 1;
    private static final int IS_PART_TIME = 2;

    private int numOfCompany=0;
    private EmployeeWageRefactorCollection[] companyWageArray;

    public EmpWageArray(){
        companyWageArray = new EmployeeWageRefactorCollection[5];
    }

    public void addCompanyEmpWage(String company, int wagePerHr, int maxMonthHr, int workingDays, int fullTimeHr, int partTimeHr) {
        companyWageArray[numOfCompany] = new EmployeeWageRefactorCollection(company,wagePerHr,maxMonthHr,workingDays,fullTimeHr,partTimeHr);
        computeEmpWage(companyWageArray[numOfCompany].company, companyWageArray[numOfCompany].wagePerHr
                ,companyWageArray[numOfCompany].maxMonthHr ,companyWageArray[numOfCompany].workingDays
                ,companyWageArray[numOfCompany].fullTimeHr,companyWageArray[numOfCompany].partTimeHr);
        numOfCompany++;
    }

    public static void computeEmpWage(String company, int wagePerHr, int maxMonthHr, int workingDays, int fullTimeHr, int partTimeHr){
        int empHr = 0;
        int totalEmpHr = 0;
        int days = 0;

        while (empHr <= maxMonthHr && days <= workingDays) {

            double empCheck = Math.floor(Math.random() * 10) % 3;
            int empCheck1 = (int) empCheck;

            switch (empCheck1) {
                case IS_FULL_TIME:
                    empHr = fullTimeHr;
                    break;
                case IS_PART_TIME:
                    empHr = partTimeHr;
                    break;
                default:
                    empHr = 0;
            }
            totalEmpHr = totalEmpHr + empHr;
            days++;
        }
        int totalWage = totalEmpHr * wagePerHr;
        System.out.println("Total Wage For " + company + " Company Employee Is " + totalWage);
    }
}
class Emp {
    public static void main(String[] args) {
        EmpWageArray obj = new EmpWageArray();
        obj.addCompanyEmpWage("INFOSIS", 10, 50, 20, 8, 4);
        obj.addCompanyEmpWage("COGNIZANT", 20, 50, 20, 6, 3);
    }
}

