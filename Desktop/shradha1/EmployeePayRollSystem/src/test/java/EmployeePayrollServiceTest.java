import exception.EmployeePayrollException;
import model.EmployeePayrollData;
import service.EmployeePayrollService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollServiceTest {
    EmployeePayrollService employeePayrollService = null;

    @Before
    public void setUp() throws Exception {
        employeePayrollService = new EmployeePayrollService();
    }

    /**
     * Purpose : To test whether the number of records present in the database matches with the expected value
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() throws EmployeePayrollException {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(4, employeePayrollData.size());
    }

    /**
     * Purpose : To test whether the salary is updated in the database and is synced with the DB
     *           - Read the values from the database
     *           - Update the salary in the database
     *           - Test whether the database is correctly synced or not
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDB() throws EmployeePayrollException {
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalary("Terissa", 3000000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terissa");
        Assert.assertTrue(result);
    }

    /**
     * Purpose : To test whether the salary is updated in the database and is synced with the DB using JDBC PreparedStatement
     *           - Read the values from the database
     *           - Update the salary in the database
     *           - Test whether the database is correctly synced or not
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDBUsingPreparedStatement() throws EmployeePayrollException {
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalaryUsingPreparedStatement("Terissa", 5000000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terissa");
        Assert.assertTrue(result);
    }

    /**
     * Purpose : To test whether the count of the retrieved data who have joined in a particular data range matches with the expected value
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenDateRange_WhenRetrieved_ShouldMatchTheEmployeeCount() throws EmployeePayrollException {
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        LocalDate startDate = LocalDate.of(2018, 01, 01);
        LocalDate endDate = LocalDate.now();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollForDateRange(EmployeePayrollService.IOService.DB_IO, startDate, endDate);
        Assert.assertEquals(4, employeePayrollData.size());
    }

    /**
     * Purpose : To match the expected total salary with the actual total salary
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenEmployeePayrollSalaryInDB_WhenRetrieved_ShouldMatchTheTotalSum() throws EmployeePayrollException {
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        String gender = "M";
        double sum = employeePayrollService.readEmployeePayrollToCalculateSum(EmployeePayrollService.IOService.DB_IO, gender);
        Assert.assertEquals( 300000, sum, 0.0);
    }

    /**
     * Purpose : To match the expected average salary with the actual average salary
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenEmployeePayrollSalaryInDB_WhenRetrieved_ShouldMatchTheAverageSum() throws EmployeePayrollException {
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        String gender = "M";
        double avg_sum = employeePayrollService.readEmployeePayrollToCalculateAvg(EmployeePayrollService.IOService.DB_IO, gender);
        Assert.assertEquals( 150000, avg_sum, 0.0);
    }

    /**
     * Purpose : To match the expected minimum salary with the actual minimum salary
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenEmployeePayrollSalaryInDB_WhenRetrieved_ShouldMatchTheMinSalary() throws EmployeePayrollException {
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        String gender = "M";
        double min_salary = employeePayrollService.readEmployeePayrollToCalculateMin(EmployeePayrollService.IOService.DB_IO, gender);
        Assert.assertEquals( 100000, min_salary, 0.0);
    }

    /**
     * Purpose : To match the expected maximum salary with the actual maximum salary
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenEmployeePayrollSalaryInDB_WhenRetrieved_ShouldMatchTheMaxSalary() throws EmployeePayrollException {
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        String gender = "M";
        double min_salary = employeePayrollService.readEmployeePayrollToCalculateMax(EmployeePayrollService.IOService.DB_IO, gender);
        Assert.assertEquals( 200000, min_salary, 0.0);
    }

    /**
     * Purpose : To get the total count of employees based on gender
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchTheCountOfMaleAndFemaleEmployee() throws EmployeePayrollException {
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        int count = employeePayrollService.readEmployeePayrollToCalculateCount(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals( 4, count);
    }

    /**
     * Purpose : To get the total count of employees based on particular gender
     *
     * @throws EmployeePayrollException
     */

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchTheCountOfParticularMaleAndFemaleEmployee() throws EmployeePayrollException {
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        String gender = "M";
        double count = employeePayrollService.readEmployeePayrollToCalculateCountOfGender(EmployeePayrollService.IOService.DB_IO, gender);
        Assert.assertEquals( 2, count, 0.0);
    }
}
