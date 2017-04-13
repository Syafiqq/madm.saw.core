package app.freelancer.syafiqq.madm.saw.test.case0.profit;

import app.freelancer.syafiqq.madm.saw.core.factory.Profit;
import org.apache.commons.lang3.builder.ToStringBuilder;

/*
 * This <saw> project in package <criterion.case2> created by : 
 * Name         : syafiq
 * Date / Time  : 09 April 2017, 7:10 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class ContinuousProfit extends Profit
{
    private double profit;

    public ContinuousProfit(double profit)
    {
        this.setProfit(profit);
    }

    public double getProfit()
    {
        return this.profit;
    }

    public void setProfit(double profit)
    {
        this.profit = profit;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("profit", profit)
                .toString();
    }
}
