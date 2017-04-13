package app.freelancer.syafiqq.madm.saw.test.case0.criterion;

import app.freelancer.syafiqq.madm.saw.core.factory.Criterion;
import app.freelancer.syafiqq.madm.saw.test.case0.profit.ContinuousProfit;
import app.freelancer.syafiqq.madm.saw.test.case0.type.CriterionType;
import app.freelancer.syafiqq.madm.saw.test.case0.weight.ContinuousWeight;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.math3.util.FastMath;
import org.jetbrains.annotations.NotNull;

/*
 * This <saw> project in package <case2.criterion> created by : 
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 7:15 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Productivity extends Criterion<ContinuousProfit, ContinuousWeight>
{
    public static final CriterionType TYPE = CriterionType.BENEFIT;

    private int    value;
    private double normalization;

    public Productivity(int value)
    {
        this.setValue(value);
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public double getNormalization()
    {
        return normalization;
    }

    public void setNormalization(double normalization)
    {
        this.normalization = normalization;
    }

    @Override public void searchProfit(@NotNull ContinuousProfit criterion)
    {
        switch(Productivity.TYPE)
        {
            case BENEFIT:
            {
                criterion.setProfit(FastMath.max(criterion.getProfit(), this.getValue()));
            }
            break;
            case COST:
            {
                criterion.setProfit(FastMath.min(criterion.getProfit(), this.getValue()));
            }
            break;
        }
    }

    @Override public void calculateNormalization(@NotNull ContinuousProfit criterion)
    {
        switch(Productivity.TYPE)
        {
            case BENEFIT:
            {
                this.setNormalization(this.value / criterion.getProfit());
            }
            break;
            case COST:
            {
                this.setNormalization(criterion.getProfit() / this.value);
            }
            break;
        }
    }

    @Override public void calculateWeightedNormalization(@NotNull ContinuousWeight criterion)
    {
        this.setNormalization(this.getNormalization() * criterion.getWeight());
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("value", value)
                .append("normalization", normalization)
                .toString();
    }
}
