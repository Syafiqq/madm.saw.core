package factory;

import java.util.LinkedList;
import java.util.List;

/*
 * This <saw> project in package <factory> created by : 
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 4:28 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class SAW
{
    private List<Alternative> alternatives;
    private ProfitContainer   profit;
    private WeightContainer   weight;

    public SAW()
    {
        this.alternatives = new LinkedList<>();
    }

    public void compile()
    {
        if(alternatives.size() > 0)
        {
            this.profit = alternatives.get(0).copyToProfit();
            for(final Alternative alternative : this.alternatives)
            {
                this.profit.searchProfits(alternative);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
    }

    public void process()
    {
        if(alternatives.size() > 0)
        {
            this.compile();
            for(final Alternative alternative : this.alternatives)
            {
                alternative.calculateNormalization(this.profit);
                alternative.calculatePreferences(this.weight);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
    }

    public boolean add(Alternative t)
    {
        return alternatives.add(t);
    }

    public void addWeight(WeightContainer weight)
    {
        this.weight = weight;
    }

    public Alternative getBestAlternative()
    {
        Alternative best = null;
        if(alternatives.size() > 0)
        {
            best = this.alternatives.get(0);
            for(final Alternative alternative : this.alternatives)
            {
                if(alternative.betterThan(best))
                {
                    best = alternative;
                }
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
        return best;
    }

    public ProfitContainer getProfit()
    {
        return profit;
    }

    public WeightContainer getWeight()
    {
        return weight;
    }
}
