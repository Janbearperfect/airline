package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.FinancialClasses;
import airsystem.entity.FinancialType;

public interface FinancialDao {
	List<FinancialClasses> listFinancialClass();
    List<FinancialType> listFinancialType();
    double financialTotal();
    List<FinancialClasses> listFinancialClassQuarter();
    List<FinancialType> listFinancialTypeQuarter();
    double financialQuarterTotal();
    List<FinancialClasses> listFinancialClassYear();
    List<FinancialType> listFinancialTypeYear();
    double financialYearTotal();
}