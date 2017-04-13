package app.freelancer.syafiqq.madm.saw.core.factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <saw> project in package <app.freelancer.syafiqq.madm.saw.core.factory> created by :
 * Name         : syafiq
 * Date / Time  : 09 April 2017, 6:59 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Criterion<P extends Profit, W extends Weight>
{
    public abstract void searchProfit(@NotNull P criterion);

    public abstract void calculateNormalization(@NotNull P criterion);

    public abstract void calculateWeightedNormalization(@NotNull W criterion);
}
