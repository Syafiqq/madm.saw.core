package app.freelancer.syafiqq.madm.saw.test.case0.criterion;

import app.freelancer.syafiqq.madm.saw.core.factory.Criterion;
import app.freelancer.syafiqq.madm.saw.core.factory.Profit;
import app.freelancer.syafiqq.madm.saw.core.factory.Weight;
import app.freelancer.syafiqq.madm.saw.test.case0.profit.ContinuousProfit;
import app.freelancer.syafiqq.madm.saw.test.case0.type.CriterionType;
import app.freelancer.syafiqq.madm.saw.test.case0.weight.ContinuousWeight;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.math3.util.FastMath;
import org.jetbrains.annotations.NotNull;

/*
 * This <saw> project in package <case2.criterion> created by : 
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 7:20 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Need extends Criterion
{
    public static final CriterionType TYPE = CriterionType.COST;

    private int    value;
    private double normalization;

    public Need(int value)
    {
        this.setValue(value);
    }

    @Override public void searchProfit(@NotNull Profit criterion)
    {
        @NotNull final ContinuousProfit _criterion = (ContinuousProfit) criterion;
        switch(Need.TYPE)
        {
            case BENEFIT:
            {
                _criterion.setProfit(FastMath.max(_criterion.getProfit(), this.getValue()));
            }
            break;
            case COST:
            {
                _criterion.setProfit(FastMath.min(_criterion.getProfit(), this.getValue()));
            }
            break;
        }
    }

    @Override public void calculateNormalization(@NotNull Profit criterion)
    {
        @NotNull final ContinuousProfit _criterion = (ContinuousProfit) criterion;
        switch(Need.TYPE)
        {
            case BENEFIT:
            {
                this.setNormalization(this.value / _criterion.getProfit());
            }
            break;
            case COST:
            {
                this.setNormalization(_criterion.getProfit() / this.value);
            }
            break;
        }
    }

    @Override public void calculateWeightedNormalization(@NotNull Weight criterion)
    {
        this.setNormalization(this.getNormalization() * ((ContinuousWeight) criterion).getWeight());
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

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("value", value)
                .append("normalization", normalization)
                .toString();
    }
}
