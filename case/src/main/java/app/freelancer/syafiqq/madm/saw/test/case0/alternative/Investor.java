package app.freelancer.syafiqq.madm.saw.test.case0.alternative;

import app.freelancer.syafiqq.madm.saw.core.factory.Alternative;
import app.freelancer.syafiqq.madm.saw.core.factory.ProfitContainer;
import app.freelancer.syafiqq.madm.saw.core.factory.Properties;
import app.freelancer.syafiqq.madm.saw.core.factory.WeightContainer;
import app.freelancer.syafiqq.madm.saw.test.case0.container.InvestorProfitContainer;
import app.freelancer.syafiqq.madm.saw.test.case0.container.InvestorWeightContainer;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Availability;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Cost;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Investment;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Need;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Productivity;
import app.freelancer.syafiqq.madm.saw.test.case0.profit.ContinuousProfit;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <saw> project in package <case2.alternative> created by : 
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 8:11 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Investor extends Alternative
{
    @NotNull private Availability availability;
    @NotNull private Cost         cost;
    @NotNull private Investment   investment;
    @NotNull private Need         need;
    @NotNull private Productivity productivity;
    @NotNull private Properties   properties;
    private          double       total;

    public Investor(@NotNull Properties properties, @NotNull Availability availability, @NotNull Cost cost, @NotNull Investment investment, @NotNull Need need, @NotNull Productivity productivity)
    {
        this.properties = properties;
        this.availability = availability;
        this.cost = cost;
        this.investment = investment;
        this.need = need;
        this.productivity = productivity;
    }

    @Override public void calculateNormalization(@NotNull ProfitContainer alternative)
    {
        @NotNull final InvestorProfitContainer _alternative = (InvestorProfitContainer) alternative;
        this.availability.calculateNormalization(_alternative.getAvailability());
        this.cost.calculateNormalization(_alternative.getCost());
        this.investment.calculateNormalization(_alternative.getInvestment());
        this.need.calculateNormalization(_alternative.getNeed());
        this.productivity.calculateNormalization(_alternative.getProductivity());
    }

    @Override public void calculatePreferences(@NotNull WeightContainer alternative)
    {
        @NotNull final InvestorWeightContainer _alternative = (InvestorWeightContainer) alternative;

        this.availability.calculateWeightedNormalization(_alternative.getAvailability());
        this.cost.calculateWeightedNormalization(_alternative.getCost());
        this.investment.calculateWeightedNormalization(_alternative.getInvestment());
        this.need.calculateWeightedNormalization(_alternative.getNeed());
        this.productivity.calculateWeightedNormalization(_alternative.getProductivity());

        this.total = 0;
        this.total += this.availability.getNormalization();
        this.total += this.cost.getNormalization();
        this.total += this.investment.getNormalization();
        this.total += this.need.getNormalization();
        this.total += this.productivity.getNormalization();
    }

    @Override public ProfitContainer adaptToProfit()
    {
        return new InvestorProfitContainer(
                new ContinuousProfit(this.availability.getValue()),
                new ContinuousProfit(this.cost.getValue()),
                new ContinuousProfit(this.investment.getValue()),
                new ContinuousProfit(this.need.getValue()),
                new ContinuousProfit(this.productivity.getValue())
        );
    }

    @NotNull public Availability getAvailability()
    {
        return this.availability;
    }

    public void setAvailability(@NotNull Availability availability)
    {
        this.availability = availability;
    }

    @NotNull public Cost getCost()
    {
        return this.cost;
    }

    public void setCost(@NotNull Cost cost)
    {
        this.cost = cost;
    }

    @NotNull public Investment getInvestment()
    {
        return this.investment;
    }

    public void setInvestment(@NotNull Investment investment)
    {
        this.investment = investment;
    }

    @NotNull public Need getNeed()
    {
        return this.need;
    }

    public void setNeed(@NotNull Need need)
    {
        this.need = need;
    }

    @NotNull public Productivity getProductivity()
    {
        return this.productivity;
    }

    public void setProductivity(@NotNull Productivity productivity)
    {
        this.productivity = productivity;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    @NotNull public Properties getProperties()
    {
        return properties;
    }

    public void setProperties(@NotNull Properties properties)
    {
        this.properties = properties;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("availability", availability)
                .append("cost", cost)
                .append("investment", investment)
                .append("need", need)
                .append("productivity", productivity)
                .append("total", total)
                .append("properties", properties)
                .toString();
    }


    @Override public int compareTo(@NotNull Alternative o)
    {
        return -Double.compare(this.getTotal(), ((Investor) o).getTotal());
    }
}
