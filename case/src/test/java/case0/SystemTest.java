package case0;

import case0.alternative.Investor;
import case0.container.InvestorWeightContainer;
import factory.SAW;
import org.junit.Test;

/*
 * This <saw> created by : 
 * Name         : syafiq
 * Date / Time  : 12 April 2017, 8:27 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class SystemTest
{
    @Test public void it_success()
    {
        Investor a1 = FactoryHelper.createInvestor("Alternative 1", 3, 150, 15, 2, 2);
        Investor a2 = FactoryHelper.createInvestor("Alternative 2", 2, 500, 200, 3, 2);
        Investor a3 = FactoryHelper.createInvestor("Alternative 3", 3, 200, 10, 1, 3);
        Investor a4 = FactoryHelper.createInvestor("Alternative 4", 2, 350, 100, 1, 3);

        InvestorWeightContainer w = FactoryHelper.createWeightInvestor(0.05, 0.25, 0.15, 0.25, 0.30);

        SAW saw = new SAW();

        saw.addAlternative(a1);
        saw.addAlternative(a2);
        saw.addAlternative(a3);
        saw.addAlternative(a4);

        saw.setWeight(w);

        saw.compile();
        saw.calculate();
        saw.ranking();
        saw.sort();

        System.out.println(saw.getBestAlternative());
    }
}
