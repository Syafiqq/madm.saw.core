package app.freelancer.syafiqq.madm.saw.test.case0;

import app.freelancer.syafiqq.madm.saw.test.case0.alternative.Investor;
import app.freelancer.syafiqq.madm.saw.test.case0.container.InvestorProfitContainer;
import app.freelancer.syafiqq.madm.saw.test.case0.container.InvestorWeightContainer;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Availability;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Cost;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Investment;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Need;
import app.freelancer.syafiqq.madm.saw.test.case0.criterion.Productivity;
import app.freelancer.syafiqq.madm.saw.test.case0.identity.Identity;
import app.freelancer.syafiqq.madm.saw.test.case0.profit.ContinuousProfit;
import app.freelancer.syafiqq.madm.saw.test.case0.weight.ContinuousWeight;

/*
 * This <saw> created by : 
 * Name         : syafiq
 * Date / Time  : 12 April 2017, 8:26 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class FactoryHelper
{
    public static Investor createInvestor(String alternativeName, int availability, int cost, int investment, int need, int productivity)
    {
        return new Investor(
                new Identity(alternativeName)
                , new Availability(availability)
                , new Cost(cost)
                , new Investment(investment)
                , new Need(need)
                , new Productivity(productivity)
        );
    }

    public static InvestorProfitContainer createProfitInvestor(double availability, double cost, double investment, double need, double productivity)
    {
        return new InvestorProfitContainer(
                new ContinuousProfit(availability)
                , new ContinuousProfit(cost)
                , new ContinuousProfit(investment)
                , new ContinuousProfit(need)
                , new ContinuousProfit(productivity)
        );
    }

    public static InvestorWeightContainer createWeightInvestor(double availability, double cost, double investment, double need, double productivity)
    {
        return new InvestorWeightContainer(
                new ContinuousWeight(availability)
                , new ContinuousWeight(cost)
                , new ContinuousWeight(investment)
                , new ContinuousWeight(need)
                , new ContinuousWeight(productivity)
        );
    }
}
