package app.freelancer.syafiqq.madm.saw.core.factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <saw> project in package <app.freelancer.syafiqq.madm.saw.core.factory> created by :
 * Name         : syafiq
 * Date / Time  : 09 April 2017, 6:59 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Criterion
{
    public abstract void searchProfit(@NotNull Profit criterion);

    public abstract void calculateNormalization(@NotNull Profit criterion);

    public abstract void calculateWeightedNormalization(@NotNull Weight criterion);
}
