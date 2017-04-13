package app.freelancer.syafiqq.madm.saw.test.case0.container;

import app.freelancer.syafiqq.madm.saw.core.factory.ProfitContainer;
import app.freelancer.syafiqq.madm.saw.test.case0.alternative.Investor;
import app.freelancer.syafiqq.madm.saw.test.case0.profit.ContinuousProfit;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <saw> project in package <case2.alternative> created by : 
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 8:20 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class InvestorProfitContainer extends ProfitContainer<Investor>
{
    @NotNull private ContinuousProfit availability;
    @NotNull private ContinuousProfit cost;
    @NotNull private ContinuousProfit investment;
    @NotNull private ContinuousProfit need;
    @NotNull private ContinuousProfit productivity;

    public InvestorProfitContainer(@NotNull ContinuousProfit availability, @NotNull ContinuousProfit cost, @NotNull ContinuousProfit investment, @NotNull ContinuousProfit need, @NotNull ContinuousProfit productivity)
    {
        this.availability = availability;
        this.cost = cost;
        this.investment = investment;
        this.need = need;
        this.productivity = productivity;
    }

    @Override public void searchProfits(@NotNull Investor alternative)
    {
        alternative.getAvailability().searchProfit(this.availability);
        alternative.getCost().searchProfit(this.cost);
        alternative.getInvestment().searchProfit(this.investment);
        alternative.getNeed().searchProfit(this.need);
        alternative.getProductivity().searchProfit(this.productivity);
    }

    @NotNull public ContinuousProfit getAvailability()
    {
        return this.availability;
    }

    public void setAvailability(@NotNull ContinuousProfit availability)
    {
        this.availability = availability;
    }

    @NotNull public ContinuousProfit getCost()
    {
        return this.cost;
    }

    public void setCost(@NotNull ContinuousProfit cost)
    {
        this.cost = cost;
    }

    @NotNull public ContinuousProfit getInvestment()
    {
        return this.investment;
    }

    public void setInvestment(@NotNull ContinuousProfit investment)
    {
        this.investment = investment;
    }

    @NotNull public ContinuousProfit getNeed()
    {
        return this.need;
    }

    public void setNeed(@NotNull ContinuousProfit need)
    {
        this.need = need;
    }

    @NotNull public ContinuousProfit getProductivity()
    {
        return this.productivity;
    }

    public void setProductivity(@NotNull ContinuousProfit productivity)
    {
        this.productivity = productivity;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("availability", availability)
                .append("cost", cost)
                .append("investment", investment)
                .append("need", need)
                .append("productivity", productivity)
                .toString();
    }
}
