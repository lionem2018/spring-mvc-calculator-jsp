package tr.com.etstur.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tr.com.etstur.ApplicationConfiguration;
import tr.com.etstur.common.Operator;

import static org.junit.Assert.*;

import java.math.BigDecimal;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class CalculatorServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorServiceTest.class);

    @Autowired
    ICalculatorService calculatorService;

    @Test
    public void test_add_calculate() {

        Operator operator = Operator.ADD;

        BigDecimal first = new BigDecimal("1.02");
        BigDecimal second = new BigDecimal("2.03");

        double result = calculatorService.calculate(first, second, operator);
        assertTrue("should be same", result == 3.05);
    }

    @Test
    public void test_substract_calculate() {

        Operator operator = Operator.SUBSTRACT;

        BigDecimal first = new BigDecimal("4.02");
        BigDecimal second = new BigDecimal("2.03");

        double result = calculatorService.calculate(first, second, operator);
        assertTrue("should be same", result == 1.99);
    }

    @Test
    public void test_divide_calculate() {

        Operator operator = Operator.DIVIDE;

        BigDecimal first = new BigDecimal("4.04");
        BigDecimal second = new BigDecimal("2.02");

        double result = calculatorService.calculate(first, second, operator);
        assertTrue("should be same", result == 2);
    }

    @Test
    public void test_multiply_calculate() {

        Operator operator = Operator.MULTIPLY;

        BigDecimal first = new BigDecimal("4.04");
        BigDecimal second = new BigDecimal("3.0");

        double result = calculatorService.calculate(first, second, operator);
        assertTrue("should be same", result == 12.12);
    }

}