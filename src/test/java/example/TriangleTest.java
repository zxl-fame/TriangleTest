package example;

import org.example.Triangle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    /**
     * @param a        第一条边
     * @param b        第二条边
     * @param c        第三条边
     * @param expected 预取结果
     *                 3条边长的输入变量，设计测试用例使得一个变量在数据有效区域内取最大值、略小于最大值、正常值、略大于最小值和最小值
     *                 对于有n个输入变量的程序，一般性边界值分析的测试用例个数为4n+1 (3 * n + 1 = 13)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/test1.csv")
    void testWithCsvSource1(int a, int b, int c, String expected) {
        Triangle triangle = new Triangle();
        assertEquals(expected, triangle.classify(a, b, c));
    }

    /**
     * @param a        第一条边
     * @param b        第二条边
     * @param c        第三条边
     * @param expected 预取结果
     *                 除了变量的5 个边界分析取值还要考虑略超过最大值（max）和略小于最小值（min）时的情况
     *                 对于有n个输入变量的程序，健壮性测试的测试用例个数为6n+1 (6 * n + 1 = 19)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/test2.csv")
    void testWithCsvSource2(int a, int b, int c, String expected) {
        Triangle triangle = new Triangle();
        assertEquals(expected, triangle.classify(a, b, c));
    }

    /**
     * @param a        第一条边
     * @param b        第二条边
     * @param c        第三条边
     * @param expected 预取结果
     *                 最坏情况测试中，对每一个输入变量首先进行包含最小值、略高于最小值、正常值、略低于最大值、最大值等5个元素集合的测试，
     *                 然后对这些集合进行笛卡尔积计算，以生成测试用例
     *                 对于有n个输入变量的程序，最坏情况测试的测试用例个数为5^n (5 ^ 3 = 125)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/test3.csv")
    void testWithCsvSource3(int a, int b, int c, String expected) {
        Triangle triangle = new Triangle();
        assertEquals(expected, triangle.classify(a, b, c));
    }

    /**
     * @param a        第一条边
     * @param b        第二条边
     * @param c        第三条边
     * @param expected 预取结果
     *                 健壮性最坏情况假设对每一个变量首先进行最小值、略小于最小值的值、略高于最小值的值、正常值、最大值、
     *                 略高于最大值的值、略低于最大值的值等7个元素的集合。
     *                 然后对这些集合进行笛卡尔积运算，以生成测试用例
     *                 对于有n个输入变量的程序，健壮最坏情况测试的测试用例个数为7^n (7 ^ 3 = 343)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/test4.csv")
    void testWithCsvSource4(int a, int b, int c, String expected) {
        Triangle triangle = new Triangle();
        assertEquals(expected, triangle.classify(a, b, c));
    }
}
