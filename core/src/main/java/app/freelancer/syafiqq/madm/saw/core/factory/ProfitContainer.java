package app.freelancer.syafiqq.madm.saw.core.factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <saw> project in package <app.freelancer.syafiqq.madm.saw.core.factory> created by :
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 8:22 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class ProfitContainer<A extends Alternative>
{
    public abstract void searchProfits(@NotNull A alternative);
}
