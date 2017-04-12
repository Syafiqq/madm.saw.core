package factory;

import factory.interfaces.AlternativeComparator;

/*
 * This <saw> project in package <factory> created by : 
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 8:25 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Alternative implements AlternativeComparator<Alternative>
{
    public abstract void calculateNormalization(ProfitContainer alternative);

    public abstract void calculatePreferences(WeightContainer alternative);

    public abstract ProfitContainer copyToProfit();
}
