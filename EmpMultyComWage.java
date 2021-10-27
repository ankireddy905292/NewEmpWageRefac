package com.bridgelabz;
import java.util.Random;
public class EmpMultyComWage {
    public String company;
    public int wagePerHr;
    public int maxMonthHr;
    public int workingDays;
    public int fullTimeHr;
    public int partTimeHr;

    public EmpMultyComWage(String company, int wagePerHr, int maxMonthHr, int workingDays, int fullTimeHr, int partTimeHr) {
        this.company = company;
        this.wagePerHr = wagePerHr;
        this.maxMonthHr = maxMonthHr;
        this.workingDays = workingDays;
        this.fullTimeHr = fullTimeHr;
        this.partTimeHr = partTimeHr;
    }
}

class EmpWageArry {
    private static final int IS_FULL_TIME = 1;
    private static final int IS_PART_TIME = 2;

    private int numOfCmpny=0;
    private EmpMultyComWage[] compnyWageArray;

    public EmpWageArry(){
        compnyWageArray = new EmpMultyComWage[5];
    }

    public void addCompanyEmpWage(String company, int wagePerHr, int maxMonthHr, int workingDays, int fullTimeHr, int partTimeHr) {
        compnyWageArray[numOfCmpny] = new EmpMultyComWage(company,wagePerHr,maxMonthHr,workingDays,fullTimeHr,partTimeHr);
        computeEmpWage(compnyWageArray[numOfCmpny].company, compnyWageArray[numOfCmpny].wagePerHr
                ,compnyWageArray[numOfCmpny].maxMonthHr ,compnyWageArray[numOfCmpny].workingDays
                ,compnyWageArray[numOfCmpny].fullTimeHr,compnyWageArray[numOfCmpny].partTimeHr);
        numOfCmpny++;
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
        EmpWageArry obj = new EmpWageArry();
        obj.addCompanyEmpWage("TCS", 10, 50, 20, 8, 4);
        obj.addCompanyEmpWage("IBM", 20, 50, 20, 6, 3);
    }
}


