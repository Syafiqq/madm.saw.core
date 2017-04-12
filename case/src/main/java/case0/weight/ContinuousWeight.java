package case0.weight;

import factory.Weight;
import org.apache.commons.lang3.builder.ToStringBuilder;

/*
 * This <saw> project in package <case2.weighted> created by :
 * Name         : syafiq
 * Date / Time  : 09 April 2017, 7:33 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class ContinuousWeight extends Weight
{
    private double weight;

    public ContinuousWeight(double weight)
    {
        this.setWeight(weight);
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("weight", weight)
                .toString();
    }
}
