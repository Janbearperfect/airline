package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.FinancialClasses;
import airsystem.entity.FinancialType;

public interface FinancialDao {
	//全部财务
	List<FinancialClasses> listFinancialClass();
    List<FinancialType> listFinancialType();
    double financialTotal();
    List<FinancialClasses> listFinancialClassQuarter();
    List<FinancialType> listFinancialTypeQuarter();
    double financialQuarterTotal();
    List<FinancialClasses> listFinancialClassYear();
    List<FinancialType> listFinancialTypeYear();
    double financialYearTotal();
    //营业点财务
    List<FinancialClasses> listFinancialClass(int branchId);
    List<FinancialType> listFinancialType(int branchId);
    double financialTotal(int branchId);
    List<FinancialClasses> listFinancialClassQuarter(int branchId);
    List<FinancialType> listFinancialTypeQuarter(int branchId);
    double financialQuarterTotal(int branchId);
    List<FinancialClasses> listFinancialClassYear(int branchId);
    List<FinancialType> listFinancialTypeYear(int branchId);
    double financialYearTotal(int branchId);
}
