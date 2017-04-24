package app.freelancer.syafiqq.madm.saw.core.factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <saw> project in package <app.freelancer.syafiqq.madm.saw.core.factory> created by :
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 8:25 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Alternative implements Comparable<Alternative>
{
    public abstract void calculateNormalization(@NotNull ProfitContainer alternative);

    public abstract void calculatePreferences(@NotNull WeightContainer alternative);

    public abstract ProfitContainer adaptToProfit();
}
