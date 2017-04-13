package app.freelancer.syafiqq.madm.saw.test.case0.container;

import app.freelancer.syafiqq.madm.saw.core.factory.WeightContainer;
import app.freelancer.syafiqq.madm.saw.test.case0.weight.ContinuousWeight;
import org.jetbrains.annotations.NotNull;

/*
 * This <saw> project in package <case2.alternative> created by : 
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 8:48 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class InvestorWeightContainer extends WeightContainer
{
    @NotNull private ContinuousWeight availability;
    @NotNull private ContinuousWeight cost;
    @NotNull private ContinuousWeight investment;
    @NotNull private ContinuousWeight need;
    @NotNull private ContinuousWeight productivity;

    public InvestorWeightContainer(@NotNull ContinuousWeight availability, @NotNull ContinuousWeight cost, @NotNull ContinuousWeight investment, @NotNull ContinuousWeight need, @NotNull ContinuousWeight productivity)
    {
        this.availability = availability;
        this.cost = cost;
        this.investment = investment;
        this.need = need;
        this.productivity = productivity;
    }

    @NotNull public ContinuousWeight getAvailability()
    {
        return this.availability;
    }

    public void setAvailability(@NotNull ContinuousWeight availability)
    {
        this.availability = availability;
    }

    @NotNull public ContinuousWeight getCost()
    {
        return this.cost;
    }

    public void setCost(@NotNull ContinuousWeight cost)
    {
        this.cost = cost;
    }

    @NotNull public ContinuousWeight getInvestment()
    {
        return this.investment;
    }

    public void setInvestment(@NotNull ContinuousWeight investment)
    {
        this.investment = investment;
    }

    @NotNull public ContinuousWeight getNeed()
    {
        return this.need;
    }

    public void setNeed(@NotNull ContinuousWeight need)
    {
        this.need = need;
    }

    @NotNull public ContinuousWeight getProductivity()
    {
        return this.productivity;
    }

    public void setProductivity(@NotNull ContinuousWeight productivity)
    {
        this.productivity = productivity;
    }

    @Override public String toString()
    {
        return "InvestorWeightContainer{" +
                "availability=" + availability +
                ", cost=" + cost +
                ", investment=" + investment +
                ", need=" + need +
                ", productivity=" + productivity +
                '}';
    }
}
