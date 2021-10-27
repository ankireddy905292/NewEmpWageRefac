package com.bridgelabz;
import java.util.Random;
public class EmpWageTotal {
        private static final int FULLDAYHR = 8, PARTTIMEHR = 4;
        private int totalMonthWage = 0;
        static int checkEmp;
        int totalHrCount = 0;

        private int wageHr;
        private int workDaysLimit;
        private int hrLimit;

        public void setVariables(int x, int y, int z){
            this.wageHr = x;
            this.workDaysLimit = y;
            this.hrLimit = z;
        }

        public static void setCheckEmp(){
            Random rdm = new Random();
            int rd = rdm.nextInt(3);
            checkEmp = rd;
        }

        public void  setTotalMonthWage(){
            int day=0;
            while (workDaysLimit>0){
                setCheckEmp();
                switch (checkEmp){
                    case 1:
                        totalMonthWage = totalMonthWage + (wageHr * FULLDAYHR);
                        totalHrCount +=  FULLDAYHR;
                        workDaysLimit--;
                        day++;
                        System.out.println("Day:"+day+"  Wage : "+totalMonthWage+" Working Hrs : "+totalHrCount);
                        break;
                    case 2:
                        totalMonthWage = totalMonthWage + (wageHr * PARTTIMEHR);
                        totalHrCount += PARTTIMEHR;
                        workDaysLimit--;
                        day++;
                        System.out.println("Day:"+day+"  Wage : "+totalMonthWage+" Working Hrs : "+totalHrCount);
                    case 3:
                        workDaysLimit--;
                        day++;
                        System.out.print("Day:"+day+"  Wage : "+totalMonthWage+" Working Hrs : "+totalHrCount);
                        System.out.println("<---Employee was Absent");
                    default:
                        if (totalHrCount == hrLimit)
                            break;

                }

            }
            System.out.println("\nTotal Wage of the Month : "+totalMonthWage);
            System.out.println("Total Hrs of the Employee : "+totalHrCount);

        }
        public String printToData(){
            return  "\nTotal Wage of the Month : "+totalMonthWage+"\nTotal Hrs of the Employee : "+totalHrCount;

        }
    }

    class Emp {

        public static void main(String[] args) {

            EmpWageTotal ibm = new EmpWageTotal();
            System.out.println("Employee Wage for 'IBM': ");
            ibm.setVariables(450, 25, 150);
            ibm.setTotalMonthWage();

            EmpWageTotal tcs = new EmpWageTotal();
            System.out.println("Employee Wage for 'TCS': ");
            tcs.setVariables(380, 23, 150);
            tcs.setTotalMonthWage();

            EmpWageTotal hcl = new EmpWageTotal();
            System.out.println("Employee Wage for 'HCL': ");
            hcl.setVariables(320, 20, 150);
            hcl.setTotalMonthWage();

            //save the Total Wage for Each Company
            System.out.println("\nList Data");
            System.out.println(ibm.printToData());
            System.out.println(tcs.printToData());
            System.out.println(hcl.printToData());

        }
    }

